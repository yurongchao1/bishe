package com.chao.bishe.controller;

import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.ProductInfo;
import com.chao.bishe.form.CategoryForm;
import com.chao.bishe.form.ProductForm;
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
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(  Map<String, Object> map) {
        List<ProductCategory> productCategorys = productCategoryService.findAll();
        map.put("productCategorys", productCategorys);

        return new ModelAndView("category/list", map);
    }

    /**
     * 新增或修改
     * @param categoryId
     * @param map
     * @return
     */
 @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(categoryId)) {
            ProductCategory productCategory = productCategoryService.findOne(categoryId);
            map.put("productCategory", productCategory);
        }
        return new ModelAndView("category/index", map);
    }


    /**
     * 商品类目的提交保存
     * @param categoryForm
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(CategoryForm categoryForm,
                             Map<String, Object> map) {

        ProductCategory productCategory=new ProductCategory();
        try {
            //如果productId不为空, 说明是修改
            if (!StringUtils.isEmpty(categoryForm.getCategoryId())) {
                productCategory = productCategoryService.findOne(categoryForm.getCategoryId());
                BeanUtils.copyProperties(categoryForm, productCategory);
                productCategoryService.update(productCategory);
            } else {
                BeanUtils.copyProperties(categoryForm, productCategory);
                productCategoryService.insert(productCategory);
            }

        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/category/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/category/list");
        map.put("msg", "商品类目新增或修改成功");
        return new ModelAndView("common/success", map);
    }

    /**
     * 删除类目
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "categoryId") Integer categoryId,
                              Map<String, Object> map) {
        try {
            productCategoryService.delete(categoryId);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/seller/category/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/category/list");
        map.put("msg", "商品类目删除成功");
        return new ModelAndView("common/success",map);
    }
}

//餐馆信息的管理      登录  登出
