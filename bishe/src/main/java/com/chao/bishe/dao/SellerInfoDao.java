package com.chao.bishe.dao;

import com.chao.bishe.domain.OrderDetail;
import com.chao.bishe.domain.SellerInfo;
import com.chao.bishe.mappers.OrderDetailMapper;
import com.chao.bishe.mappers.SellerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class SellerInfoDao {
    @Autowired
    private SellerInfoMapper mapper;

    public SellerInfo findByUsername(String username){
        return mapper.findByUsername(username);
    }


}
