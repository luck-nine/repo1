package org.ccut.shop.domain;

import java.math.BigDecimal;

/**
 * 购物项
 */
public class ShopItem {
    private Merchandise merchandise;
    private int num;
    private BigDecimal price;

    public ShopItem(){
    }
    public ShopItem(Merchandise merchandise, int num, BigDecimal price) {
        this.merchandise = merchandise;
        this.num = num;
        this.price = price;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
