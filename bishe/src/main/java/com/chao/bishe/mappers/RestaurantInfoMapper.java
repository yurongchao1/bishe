package com.chao.bishe.mappers;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.RestaurantInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RestaurantInfoMapper {
    RestaurantInfo findOne(Integer categoryId);
    void  update(RestaurantInfo restaurantInfo);

}
