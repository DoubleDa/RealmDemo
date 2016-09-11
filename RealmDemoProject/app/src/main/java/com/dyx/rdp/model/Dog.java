package com.dyx.rdp.model;

import io.realm.RealmObject;

/**
 * project name：RealmDemoProject
 * class describe：
 * create person：dayongxin
 * create time：16/9/11 下午4:51
 * alter person：dayongxin
 * alter time：16/9/11 下午4:51
 * alter remark：
 */
public class Dog extends RealmObject {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
