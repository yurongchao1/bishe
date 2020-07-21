package com.chao.bishe.service;

import com.chao.bishe.dao.CommentDao;
import com.chao.bishe.domain.Comment;
import com.chao.bishe.mappers.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {
    @Autowired
    private CommentDao dao;

    public List<Comment> findByOpenID(String openId){
        return dao.findByOpenID(openId);
    }

    public List<Comment> findAll(){
        return dao.findAll();
    }

    public void insert(Comment comment){
        dao.insert(comment);
    }
}
