package com.chao.bishe.mappers;

import com.chao.bishe.dao.ProductCategoryDao;
import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.enums.OrderStatusEnum;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;
import java.util.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Autowired
    OrderMasterMapper orderMasterMapper;
    @Test
    public void insert() {
     /*   ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("肉类");
        productCategory.setCategoryType(1);
        productCategoryMapper.insert(productCategory);*/

        String[] strings={"a","b","c"};
        List<String> list = Arrays.asList(strings);
        System.out.println(list);

        boolean aNull = Objects.isNull(null);
        Objects.requireNonNull(null,"该为空");


    }
    @Test
    public void update() {
        ProductCategory one = productCategoryMapper.findOne(1);
        one.setCategoryName("肉类");
        productCategoryMapper.update(one);


    }



    @Test
    public void test02() {
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> allInTypeList = productCategoryMapper.findAllInTypeList(list);
        for(ProductCategory productCategory:allInTypeList){
            System.out.println(productCategory.toString());
        }

    }
    @Test
    public void test03() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();

    }

}