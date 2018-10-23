package com.joner.mnbj.entity;

public class CircularDataEntity {

    //扇形名
    private String arcName;

    //百分比
    private float arcPercent;

    //扇形背景颜色
    private int backColor;

    //扇形内字体颜色
    private int textColor;

    public String getArcName() {
        return arcName;
    }

    public void setArcName(String arcName) {
        this.arcName = arcName;
    }

    public float getArcPercent() {
        return arcPercent;
    }

    public void setArcPercent(float arcPercent) {
        this.arcPercent = arcPercent;
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return "CircularDataEntity{" +
                "arcName='" + arcName + '\'' +
                ", arcPercent=" + arcPercent +
                ", backColor=" + backColor +
                ", textColor=" + textColor +
                '}';
    }
}
