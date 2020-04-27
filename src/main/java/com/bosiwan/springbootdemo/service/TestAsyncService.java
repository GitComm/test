package com.bosiwan.springbootdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestAsyncService {

    @Async
    public void testAsync() throws Exception{
        System.out.println("此处异步执行...");
    }

}
