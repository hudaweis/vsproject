package com.vshuok.es.showcase.parentchild.entity;

/**
 * 父子表测试使用的enum
 */
public enum ParentChildType {
    type1("测试类型1"), type2("测试类型2");

    private final String info;

    private ParentChildType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
