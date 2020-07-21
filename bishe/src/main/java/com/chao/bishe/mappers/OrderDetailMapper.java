package com.chao.bishe.mappers;

import com.chao.bishe.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {



    void insert(OrderDetail orderDetail);


}
