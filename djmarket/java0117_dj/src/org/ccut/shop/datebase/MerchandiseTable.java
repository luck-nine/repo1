package org.ccut.shop.datebase;

import org.ccut.shop.domain.Merchandise;

import java.util.TreeSet;

public class MerchandiseTable {
    public static Merchandise selectMerchandiseById(String id) {
        TreeSet<Merchandise> merchandiseTreeSet = Db.merchandiseTreeSet;
        /*
        遍历
         */
        for(Merchandise m:merchandiseTreeSet){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }
}
