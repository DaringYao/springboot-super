package com.rain.pojo;

import java.io.Serializable;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/22 1:20
 */
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String img_url;
    private String category_id;
    private String group_class;

    public Goods(Integer id, String name, Double price, String img_url, String category_id, String group_class) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img_url = img_url;
        this.category_id = category_id;
        this.group_class = group_class;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getGroup_class() {
        return group_class;
    }

    public void setGroup_class(String group_class) {
        this.group_class = group_class;
    }
}
