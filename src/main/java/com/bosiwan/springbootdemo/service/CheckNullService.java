package com.bosiwan.springbootdemo.service;


import com.bosiwan.springbootdemo.annotation.CheckNull;
import com.bosiwan.springbootdemo.entity.Param;
import org.springframework.stereotype.Service;

/**
 * 测试非空校验的服务
 * @author z_hh
 * @time 2019年1月2日
 */

@Service
public class CheckNullService {

    @CheckNull
    public void test(String nullVal, @CheckNull(group="test") Param param) {
        System.out.println(param);
    }

}

