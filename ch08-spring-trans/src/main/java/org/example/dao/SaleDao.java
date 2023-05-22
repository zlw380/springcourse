package org.example.dao;

import org.example.domain.Sale;

import java.util.List;

public interface SaleDao {
    List<Sale> selectAll();
    //增加销售记录
    int insertSale(Sale sale);
}
