package org.ccut.shop.service;

import org.ccut.shop.datebase.Db;
import org.ccut.shop.datebase.MerchandiseTable;
import org.ccut.shop.domain.Merchandise;

import java.util.TreeSet;

/**
 * 商品信息管理类型
 */
public class MerchandiseManagerService {
    public TreeSet<Merchandise> list() {
        return Db.merchandiseTreeSet;
    }
    public static Merchandise getMerchandiseById(String id) {
        return MerchandiseTable.selectMerchandiseById(id);
    }
}
