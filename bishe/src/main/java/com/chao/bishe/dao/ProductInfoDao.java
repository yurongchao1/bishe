package com.chao.bishe.dao;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.ProductInfo;
import com.chao.bishe.mappers.ProductCategoryMapper;
import com.chao.bishe.mappers.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInfoDao {
    @Autowired
    private ProductInfoMapper mapper;

    public  ProductInfo findOne(String productId){
        return mapper.findOne(productId);
    }

    public  List<ProductInfo> findAll(){
        return mapper.findAll();
    }

    public  List<ProductInfo> findAllOnSale(){
        return mapper.findAllOnSale();
    }

    public  void insert(ProductInfo productInfo){
        mapper.insert(productInfo);
    }

    public void  update(ProductInfo productInfo){
        mapper.update(productInfo);
    }
}
