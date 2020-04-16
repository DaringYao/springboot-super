package com.rain.pojo;

import javax.naming.Name;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/20 1:41
 */
public class Comm {
    private Integer id;
    private String cod;
    private String price;
    private String name;
    private String img;

    public Comm(Integer id, String cod, String price, String name, String img) {
        this.id = id;
        this.cod = cod;
        this.price = price;
        this.name = name;
        this.img = img;
    }
    public Comm() {}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

}
