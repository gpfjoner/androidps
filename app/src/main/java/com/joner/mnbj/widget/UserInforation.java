package com.joner.mnbj.widget;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gpfei on 2018/8/16.
 */

@Entity
public class UserInforation {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private int age;
    @Generated(hash = 240572308)
    public UserInforation(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 1182547297)
    public UserInforation() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
