package org.ccut.shop.view;

import org.ccut.shop.domain.Merchandise;
import org.ccut.shop.service.MerchandiseManagerService;
import org.ccut.shop.util.ScannerUtil;
import org.ccut.shop.util.SessionUtil;

import java.util.TreeSet;

public class MerchandiseView {
    /**
     * 创建一个管理类型
     */
    MerchandiseManagerService merchandiseManagerService = new MerchandiseManagerService();
    ShopCarView shopCarView = new ShopCarView();
    public void list() {
        System.out.println("商品列表如下：");
        TreeSet<Merchandise> merchandiseTreeSet = merchandiseManagerService.list();
        System.out.println("商品编号\t商品名称\t价格\t库存\t");
        for(Merchandise m:merchandiseTreeSet){
            System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getPrice()+"\t"+m.getNum());
        }
        System.out.println("1.添加购物车\n"+
                            "2.查看购物车");
        int key = ScannerUtil.getScannerInt();
        /*
        验证当前是否存在登录信息，如果存在不能重复登录，需要提示先注销再登录
         */
        if(SessionUtil.dataHashtable.get("loginMember")==null){
            System.out.println("尚未登录，请先登录再进行操作！！");
            return;
        }
        if(key==1){
            /*
            商品添加购物车
             */
            shopCarView.addCart();
        }else if(key==2){
            /*
            查看购物车
             */
            shopCarView.list();
        }
    }
}
