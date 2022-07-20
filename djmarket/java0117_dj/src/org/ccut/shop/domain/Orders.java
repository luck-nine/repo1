package org.ccut.shop.domain;

import java.util.Date;

/**
 * 订单信息
 */
public class Orders {
    private String id;
    private ShopCar shopCar;
    private String address;
    private Date date;
    private int status;

    public Orders() {
    }

    public Orders(String id, ShopCar shopCar, String address, Date date, int status) {
        this.id = id;
        this.shopCar = shopCar;
        this.address = address;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShopCar getShopCar() {
        return shopCar;
    }

    public void setShopCar(ShopCar shopCar) {
        this.shopCar = shopCar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
