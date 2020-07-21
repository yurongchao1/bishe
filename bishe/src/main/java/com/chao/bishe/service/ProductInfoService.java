package com.chao.bishe.service;

import com.chao.bishe.dao.ProductCategoryDao;
import com.chao.bishe.dao.ProductInfoDao;
import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.ProductInfo;
import com.chao.bishe.enums.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;


    public  ProductInfo findOne(String productId){
        return productInfoDao.findOne(productId);
    }

    public  List<ProductInfo> findAll(){
        return productInfoDao.findAll();
    }

    public  List<ProductInfo> findAllOnSale(){
        return productInfoDao.findAllOnSale();
    }

    public  void insert(ProductInfo productInfo){
        productInfoDao.insert(productInfo);
    }

    public void  update(ProductInfo productInfo){
        productInfoDao.update(productInfo);
    }

    public void updateonsale(String productId){
        ProductInfo one = productInfoDao.findOne(productId);
        one.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfoDao.update(one);
    }

    public void updateoffsale(String productId){
        ProductInfo one = productInfoDao.findOne(productId);
        one.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfoDao.update(one);
    }
}
