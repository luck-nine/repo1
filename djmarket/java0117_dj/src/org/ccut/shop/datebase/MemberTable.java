package org.ccut.shop.datebase;

import org.ccut.shop.domain.Member;

import java.util.List;

/**
 * 增删改查操作
 */
public class MemberTable {
    public static boolean insert(Member member){
        /*
          调用Db数据
         */
        return Db.memberTable.add(member);
    }
    /**
     * 调用Db数据
     */
    public static List<Member> selectList() {
        return Db.memberTable;
    }

    public static Member slectMemberInfoByUsernameAndPass(String username, String password) {
        /*
          调用Db数据
         */
        List<Member> memberList = Db.memberTable;
        /*
        遍历  看哪个会员username和password与输入相匹配
         */
        for(Member m:memberList){
            if(username.equals(m.getUsername()) && password.equals(m.getPassword())){
                return m;
            }
        }
        return null;
    }
}
