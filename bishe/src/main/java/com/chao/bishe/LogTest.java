package com.chao.bishe;


import com.chao.bishe.domain.CommentTest;
import com.chao.bishe.domain.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogTest {
    @Test
    public  void test01(){
        System.out.println("yuronghcoa");
        SellerInfo info=new SellerInfo();

        log.info("test01zhixingle");
    }
    @Test
    public  void test02(){
        CommentTest a=new CommentTest();
        CommentTest b=new CommentTest();
        System.out.println(a.hashCode());//1742810335
        System.out.println(b.hashCode());//1742810335
    }
}
