package com.chao.bishe.controller;


import com.chao.bishe.domain.RestaurantInfo;
import com.chao.bishe.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/restaurant")
public class SellRestaurantController {
    @Autowired
    private RestaurantInfoService restaurantInfoService;

    /**
     * 显示
     *
     * @param restaurantId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "restaurantId") Integer restaurantId,
                              Map<String, Object> map) {

        RestaurantInfo restaurantInfo = restaurantInfoService.findOne(restaurantId);
        map.put("restaurantInfo", restaurantInfo);

        return new ModelAndView("restaurant/index", map);
    }


    /**
     * 餐馆信息的提交保存
     *
     * @param restaurantInfo
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(RestaurantInfo restaurantInfo,
                             Map<String, Object> map) {

        try {
            restaurantInfoService.update(restaurantInfo);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/restaurant/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/restaurant/index" + "?restaurantId=" + restaurantInfo.getRestaurantId());
        map.put("msg", "餐馆信息修改成功");
        return new ModelAndView("common/success", map);
    }
}
