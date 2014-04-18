package com.adminkiss.crm.dao.product;

import com.adminkiss.crm.domain.product.CustomerBuyProduct;

public interface CustomerBuyProductDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(CustomerBuyProduct record);

    CustomerBuyProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerBuyProduct record);

}