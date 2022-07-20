package org.ccut.shop.view;

import org.ccut.shop.domain.Member;
import org.ccut.shop.domain.Merchandise;
import org.ccut.shop.domain.ShopItem;
import org.ccut.shop.service.CarManagerService;
import org.ccut.shop.service.MerchandiseManagerService;
import org.ccut.shop.util.ScannerUtil;
import org.ccut.shop.util.SessionUtil;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Hashtable;

public class ShopCarView {
    MerchandiseManagerService merchandiseManagerService = new MerchandiseManagerService();
    CarManagerService carManagerService = new CarManagerService();
    BigDecimal totalPrice = new BigDecimal("0.0");

    /**
     * 加入购物车
     */
    public void addCart() {
        System.out.println("请输入商品编号：");
        String id = ScannerUtil.getScannerString();
        /*
        根据商品编号获得商品对象
         */
        Merchandise merchandise = merchandiseManagerService.getMerchandiseById(id);
        if(merchandise==null){
            System.out.println("不存在该商品，请确认商品编号");
            addCart();
        }else{
            System.out.println("请输入购买数量：");
            int num = ScannerUtil.getScannerInt();
            boolean b = carManagerService.addShopCar(merchandise,num);
            if(b){
                System.out.println(merchandise.getName()+"加入购物车成功！！");
            }else{
                System.out.println(merchandise.getName()+"加入购物车失败！！");
            }
        }
    }

    public void list() {
        while(true) {
            System.out.println("商品编号\t商品名称\t数量\t单价\t总价格\t");
            Hashtable<String, ShopItem> shopItemHashtable = carManagerService.list();
            Collection<ShopItem> shopItemCollection = shopItemHashtable.values();
            totalPrice = new BigDecimal("0.0");
            for (ShopItem item : shopItemCollection) {
                Merchandise m = item.getMerchandise();
                System.out.println(m.getId() + "\t" + m.getName() + "\t" + item.getNum() + "\t" + m.getPrice() + "\t" + item.getPrice());
                totalPrice = totalPrice.add(item.getPrice());
            }
            System.out.println("总价格：" + totalPrice);
            System.out.println("购物车操作如下：");
            System.out.println("1.清空购物车");
            System.out.println("2.移除单件商品");
            System.out.println("3.修改商品数量");
            System.out.println("4.去结算");
            System.out.println("0.退出购物车列表");
            int key = ScannerUtil.getScannerInt();
            if(key==0){
                break;
            }
            switch (key){
                case 1:
                    boolean b = clearShopCar();
                    if(b==true){
                        System.out.println("清空购物车成功！！");
                    }else{
                        System.out.println("清空购物车失败！！");
                    }
                    break;
                case 2:
                    boolean b2 = removeMerchandise();
                    if(b2){
                        System.out.println("商品移除成功！！");
                    }else{
                        System.out.println("商品移除失败！！");
                    }
                    break;
                case 3:
                    boolean b3 = updateMerchandiseNum();
                    if(b3){
                        System.out.println("商品数量修改成功！！");
                    }else{
                        System.out.println("商品数量修改失败！！");
                    }
                    break;
                case 4:
                    orderShopCar();
                    break;
            }
        }
    }

    private void orderShopCar() {
        /*
        验证当前是否存在登录信息，如果存在不能重复登录，需要提示先注销再登录
         */
        if(SessionUtil.dataHashtable.get("loginMember")==null){
            System.out.println("尚未登录，请先登录再进行操作！！");
            return;
        }else{
            Member m = (Member) SessionUtil.dataHashtable.get("loginMember");
            /*
            获得用户的钱
             */
            BigDecimal memberPrice = m.getMoney();
            /*
            算总额 totalPrice
            判断BigDecimal大小  >=
             */
            if(memberPrice.compareTo(totalPrice) > -1){
                /*
                可以结算
                 */
                m.setMoney(m.getMoney().subtract(totalPrice));
                System.out.println("卡内余额为："+m.getMoney());
                /*
                清空购物车
                 */
                clearShopCar();
            }else{
                /*
                先充值
                 */
                System.out.println("余额不足，请充值！！请输入存款金额：");
                String saveMoney = ScannerUtil.getScannerString();
                BigDecimal bigDecimal_saveMoney = new BigDecimal(saveMoney);
                m.setMoney(bigDecimal_saveMoney.add(m.getMoney()));
                orderShopCar();
            }
        }
    }

    /**
     * 修改商品数量
     */
    private boolean updateMerchandiseNum() {
        System.out.println("请输入要修改商品的编号：");
        /*
        获取一下    不存在则重新输入
         */
        String id = ScannerUtil.getScannerString();
        ShopItem item = carManagerService.getMerchandiseFromCarById(id);
        if(item==null){
            System.out.println("购物车不存在该商品，请重新确认商品编号");
            return updateMerchandiseNum();
        }else{
            System.out.println("请输入修改的数量：");
            int num = ScannerUtil.getScannerInt();
            Merchandise m = item.getMerchandise();
            BigDecimal bigDecimal_num = new BigDecimal(num);
            BigDecimal newPrice = bigDecimal_num.multiply(m.getPrice());
            item.setNum(num);
            item.setPrice(newPrice);
            return true;
        }
    }

    /**
     * 移除商品
     */
    private boolean removeMerchandise() {
        System.out.println("请输入要移除商品的编号：");
        String id = ScannerUtil.getScannerString();
        boolean b = carManagerService.removeMerchandise(id);
        return b;
    }

    /**
     * 清空购物车
     */
    private boolean clearShopCar(){
        return carManagerService.clearShopCar();
    }
}
