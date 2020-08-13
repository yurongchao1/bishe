package com.chao.bishe.aspect;


import com.chao.bishe.utils.CookieUtil;
import com.chao.bishe.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Aspect
public class SellerAuthorizeAspect {

    @Pointcut("execution(public * com.chao.bishe.controller.Seller*.*(..))" +
            "&& !execution(public * com.chao.bishe.controller.SellerLoginController.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() throws ServletException, IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response=attributes.getResponse();
        //查询cookie
        Cookie cookie = CookieUtil.get(request, "token");
        if (cookie == null) {
            request.getRequestDispatcher("/seller/tologin").forward(request, response);
            log.info("存在cookie");
            return;
        }
        //去session里查询
        String tokenValue = (String) SessionUtils.getAttr(request, cookie.getValue());
        if (StringUtils.isEmpty(tokenValue)) {
            request.getRequestDispatcher("/seller/tologin").forward(request, response);
            log.info("不存在对应session值");
        }
    }
}
