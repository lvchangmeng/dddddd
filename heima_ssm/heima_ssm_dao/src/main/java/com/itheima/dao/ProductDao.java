package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    //查询所有的产品信息
    public List<Product> findAll();
}
