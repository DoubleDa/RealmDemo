package com.dyx.rdp.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * project name：RealmDemoProject
 * class describe：
 * create person：dayongxin
 * create time：16/9/12 下午11:12
 * alter person：dayongxin
 * alter time：16/9/12 下午11:12
 * alter remark：
 */
public class User extends RealmObject {
    private String name;
    private int age;
    @Ignore
    private int sessionId;

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

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * A Realm model class also supports public, protected and private fields as well as custom methods.
     */
    public boolean hasLongName() {
        return name.length() > 7;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
