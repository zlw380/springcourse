package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao;

    public GoodsServiceImpl() {
    }

    public GoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public List<Goods> selectAll() {
        List<Goods> goods = goodsDao.selectAll();
        return goods;
    }

    @Override
    public int updateGoods(Goods goods) {
        return 0;
    }

}
