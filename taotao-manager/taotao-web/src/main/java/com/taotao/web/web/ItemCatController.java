package com.taotao.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @RequestMapping("/list")
    public String getList(HttpServletRequest request, @RequestParam("cid")String
                          cid){

        return "SUCCESS";
    }
}
