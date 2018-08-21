package com.joner.mnbj.widget;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gpfei on 2018/8/16.
 * 记账详情
 */
@Entity
public class RecordInfor {
    @Id(autoincrement = true)
    private Long id;
    private String name;//用户
    private int money_type;//存还是取
    private long money;//钱
    private String input_time;//创建时间
    private String content;//内容描述
    private String type;//钱类型   PS： 吃饭 。买菜。 超市
    @Generated(hash = 500455427)
    public RecordInfor(Long id, String name, int money_type, long money,
            String input_time, String content, String type) {
        this.id = id;
        this.name = name;
        this.money_type = money_type;
        this.money = money;
        this.input_time = input_time;
        this.content = content;
        this.type = type;
    }
    @Generated(hash = 393930081)
    public RecordInfor() {
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
    public int getMoney_type() {
        return this.money_type;
    }
    public void setMoney_type(int money_type) {
        this.money_type = money_type;
    }
    public long getMoney() {
        return this.money;
    }
    public void setMoney(long money) {
        this.money = money;
    }
    public String getInput_time() {
        return this.input_time;
    }
    public void setInput_time(String input_time) {
        this.input_time = input_time;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

}

