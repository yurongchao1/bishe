package com.chao.bishe.controller;

import com.chao.bishe.domain.SellerInfo;
import com.chao.bishe.service.SellerInfoService;
import com.chao.bishe.utils.CookieUtil;
import com.chao.bishe.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/seller")
public class SellerLoginController {

    @Autowired
    SellerInfoService sellerInfoService;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletResponse response,
                              HttpServletRequest request,
                              Map<String, Object> map) {
        SellerInfo sellerInfo = sellerInfoService.findByUsername(username);
        if (sellerInfo == null) {
            map.put("msg", "用户名错误，请重新登录");
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        if(!sellerInfo.getPassword().equals(password)){
            map.put("msg", "密码错误，请重新登录");
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        //2. 设置token至session
        String token = UUID.randomUUID().toString();
        SessionUtils.setAttr(request,token,token+"session");
        //3. 设置token至cookie
        CookieUtil.set(response, "token", token, 60*60);  //时间设置为一小时
        map.put("msg", "登录成功");
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, "token");
        if (cookie != null) {
            //2. 清除session
            SessionUtils.removeAttr(request,cookie.getValue());
            //3. 清除cookie
            CookieUtil.set(response, "token", null, 0);
        }

        map.put("msg", "注销成功");
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    @RequestMapping("/tologin")
    @ResponseBody
    public ModelAndView login(Map<String, Object> map) {
        //map.put("url", "/seller/order/list");
        return new ModelAndView("admin/login",map);
    }
}
