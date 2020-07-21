package com.chao.bishe.controller;

import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderMasterService orderMasterService;

    /**
     * 订单列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(  Map<String, Object> map) {
        List<OrderMaster> orderMasters = orderMasterService.findAll();
        map.put("orderMasters", orderMasters);
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     * @param orderId
     * @param map
     * @return
     */
    @RequestMapping("/cancel")
    public ModelAndView cancel( @RequestParam("orderId") String orderId, Map<String, Object> map) {
        try {
            OrderMaster orderMaster = orderMasterService.findOne(orderId);
            orderMasterService.cancel(orderMaster);
        } catch (Exception e) {
           e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/order/list");
       map.put("msg", "订单取消成功");
        return new ModelAndView("common/success",map);
    }

    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderMaster orderMaster = orderMasterService.findOne(orderId);
            map.put("orderMaster",orderMaster);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/order/detail");
        return new ModelAndView("order/detail", map);
    }
    /**
     * 订单完结
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderMaster orderMaster = orderMasterService.findOne(orderId);
            orderMasterService.finish(orderMaster);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg",  "订单完结成功");
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success");
    }

}
