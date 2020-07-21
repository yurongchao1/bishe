package com.chao.bishe.utils;


import com.chao.bishe.domain.OrderDetail;
import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderMasterConverter {

    public static OrderMaster convert(OrderForm orderForm) throws Exception {
        Gson gson = new Gson();
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setBuyerName(orderForm.getName());
        orderMaster.setBuyerPhone(orderForm.getPhone());
        orderMaster.setBuyerAddress(orderForm.getAddress());
        orderMaster.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            throw  new Exception("对象转换错误");
        }
        orderMaster.setOrderDetailList(orderDetailList);

        return orderMaster;
    }
}
