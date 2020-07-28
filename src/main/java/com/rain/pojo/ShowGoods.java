package com.rain.pojo;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 澜阙望月
 * @since 2020/4/22 10:46
 */
public class ShowGoods {
    private int id;



    private String super_name;
    private String distance;
    private List<Goods> list;

    public ShowGoods() {
    }

    public ShowGoods(int id,String super_name, String distance, List<Goods> list) {
        this.super_name = super_name;
        this.distance = distance;
        this.list = list;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuper_name() {
        return super_name;
    }

    public void setSuper_name(String super_name) {
        this.super_name = super_name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }
}
