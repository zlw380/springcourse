package org.example.service.impl;

import org.example.dao.SaleDao;
import org.example.domain.Sale;
import org.example.service.SaleService;

import java.util.List;

public class SaleServiceImpl implements SaleService {
    private SaleDao saleDao;

    public SaleServiceImpl() {
    }

    public SaleServiceImpl(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public List<Sale> selectAll(){
        List<Sale> saleList = saleDao.selectAll();
        return saleList;
    }

    public int insertSale(Sale sale){
        int nums = saleDao.insertSale(sale);
        return nums;
    }
}
