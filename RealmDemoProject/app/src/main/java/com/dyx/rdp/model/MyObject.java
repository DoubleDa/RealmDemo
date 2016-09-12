package com.dyx.rdp.model;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;

/**
 * project name：RealmDemoProject
 * class describe：
 * create person：dayongxin
 * create time：16/9/12 下午11:52
 * alter person：dayongxin
 * alter time：16/9/12 下午11:52
 * alter remark：
 */
public class MyObject implements RealmModel {
    @PrimaryKey
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
