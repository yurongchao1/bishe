package com.chao.bishe.dao;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.mappers.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class  ProductCategoryDao {
    @Autowired
    private ProductCategoryMapper mapper;

    public  ProductCategory findOne(Integer categoryId){
        return mapper.findOne(categoryId);
    }

    public  List<ProductCategory> findAll(){
        return mapper.findAll();
    }

    public  void insert(ProductCategory productCategory){
        mapper.insert(productCategory);
    }

    public void  update(ProductCategory productCategory){
        mapper.update(productCategory);
    }

    public void  delete(Integer id){
        mapper.delete(id);
    }

    public List<ProductCategory>  findAllInTypeList(List list){
        return mapper.findAllInTypeList(list);
    }
}
