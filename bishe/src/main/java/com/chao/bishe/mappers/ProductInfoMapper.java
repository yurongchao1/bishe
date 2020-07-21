package com.chao.bishe.mappers;

import com.chao.bishe.domain.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductInfoMapper {

    ProductInfo findOne(String productId);

    List<ProductInfo> findAll();

    List<ProductInfo> findAllOnSale();

    void insert(ProductInfo productInfo);

    void  update(ProductInfo productInfo);
}
