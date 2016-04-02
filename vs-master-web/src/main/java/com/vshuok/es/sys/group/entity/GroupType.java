package com.vshuok.es.sys.group.entity;
/** 
 * <p>用户组分类</p>
 * @author Hu Dawei  
 * @version 1.0
 */
public enum GroupType {

    user("用户组"), organization("组织机构组");

    private final String info;

    private GroupType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
