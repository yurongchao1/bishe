package com.chao.bishe.mappers;

import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMasterMapper {

    OrderMaster findOne(String  orderID);

    List<OrderMaster> findAll();

    void insert(OrderMaster orderMaster);

    void update(OrderMaster orderMaster);

    List<OrderMaster> findOrderListByStatus(@Param("buyerOpenid") String buyerOpenid, @Param("orderStatus") Integer orderStatus);
}
