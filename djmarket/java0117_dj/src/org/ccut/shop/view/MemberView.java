package org.ccut.shop.view;

import org.ccut.shop.domain.Member;
import org.ccut.shop.service.MemberManagerService;
import org.ccut.shop.util.ScannerUtil;
import org.ccut.shop.util.SessionUtil;

import java.util.List;

/**
 * 会员管理页面
 */
public class MemberView {
    /**
     * 创建管理类型
     */
    MemberManagerService memberManagerService = new MemberManagerService();
    /**
     * 验证密码
     */
    public String getValidatePassword(){
        System.out.println("请输入会员密码：");
        String password1 = ScannerUtil.getScannerString();
        System.out.println("请再次输入会员密码：");
        String password2 = ScannerUtil.getScannerString();
        if("".equals(password1)||"".equals(password2)){
            System.out.println("密码不能为空，请重新输入！！");
            return getValidatePassword();
        }else if(!password1.equals(password2)){
            System.out.println("两次密码不一致，请重新输入！！");
            return getValidatePassword();
        }else{
            return password1;
        }
    }

    /**
     * 验证手机号
     */
    public String getValidatePhone(){
        System.out.println("请输入手机号：");
        String phone = ScannerUtil.getScannerString();
        if("".equals(phone)) {
            System.out.println("手机不能为空，请重新输入！！");
            return getValidatePhone();
        }else if(!phone.matches("1[0-9&&[^012]]\\d{9}")){
            System.out.println("手机号格式有误！！");
            return getValidatePhone();
        }else{
            return phone;
        }
    }

    /**
     * 注册会员
     */
    public void register(){
        System.out.println("会员注册：");
        System.out.println("请输入会员账号：");
        String username = ScannerUtil.getScannerString();
        /*
          输入密码并验证
         */
        String password = getValidatePassword();
        System.out.println("请输入会员姓名：");
        String name = ScannerUtil.getScannerString();
        /*
          获得验证后的电话
         */
        String phone = getValidatePhone();
        System.out.println("请输入会员地址：");
        String address = ScannerUtil.getScannerString();
        System.out.println("请输入会员余额：");
        String money = ScannerUtil.getScannerString();

        boolean b = memberManagerService.register(username,password,name,phone,address,money);
        if(b){
            System.out.println("注册成功！！");
        }else{
            System.out.println("注册失败！！");
        }
    }

    /**
     * 登录界面
     */
    public void login(){
        /*
        验证当前是否存在登录信息，如果存在不能重复登录，需要提示先注销再登录
         */
        if(SessionUtil.dataHashtable.get("loginMember")!=null){
            System.out.println("当前已经存在会员信息，请先注销再登录");
            return;
        }
        System.out.println("请输入用户名：");
        String username = ScannerUtil.getScannerString();
        System.out.println("请输入密码：");
        String password = ScannerUtil.getScannerString();
        /*
        验证输入
         */
        if("".equals(username) || "".equals(password)){
            System.out.println("用户名或密码不能为空，请重新输入！！");
            login();
        }else{
            /*
            验证的方法
             */
            Member member = memberManagerService.getMemberInfoByUsernameAndPass(username,password);
            if(member==null){
                System.out.println("用户名或密码错误，请确认后再输入！！");
            }else{
                /*
                把登录数据存入到会话中
                 */
                SessionUtil.dataHashtable.put("loginMember",member);
                System.out.println("登陆成功，欢迎："+member.getName());
            }
        }
    }

    /**
     * 查看会员列表
     */
    public void queryUserList() {
        List<Member> memberList = memberManagerService.queryUserList();
        /*
          遍历会员列表 增强for循环
         */
        System.out.println("合法会员列表如下：");
        System.out.println("账号\t密码\t姓名\t电话\t地址\t余额");
        for(Member m:memberList){
            System.out.println(m.getUsername()+"\t"+m.getPassword()+"\t"+m.getName()+"\t"+m.getPhone()+
            "\t"+m.getAddress()+"\t"+m.getMoney());
        }
    }
}
