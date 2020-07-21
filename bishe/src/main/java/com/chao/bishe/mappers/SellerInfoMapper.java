package com.chao.bishe.mappers;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.SellerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerInfoMapper {

    SellerInfo findByUsername(String username);


}
