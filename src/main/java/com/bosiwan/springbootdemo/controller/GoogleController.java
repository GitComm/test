package com.bosiwan.springbootdemo.controller;


import com.bosiwan.springbootdemo.annotation.TimeAno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 1,先看下一我的代码里边什么也没有,但是调用的话里边功能绝对不会少,
 * 并且还能规定调用次数和时间限制,例如5分钟之内只能调用几次等等.
 */
@RestController
@RequestMapping("/photo")
public class GoogleController {

    /**
     * actionGG方法用于抓取Google图片
     * actionGG 方法名坚决不要乱改动不然会报错
     *
     */
    @TimeAno
    @GetMapping(value = "/actionGG")
    public void actionGG() {
        //空空如也~
    }

}

