package com.adminkiss.crm.dao.product;

import com.adminkiss.crm.domain.product.ProblemOrder;

public interface ProblemOrderDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(ProblemOrder record);

    ProblemOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProblemOrder record);

}