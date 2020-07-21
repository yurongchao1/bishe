package com.chao.bishe.dao;

import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.mappers.OrderMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMasterDao {
    @Autowired
    private OrderMasterMapper mapper;

    public OrderMaster findOne(String categoryId){
        return mapper.findOne(categoryId);
    }

    public List<OrderMaster> findAll(){
        return mapper.findAll();
    }

    public  void insert(OrderMaster orderMaster){
        mapper.insert(orderMaster);
    }
    public   void update(OrderMaster orderMaster){
        mapper.update(orderMaster);
    }

    public List<OrderMaster> findOrderListByStatus(String buyerOpenid, Integer orderStatus) {
        return mapper.findOrderListByStatus( buyerOpenid,  orderStatus);
    }
}
