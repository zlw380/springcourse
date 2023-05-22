package org.example.service;

import org.example.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectAll();
    //更新库存
    int updateGoods(Goods goods);
}
