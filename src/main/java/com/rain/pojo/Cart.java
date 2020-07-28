package com.rain.pojo;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 澜阙望月
 * @since 2020/4/22 16:56
 */
public class Cart {
    /*id
super_name
category_id
username */
    private int id;
    private String super_name;
    private String category_id;
    private String username;

    public Cart() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
