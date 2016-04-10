package com.vshuok.es.showcase.parentchild.service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.showcase.parentchild.entity.Child;
import com.vshuok.es.showcase.parentchild.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Service
public class ParentService extends BaseService<Parent, Long> {

    @Autowired
    private ChildService childService;


    public void save(Parent parent, List<Child> childList) {
        save(parent);
        saveOrUpdateChild(parent, childList);
    }

    public void update(Parent parent, List<Child> childList) {
        update(parent);
        saveOrUpdateChild(parent, childList);
    }

    private void saveOrUpdateChild(Parent parent, List<Child> childList) {
        for (Child child : childList) {
            if (child == null) {//防止中间有跳过的
                continue;
            }
            child.setParent(parent);
            if (child.getId() == null) {//新的
                childService.save(child);
            } else {
                childService.update(child);
            }
        }
    }
}
