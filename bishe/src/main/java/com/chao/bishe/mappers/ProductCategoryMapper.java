package com.chao.bishe.mappers;

import com.chao.bishe.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProductCategoryMapper {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    void insert(ProductCategory productCategory);

    void  update(ProductCategory productCategory);

    void  delete(Integer categoryId);

    List<ProductCategory> findAllInTypeList(List<Integer> idList);
}
