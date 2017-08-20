package com.taotao.web.web;

import com.alibaba.fastjson.JSON;
import com.taotao.pojo.ItemCat;
import com.taotao.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    private static final Logger logger = LoggerFactory.getLogger(ItemCatController.class);

    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> queryItemCatListByParentId(HttpServletRequest request,
                                                             @RequestParam(value ="id",defaultValue = "0") Long pid){
        logger.info("cid:{}",pid);
        try {
            List<ItemCat> list = itemCatService.queryItemCatListByParentId(pid);
            logger.info("list---------------:{}", JSON.toJSONString(list));
            return ResponseEntity.ok(JSON.toJSONString(list));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
