package com.chao.bishe.service;

import com.chao.bishe.dao.ProductCategoryDao;
import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.mappers.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    public  ProductCategory findOne(Integer categoryId){
        return productCategoryDao.findOne(categoryId);
    }

    public  List<ProductCategory> findAll(){
        return productCategoryDao.findAll();
    }

    public  void insert(ProductCategory productCategory){
        productCategoryDao.insert(productCategory);
    }

    public void  update(ProductCategory productCategory){
        productCategoryDao.update(productCategory);
    }

    public void  delete(Integer id){
        productCategoryDao.delete(id);
    }

    public List<ProductCategory>  findAllInTypeList(List list){
        return productCategoryDao.findAllInTypeList(list);
    }
}
