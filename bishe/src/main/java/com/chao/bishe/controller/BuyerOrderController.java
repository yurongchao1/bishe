package com.chao.bishe.controller;


import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.form.OrderForm;
import com.chao.bishe.service.OrderMasterService;
import com.chao.bishe.utils.OrderForm2OrderMasterConverter;
import com.chao.bishe.utils.ResultVOUtil;
import com.chao.bishe.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")

public class BuyerOrderController {


@Autowired
    OrderMasterService orderMasterService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(OrderForm orderForm) throws Exception {
        if (orderForm.getOpenid()==null||orderForm.getOpenid()=="") {
           throw  new Exception("创建订单出现异常");
        }
        OrderMaster orderMaster = OrderForm2OrderMasterConverter.convert(orderForm);


        OrderMaster createResult = orderMasterService.create(orderMaster);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/listByStatus")
    public ResultVO<List<OrderMaster>> listByStatus(@RequestParam("openid") String openid,
                                                 @RequestParam(value = "orderStatus", defaultValue = "0") Integer orderStatus) throws Exception {
        if (StringUtils.isEmpty(openid)) {
            throw new Exception("openid 为空");
        }

        List<OrderMaster> orderList = orderMasterService.findOrderListByStatus(openid, orderStatus);
        return ResultVOUtil.success(orderList);
    }


    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        OrderMaster one = orderMasterService.findOne(orderId);
        orderMasterService.cancel(one);
        return ResultVOUtil.success();
    }
}
