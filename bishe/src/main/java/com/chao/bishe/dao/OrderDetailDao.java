package com.chao.bishe.dao;

import com.chao.bishe.domain.OrderDetail;
import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.mappers.OrderDetailMapper;
import com.chao.bishe.mappers.OrderMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailDao {
    @Autowired
    private OrderDetailMapper mapper;

    public  void insert(OrderDetail orderDetail){
        mapper.insert(orderDetail);
    }


}
