package com.rain.pojo;

import java.io.Serializable;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/28 0:31
 */
public class SuperUser implements Serializable {
    private Integer id ;
    private String userName ;
    private String password ;
    private String phone ;
    private String conding ;
    private String address ;
    private String shop_class;

    public SuperUser(Integer id, String userName, String password, String phone, String conding, String address, String shop_class) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.conding = conding;
        this.address = address;
        this.shop_class = shop_class;
    }

    public SuperUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConding() {
        return conding;
    }

    public void setConding(String conding) {
        this.conding = conding;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShop_class() {
        return shop_class;
    }

    public void setShop_class(String shop_class) {
        this.shop_class = shop_class;
    }
}
