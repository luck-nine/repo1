package org.ccut.shop.datebase;

import org.ccut.shop.domain.Merchandise;
import org.ccut.shop.domain.ShopItem;

import java.util.Hashtable;

public class CartTable {
    public static ShopItem getCartById(String id){
        return Db.cartTable.get(id);
    }

    public static void insert(ShopItem shopItem) {
        Db.cartTable.put(shopItem.getMerchandise().getId(),shopItem);
    }

    public static Hashtable<String, ShopItem> selectAll() {
        return Db.cartTable;
    }

    public static boolean deleteShopCar() {
        Db.cartTable.clear();
        return true;
    }

    public static boolean deleteMerchandise(String id) {
        /*
        验证购物车集合中不存在该商品
         */
        if(!Db.cartTable.containsKey(id)){
            return false;
        }else{
            return Db.cartTable.remove(id)!=null?true:false;
        }
    }

    public static ShopItem selectMerchandiseFromCarById(String id) {
        return Db.cartTable.get(id);
    }
}
