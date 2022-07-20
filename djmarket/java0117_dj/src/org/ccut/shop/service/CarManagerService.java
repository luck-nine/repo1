package org.ccut.shop.service;

import org.ccut.shop.datebase.CartTable;
import org.ccut.shop.datebase.Db;
import org.ccut.shop.domain.Merchandise;
import org.ccut.shop.domain.ShopItem;

import java.math.BigDecimal;
import java.util.Hashtable;

public class CarManagerService {

    public boolean addShopCar(Merchandise merchandise, int num) {
        /*
        验证购物车是否存在商品 存在数量加一  不存在新建一个
         */
        ShopItem shopItem = CartTable.getCartById(merchandise.getId());
        if(shopItem!=null){
            shopItem.setNum(shopItem.getNum()+num);
            /*
            总价格
             */
            BigDecimal bigDecimal_num = new BigDecimal(shopItem.getNum());
            shopItem.setPrice(merchandise.getPrice().multiply(bigDecimal_num));
        }else{
            ShopItem si = new ShopItem();
            si.setMerchandise(merchandise);
            si.setNum(num);
            BigDecimal bigDecimal_num = new BigDecimal(num);
            si.setPrice(merchandise.getPrice().multiply(bigDecimal_num));
            CartTable.insert(si);
        }
        return true;
    }

    public Hashtable<String, ShopItem> list() {
        return CartTable.selectAll();
    }

    public boolean clearShopCar() {
        return CartTable.deleteShopCar();
    }

    public boolean removeMerchandise(String id) {
        return CartTable.deleteMerchandise(id);
    }

    public ShopItem getMerchandiseFromCarById(String id) {
        return CartTable.selectMerchandiseFromCarById(id);
    }
}
