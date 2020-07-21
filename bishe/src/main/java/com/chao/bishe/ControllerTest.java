package com.chao.bishe;

import com.chao.bishe.dao.OrderMasterDao;
import com.chao.bishe.dao.ProductCategoryDao;
import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class ControllerTest {
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Autowired
    OrderMasterDao orderMasterDao;

    @RequestMapping("/test")
    @ResponseBody
    public List<ProductCategory> test() {
        List<ProductCategory> all = productCategoryDao.findAll();
        return all;
        //git test
    }

    @RequestMapping("/test1")
    public void test1() {

    }


    @RequestMapping("/test2")
    @ResponseBody
    public List<OrderMaster> test2() {
        List<OrderMaster> all = orderMasterDao.findAll();
        return all;
    }

    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(Map<String, Object> map) {
        //map.put("url", "/seller/order/list");
        System.out.println("login");
        return new ModelAndView("admin/login",map);
    }
    @RequestMapping("/login1")
    public void login1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/login").forward(request, response);
    }
}
