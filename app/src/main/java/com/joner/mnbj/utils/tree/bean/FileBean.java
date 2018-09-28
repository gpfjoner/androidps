package com.joner.mnbj.utils.tree.bean;

import com.joner.mnbj.utils.tree.annotation.TreeNodeId;
import com.joner.mnbj.utils.tree.annotation.TreeNodeLabel;
import com.joner.mnbj.utils.tree.annotation.TreeNodePid;

/**
 * Created by gpfei on 2018/8/21.
 * 文件属性描述
 */

public class FileBean {
    @TreeNodeId
    private int id;
    @TreeNodePid
    private int pId;
    private String label;

    @TreeNodeLabel
    private String desc;

    public FileBean(int id, int pId, String desc) {
        this.id = id;
        this.pId = pId;
        this.desc = desc;

    }


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
