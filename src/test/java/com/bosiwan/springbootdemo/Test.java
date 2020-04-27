package com.bosiwan.springbootdemo;

import com.bosiwan.springbootdemo.controller.TestController;
import com.bosiwan.springbootdemo.entity.Param;
import com.bosiwan.springbootdemo.service.CheckNullService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Resource
    CheckNullService checkNullService ;

    @Resource
    TestController TestController ;

    @org.junit.Test
    public void test(){
        Param param = new Param();
        checkNullService.test(null,param);
    }

    @org.junit.Test
    public void testAsync(){
        TestController.TestAsync();
    }

}
