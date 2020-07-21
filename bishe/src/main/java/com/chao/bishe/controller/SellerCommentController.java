package com.chao.bishe.controller;

import com.chao.bishe.domain.Comment;
import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.ProductInfo;
import com.chao.bishe.form.ProductForm;
import com.chao.bishe.service.CommentService;
import com.chao.bishe.service.ProductCategoryService;
import com.chao.bishe.service.ProductInfoService;
import com.chao.bishe.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/comment")
public class SellerCommentController {

    @Autowired
    private CommentService commentService;


    /**
     * 商品列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(  Map<String, Object> map) {
        List<Comment> comments= commentService.findAll();
        map.put("comments", comments);

        return new ModelAndView("comment/list", map);
    }


}
