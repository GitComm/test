package com.bosiwan.springbootdemo.entity;


import com.bosiwan.springbootdemo.annotation.NotNull;

import java.util.Date;

/**

 * 自定义参数类

 * @author z_hh

 * @time 2019年1月2日

 */

public class Param {

    private int property1;

    private String property2;

    @NotNull(groups = { "test" })
    private Date property3;

    public int getProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public Date getProperty3() {
        return property3;
    }

    public void setProperty3(Date property3) {
        this.property3 = property3;
    }

    @Override
    public String toString() {
        return "Param [property1=" + property1 + ", property2=" + property2 + ", property3=" + property3 + "]";
    }



}

