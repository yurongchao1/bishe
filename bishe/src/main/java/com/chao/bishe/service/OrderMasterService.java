package com.chao.bishe.service;

import com.chao.bishe.dao.OrderMasterDao;
import com.chao.bishe.domain.OrderDetail;
import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.domain.ProductInfo;
import com.chao.bishe.enums.OrderStatusEnum;
import com.chao.bishe.enums.PayStatusEnum;
import com.chao.bishe.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class OrderMasterService {
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailService orderDetailService;

    public OrderMaster findOne(String orderID) {
        return orderMasterDao.findOne(orderID);
    }

    public List<OrderMaster> findAll() {
        return orderMasterDao.findAll();
    }

    public void insert(OrderMaster orderMaster) {
        orderMasterDao.insert(orderMaster);
    }

    public void update(OrderMaster orderMaster) {
        orderMasterDao.update(orderMaster);
    }

    public void cancel(OrderMaster orderMaster) {
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        orderMasterDao.update(orderMaster);
    }

    public void finish(OrderMaster orderMaster) {
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterDao.update(orderMaster);
    }

    public OrderMaster create(OrderMaster orderMaster) throws Exception {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
//        List<CartDTO> cartDTOList = new ArrayList<>();
        //1. 查询商品（数量, 价格）
        for (OrderDetail orderDetail: orderMaster.getOrderDetailList()) {
            ProductInfo productInfo =  productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new Exception("商品不存在");
            }
            //2. 计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailService.insert(orderDetail);
        }
        //3. 写入订单数据库（orderMaster和orderDetail）
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        orderMasterDao.insert(orderMaster);
        return orderMaster;
    }

    public List<OrderMaster> findOrderListByStatus(String buyerOpenid, Integer orderStatus) {
        return orderMasterDao.findOrderListByStatus(buyerOpenid,orderStatus);
    }
}
