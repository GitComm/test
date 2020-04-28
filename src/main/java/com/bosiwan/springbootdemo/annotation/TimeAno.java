package com.bosiwan.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 * 这是注解源码 default 默认 value = 3个小时
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface TimeAno  {
    String value() default "10800000";

}


