package org.ccut.shop.domain;

import java.math.BigDecimal;
import java.util.Hashtable;

public class ShopCar {
    private Hashtable<String,ShopItem> shopItemHashtable = new Hashtable<>();
    private BigDecimal totalMoney = new BigDecimal("0.0");
    /**
     * 购物车状态 0 1
     */
    private int status;
    private Member member;

    public ShopCar(){
    }
    public ShopCar(Member member) {
        this.member = member;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Hashtable<String, ShopItem> getShopItemHashtable() {
        return shopItemHashtable;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public int getStatus() {
        return status;
    }

    public Member getMember() {
        return member;
    }
}
