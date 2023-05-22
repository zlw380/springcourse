package org.example;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.service.BuyGoodsService;
import org.example.service.GoodsService;
import org.example.service.SaleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
        List<Goods> goods = goodsService.selectAll();
        for (Goods goods1:goods
             ) {
            System.out.println(goods1);
        }
    }

    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String name:names
//        ) {
//            System.out.println(name+"|"+applicationContext.getBean(name).getClass().getName());
//        }
        SaleService saleService = (SaleService) applicationContext.getBean("saleService");
        List<Sale> saleList = saleService.selectAll();
        for (Sale sale:saleList
             ) {
            System.out.println(sale);
        }
    }

    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        SaleService saleService = (SaleService) applicationContext.getBean("saleService");

        Sale sale  = new Sale(557,557);
        int nums = saleService.insertSale(sale);
        System.out.println("添加的记录条数为："+nums);
    }

    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        BuyGoodsService buyGoodsService = (BuyGoodsService) applicationContext.getBean("buyGoodsService");
        buyGoodsService.buy(1001,1);
    }
}
