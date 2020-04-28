package com.bosiwan.springbootdemo.aspect;


import com.bosiwan.springbootdemo.annotation.TimeAno;
import com.bosiwan.springbootdemo.controller.GoogleController;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // FOR AOP

@Order() // 控制多个Aspect的执行顺序，越小越先执行, 当然也可以不写这注解, 对于写和不写@order的两个切面, 有@order的优先于无@order的执行; 都有@order时, 越小越执先执行

@Component

public class TimeRequestFlag {

    @Autowired
    GoogleController googleController;//这是我的实际业务调用方法 就是 类似于你们的serviceimpl

    // System.setProperty("key","value") 和System.getProperty()方法是全局变量(key value 形式)比如set一个key value
    //他是直接进入内存中,可以在任何地方获取到类似于session
    //timeAno.value() 获取TimeAno 标签的默认值10800000
    @Before("@annotation(timeAno)")
    public synchronized void beforeRequestFlat(TimeAno timeAno) throws Exception {

        boolean flag = true;
        long start = System.currentTimeMillis();

        if (null != System.getProperty("timeFlag")) {//表示这个接口至少被调用一次
            long timeFlag = Long.parseLong(System.getProperty("timeFlag"));
            if (timeFlag + Long.parseLong(timeAno.value()) < start) {//取出来第一次调用的时间戳 加上你规定的时间毫秒数
                //这样如果小于start表示 超过你规定3个小时调用一次的需求 所以需要重新把timeFlag 在刷新一下时间进入下一个3小时算
                System.setProperty("timeFlag", start + "");
            } else {
                flag = false;
            }
        } else {//如果else 表示接口第一次调用记录一个时间戳
            // System.setProperty()--底层由ConcurrentHashMap实现,线程安全
            System.setProperty("timeFlag", start + "");
        }

        if (flag) {
            //表示如果在3小时之内允许调用一次  actionGooglePhoto() 这个方法就是我的serviceimpl具体实现业务方法
            //当然也可以换成你自己的GoogleController 里边的 actionGG 方法里边什么也没有具体实现都在这里分发
            //所以你会看到
            googleController.actionGG();

        }

    }

}

