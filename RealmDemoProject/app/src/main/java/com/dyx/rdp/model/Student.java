package com.dyx.rdp.model;

import io.realm.RealmObject;

/**
 * project name：RealmDemoProject
 * class describe：
 * create person：dayongxin
 * create time：16/9/12 下午11:59
 * alter person：dayongxin
 * alter time：16/9/12 下午11:59
 * alter remark：
 */
public class Student extends RealmObject {
    /**
     * 把 RealmObject 当作 POJO 使用
     */
    public String name;
    public int age;
    public String phoneNum;
}
