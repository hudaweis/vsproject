package com.vshuok.es.sys.group.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vshuok.es.common.entity.search.SearchOperator;
import com.vshuok.es.common.entity.search.Searchable;
import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.sys.group.entity.Group;
import com.vshuok.es.sys.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
@Service
public class GroupService extends BaseService<Group, Long> {

	@Autowired
	private GroupRelationService groupRelationService;

	private GroupRepository getGroupRepository() {
		return (GroupRepository) baseRepository;
	}

	public Set<Map<String, Object>> findIdAndNames(Searchable searchable,
			String groupName) {

		searchable.addSearchFilter("name", SearchOperator.like, groupName);

		return Sets.newHashSet(Lists.transform(
				findAll(searchable).getContent(),
				new Function<Group, Map<String, Object>>() {
					@Override
					public Map<String, Object> apply(Group input) {
						Map<String, Object> data = Maps.newHashMap();
						data.put("label", input.getName());
						data.put("value", input.getId());
						return data;
					}
				}));
	}

	/**
	 * 获取可用的的分组编号列表
	 *
	 * @param userId
	 * @param organizationIds
	 * @return
	 */
	public Set<Long> findShowGroupIds(Long userId, Set<Long> organizationIds) {
		Set<Long> groupIds = Sets.newHashSet();
		groupIds.addAll(getGroupRepository().findDefaultGroupIds());
		groupIds.addAll(groupRelationService.findGroupIds(userId,
				organizationIds));

		// TODO 如果分组数量很多 建议此处查询时直接带着是否可用的标识去查
		for (Group group : findAll()) {
			if (Boolean.FALSE.equals(group.getShow())) {
				groupIds.remove(group.getId());
			}
		}

		return groupIds;
	}
}
