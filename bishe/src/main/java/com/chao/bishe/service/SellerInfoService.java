package com.chao.bishe.service;

import com.chao.bishe.dao.OrderDetailDao;
import com.chao.bishe.dao.SellerInfoDao;
import com.chao.bishe.domain.OrderDetail;
import com.chao.bishe.domain.SellerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerInfoService {
    @Autowired
    private SellerInfoDao sellerInfoDao;


    public SellerInfo findByUsername(String username){
        return sellerInfoDao.findByUsername(username);
    }

}
