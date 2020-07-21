package com.chao.bishe.dao;

import com.chao.bishe.domain.Comment;
import com.chao.bishe.domain.ProductCategory;
import com.chao.bishe.mappers.CommentMapper;
import com.chao.bishe.mappers.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDao {
    @Autowired
    private CommentMapper mapper;
    public List<Comment> findByOpenID(String openId){
        return mapper.findByOpenID(openId);
    }

    public List<Comment> findAll(){
        return mapper.findAll();
    }

    public void insert(Comment comment){
        mapper.insert(comment);
    }

}
