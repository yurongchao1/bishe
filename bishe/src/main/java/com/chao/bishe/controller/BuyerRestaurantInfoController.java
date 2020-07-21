package com.chao.bishe.controller;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.ProductInfo;
import com.chao.bishe.domain.RestaurantInfo;
import com.chao.bishe.service.ProductCategoryService;
import com.chao.bishe.service.ProductInfoService;
import com.chao.bishe.service.RestaurantInfoService;
import com.chao.bishe.utils.ResultVOUtil;
import com.chao.bishe.vo.ProductInfoVO;
import com.chao.bishe.vo.ProductVO;
import com.chao.bishe.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/buyer/restaurant")
public class BuyerRestaurantInfoController {


        @Autowired
        private RestaurantInfoService restaurantInfoService;


        @GetMapping("/info")
        public ResultVO info() {
            RestaurantInfo one = restaurantInfoService.findOne(1);
            return ResultVOUtil.success(one);
        }
}
