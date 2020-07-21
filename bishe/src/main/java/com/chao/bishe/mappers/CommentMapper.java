package com.chao.bishe.mappers;

import com.chao.bishe.domain.Comment;
import com.chao.bishe.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> findByOpenID(String openId);

    List<Comment> findAll();

    void insert(Comment comment);


}
