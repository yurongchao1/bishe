package com.chao.bishe.controller;


import com.chao.bishe.domain.Comment;
import com.chao.bishe.domain.OrderMaster;
import com.chao.bishe.enums.OrderStatusEnum;
import com.chao.bishe.service.CommentService;
import com.chao.bishe.service.OrderMasterService;
import com.chao.bishe.utils.ResultVOUtil;
import com.chao.bishe.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BuyerCommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderMasterService orderMasterService;


    //订单详情
    @PostMapping("/comment")
    public ResultVO<Comment> comment(@RequestParam("openid") String openid,
                                    @RequestParam("orderId") String orderId,
                                    @RequestParam("name") String name,
                                    @RequestParam("avatarUrl") String avatarUrl,
                                    @RequestParam("content") String content) throws Exception {
        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)) {
            throw new Exception("新建评论时传入的数据有误");
        }
        //提交评论
        Comment comment = new Comment();
        comment.setOrderID(orderId);
        comment.setName(name);
        comment.setAvatarUrl(avatarUrl);
        comment.setOpenid(openid);
        comment.setContent(content);
        commentService.insert(comment);
        //修改订单状态
        OrderMaster one = orderMasterService.findOne(orderId);
        one.setOrderStatus(OrderStatusEnum.COMMENT.getCode());
        orderMasterService.update(one);
        return ResultVOUtil.success(one);
    }

    //所有评论
    @GetMapping("/commentList")
    public ResultVO<List<Comment>> commentList() {
        List<Comment> all = commentService.findAll();
        return ResultVOUtil.success(all);
    }

    //单个用户的所有评论
    @GetMapping("/userCommentList")
    public ResultVO<List<Comment>> userCommentList(@RequestParam("openid") String openid) {
        List<Comment> all = commentService.findByOpenID(openid);
        return ResultVOUtil.success(all);
    }
}
