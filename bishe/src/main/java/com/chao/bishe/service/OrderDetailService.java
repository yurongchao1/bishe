package com.chao.bishe.service;

import com.chao.bishe.dao.OrderDetailDao;
import com.chao.bishe.dao.ProductCategoryDao;
import com.chao.bishe.domain.OrderDetail;
import com.chao.bishe.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailDao OrderDetailDao;


    public  void insert(OrderDetail orderDetail){
        OrderDetailDao.insert(orderDetail);
    }


}
