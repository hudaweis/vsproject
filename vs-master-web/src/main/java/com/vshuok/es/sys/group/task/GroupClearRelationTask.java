package com.vshuok.es.sys.group.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vshuok.es.sys.group.repository.GroupRelationRepository;

/** 
 * <p>清理无关联的关系</p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Service
public class GroupClearRelationTask {

    @Autowired
    private GroupRelationRepository groupRelationRepository;

    /**
     * 清除删除的分组对应的关系
     */
    public void clearDeletedGroupRelation() {
        groupRelationRepository.clearDeletedGroupRelation();
    }
}
