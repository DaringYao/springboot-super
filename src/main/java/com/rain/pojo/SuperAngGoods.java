package com.rain.pojo;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/4/7 5:56
 */
public class SuperAngGoods {
    private int id;
    private String super_name;
    private String category_id;

    public SuperAngGoods(int id, String super_name, String category_id) {
        this.id = id;
        this.super_name = super_name;
        this.category_id = category_id;
    }

    public SuperAngGoods() {
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

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
