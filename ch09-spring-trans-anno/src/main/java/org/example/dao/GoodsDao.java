package org.example.dao;

import org.example.domain.Goods;
import org.example.service.GoodsService;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectAll();
    //更新库存
    //goods表示本次用户购买的商品信息
    int updateGoods(Goods goods);
    //查询商品信息
    Goods selectGoods(Integer id);
}
