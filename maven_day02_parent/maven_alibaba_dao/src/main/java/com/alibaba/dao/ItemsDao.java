package com.alibaba.dao;

import com.alibaba.domaim.Items;

public interface ItemsDao {
    /**
     * 根据id查询
     * @param id
     */
    public Items findById(Integer id);
}
