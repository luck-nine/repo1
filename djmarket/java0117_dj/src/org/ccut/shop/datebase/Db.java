package org.ccut.shop.datebase;

import org.ccut.shop.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

public class Db {
    public static List<Member> memberTable = new ArrayList<>();
    public static TreeSet<Merchandise> merchandiseTreeSet = new TreeSet<>();
    public static Hashtable<String, ShopItem> cartTable = new Hashtable<>();
    public static List<Orders> ordersTable = new ArrayList<>();

    /**
     * 初始化会员
     */
    public static void initMemberTable(){
        Member m1 = new Member("admin","admin","开九","13944854987","东桥",new BigDecimal("1000.0"));
        Member m2 = new Member("boob","12345","bob","13766404987","南桥",new BigDecimal("1000.0"));
        memberTable.add(m1);
        memberTable.add(m2);
    }
    /**
     * 初始化商品
     */
    public static void initMerchandiseTable(){
        Merchandise m1 = new Merchandise("m1001","iphone4",new BigDecimal("3000.0"),"手机",100);
        Merchandise m2 = new Merchandise("m1002","iphone5",new BigDecimal("5000.0"),"手机",100);
        merchandiseTreeSet.add(m1);
        merchandiseTreeSet.add(m2);
    }

    /**
     * 初始化 只初始化会员和商品
     */
    public static int initDateBase(){
        int result = 0;
        try {
            initMemberTable();
            result = 1;
            initMerchandiseTable();
            result = 2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
