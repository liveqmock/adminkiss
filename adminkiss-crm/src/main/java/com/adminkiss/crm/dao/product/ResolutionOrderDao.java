package com.adminkiss.crm.dao.product;

import com.adminkiss.crm.domain.product.ResolutionOrder;

public interface ResolutionOrderDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(ResolutionOrder record);

    ResolutionOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResolutionOrder record);

}