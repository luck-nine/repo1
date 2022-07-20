package org.ccut.shop.service;

import org.ccut.shop.datebase.MemberTable;
import org.ccut.shop.domain.Member;

import java.math.BigDecimal;
import java.util.List;

public class MemberManagerService {


    public boolean register(String username, String password, String name, String phone, String address, String money) {
        /*
          实例化会员
         */
        Member member = new Member(username,password,name,phone,address,new BigDecimal(money));
        /*
          调用集合模拟的数据库，存数据
         */
        boolean b = MemberTable.insert(member);
        return b;
    }

    /**
     * 查询用户列表
     */
    public List<Member> queryUserList() {
        return MemberTable.selectList();
    }

    /**
     * 验证登录
     */
    public Member getMemberInfoByUsernameAndPass(String username, String password) {
        return MemberTable.slectMemberInfoByUsernameAndPass(username,password);
    }
}
