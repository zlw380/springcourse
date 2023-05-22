package org.example.service;

import org.example.domain.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> selectAll();
    int insertSale(Sale sale);
}
