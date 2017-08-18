package com.taotao.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通用jsp跳转页面
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping(value = "{pageName}",method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName")String pageName){
        return pageName;
    }
}
