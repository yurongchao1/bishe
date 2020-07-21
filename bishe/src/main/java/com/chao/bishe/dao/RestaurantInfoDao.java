package com.chao.bishe.dao;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.RestaurantInfo;
import com.chao.bishe.mappers.ProductCategoryMapper;
import com.chao.bishe.mappers.RestaurantInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RestaurantInfoDao {
    @Autowired
    private RestaurantInfoMapper mapper;

    public RestaurantInfo findOne(Integer categoryId){
        return mapper.findOne(categoryId);
    }



    public void  update(RestaurantInfo restaurantInfo){
        mapper.update(restaurantInfo);
    }

}
