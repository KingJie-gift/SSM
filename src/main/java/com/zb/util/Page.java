package com.zb.util;

import java.util.List;

public class Page<T> {
    private int sumCount;
    private int sumPage;
    private int row;
    private int indexPage;
    private List<T> list;

    public int getSumCount() {
        return sumCount;
    }

    public void setSumCount(int sumCount) {
        this.sumCount = sumCount;
        this.sumPage = this.sumCount%this.row==0?this.sumCount/this.row:this.sumCount/this.row+1;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
