package com.bosiwan.springbootdemo.controller;

import com.bosiwan.springbootdemo.service.TestAsyncService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    TestAsyncService testAsyncService ;

    @RequestMapping
    public void TestAsync() {
        try{
            testAsyncService.testAsync();
            System.out.println("testAsync调用完成...");
        }catch (Exception e){}


    }
}
