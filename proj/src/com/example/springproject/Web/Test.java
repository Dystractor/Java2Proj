package com.example.springproject.Web;

import org.springframework.web.bind.annotation.RequestMapping;

public class Test {

    @RequestMapping("goEchartsTest")
    public String showEchartsJSP(){
        return "/testEcharts";
    }

}
