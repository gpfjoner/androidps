package com.joner.mnbj.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gpfei on 2018/8/21.
 */

public class Node {
    private int id;
    /**
     * 层级
     */
    private int pId = 0;
    private String name;

    /**
     * 树的层级
     */
    private int level;
    /**
     * 是否展开
     * 默认设置为不展开
     */
    private boolean isExpand = false;

    /**
     * 图标
     */
    private int icon;

    private Node parent;
    private List<Node> childern = new ArrayList<Node>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildern() {
        return childern;
    }

    public void setChildern(List<Node> childern) {
        this.childern = childern;
    }

}
