package com.chao.bishe.service;

import com.chao.bishe.dao.RestaurantInfoDao;
import com.chao.bishe.domain.RestaurantInfo;
import com.chao.bishe.mappers.RestaurantInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantInfoService {
    @Autowired
    private RestaurantInfoDao dao;

    public RestaurantInfo findOne(Integer categoryId){
        return dao.findOne(categoryId);
    }



    public void  update(RestaurantInfo restaurantInfo){
        dao.update(restaurantInfo);
    }
}
