package org.ccut.shop.domain;

import java.math.BigDecimal;

/**
 * 商品信息
 */
public class Merchandise implements Comparable{
    /**
     * 编号
     */
    private String id;
    private String name;
    private BigDecimal price;
    /**
     * 类别
     */
    private String category;
    private int num;

    @Override
    public int compareTo(Object o) {
        Merchandise m = (Merchandise) o;
        return id.compareTo(m.id);
    }

    public Merchandise() {
    }

    public Merchandise(String id, String name, BigDecimal price, String category, int num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
