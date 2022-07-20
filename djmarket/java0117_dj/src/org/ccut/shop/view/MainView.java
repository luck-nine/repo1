package org.ccut.shop.view;

import org.ccut.shop.datebase.Db;
import org.ccut.shop.util.ScannerUtil;
import org.ccut.shop.util.SessionUtil;

public class MainView {
    public static void initDateBase(){
        int x = Db.initDateBase();
        if(x==0){
            System.out.println("数据库初始化失败......");
        }else if(x==2){
            System.out.println("数据库初始化成功......");
        }else if(x==1){
            System.out.println("数据库初始化商品表失败......");
        }
    }
    private static void exitLogin() {
        if (SessionUtil.dataHashtable.get("loginMember") != null) {
            SessionUtil.dataHashtable.remove("loginMember");
            System.out.println("安全退出成功！！");
        }else{
            System.out.println("尚未登录，无需退出！！");
        }
    }
    public static void main(String[] args) {
        MemberView memberView = new MemberView();
        MerchandiseView merchandiseView = new MerchandiseView();
        for(;;){
            System.out.println("---欢迎登陆xxx网购平台---");
            System.out.println("---1.注册会员---");
            System.out.println("---2.会员登录---");
            System.out.println("---3.合法会员查询---");
            System.out.println("---4.商品浏览---");
            System.out.println("---5.初始化会员和商品数据---");
            System.out.println("---6.会员安全退出---");
            System.out.println("---0.退出当前模块---");
            int key = ScannerUtil.getScannerInt();
            if(key==0){
                break;
            }
            switch (key){
                case 1:
                    memberView.register();
                    break;
                case 2:
                    memberView.login();
                    break;
                case 3:
                    memberView.queryUserList();
                    break;
                case 4:
                    merchandiseView.list();
                    break;
                case 5:
                    initDateBase();
                    break;
                case 6:
                    exitLogin();
                    break;
            }
        }
    }
}
