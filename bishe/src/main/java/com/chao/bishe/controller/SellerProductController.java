package com.chao.bishe.controller;

import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.domain.ProductInfo;
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
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(  Map<String, Object> map) {
        List<ProductInfo> productInfos = productInfoService.findAll();
        map.put("productInfos", productInfos);

        return new ModelAndView("product/list", map);
    }


    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productInfoService.updateonsale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/product/list");
        map.put("msg", "商品上架成功");
        return new ModelAndView("common/success", map);
    }
    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productInfoService.updateoffsale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/product/list");
        map.put("msg", "商品下架成功");
        return new ModelAndView("common/success", map);
    }

    /**
     * 新增或修改
     * @param productId
     * @param map
     * @return
     */
 @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        //查询所有的类目
        List<ProductCategory> categoryList = productCategoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);
    }


    /**
     * 商品的提交保存
     * @param productForm
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(ProductForm productForm,
                             Map<String, Object> map) {

        ProductInfo productInfo=new ProductInfo();
        try {
            //如果productId不为空, 说明是修改
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productInfoService.findOne(productForm.getProductId());
                BeanUtils.copyProperties(productForm, productInfo);
                productInfoService.update(productInfo);
            } else {
                productForm.setProductId(KeyUtil.genUniqueKey());
                BeanUtils.copyProperties(productForm, productInfo);
                productInfoService.insert(productInfo);
            }

        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
