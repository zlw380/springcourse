package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public BuyGoodsServiceImpl() {
    }

    public BuyGoodsServiceImpl(GoodsDao goodsDao, SaleDao saleDao) {
        this.goodsDao = goodsDao;
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    /*@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    //Class类型的对象数组
                    //Class对象是用来创建类的常规对象的
                    //当我们编译一个Java类就会同时产生一个与该类相对应的Class对象
                    //(保存在.class文件中,即.java文件编译后的.class文件中)
                    //该Class对象中保存了创建对象所需的所有信息。
                    NullPointerException.class,NotEnoughException.class
            }
    )*/

    //均使用默认值
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("方法开始=========================");

        //添加销售记录
        //购买了什么商品，买了多少份
        Sale sale = new Sale(goodsId,nums);
        int saleNums = saleDao.insertSale(sale);
        System.out.println("添加了"+saleNums+"条销售记录");
        //查询销售记录
        /*List<Sale> saleList = saleDao.selectAll();
        for (Sale sl:saleList
             ) {
            System.out.println(sl);
        }*/

        //查询对应商品信息
        Goods selectResult = goodsDao.selectGoods(goodsId);
        if(selectResult == null){
            //商品不存在
            throw new NullPointerException("编号是："+goodsId+"的商品不存在");
        }else if(selectResult.getAmount() < nums){
            //商品库存不足
            throw new NotEnoughException("编号是："+goodsId+"的商品库存不足");
        }
        System.out.println(selectResult);
        //更新库存
        //库存数量减去购买的份数
        //其实使用set方法赋值可以更直观地看出传入的参数与实体类属性的对应关系
        Goods goods = new Goods(goodsId,nums);
        int goodsNums = goodsDao.updateGoods(goods);
        System.out.println("更新了"+goodsNums+"条库存信息");
        //再次查询
        Goods selectResult1 = goodsDao.selectGoods(goodsId);
        System.out.println(selectResult1);

        System.out.println("方法结束=========================");
    }
}
