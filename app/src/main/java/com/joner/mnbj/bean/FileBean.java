package com.joner.mnbj.bean;

/**
 * Created by gpfei on 2018/8/21.
 *  文件属性描述
 */

public class FileBean {
    private  int id;
    private int pId;
    private String desc;
    private  String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
