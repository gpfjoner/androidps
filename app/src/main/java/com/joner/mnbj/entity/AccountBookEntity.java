package com.joner.mnbj.entity;

import java.util.ArrayList;
import java.util.List;

public class AccountBookEntity {

    private String content;
    private float money;

    //类型 用于区分header
    private int type;

    private String date;
    private List<AccountBookEntity> childDetail = new ArrayList<>();

    public AccountBookEntity() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<AccountBookEntity> getChildDetail() {
        return childDetail;
    }

    public void setChildDetail(List<AccountBookEntity> childDetail) {
        this.childDetail = childDetail;
    }

    @Override
    public String toString() {
        return "AccountBookEntity{" +
                "content='" + content + '\'' +
                ", money=" + money +
                ", type=" + type +
                ", date='" + date + '\'' +
                ", childDetail=" + childDetail +
                '}';
    }
}
