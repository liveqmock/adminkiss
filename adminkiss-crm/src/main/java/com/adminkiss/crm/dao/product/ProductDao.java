package com.adminkiss.crm.dao.product;

import com.adminkiss.crm.domain.product.Product;

public interface ProductDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

}