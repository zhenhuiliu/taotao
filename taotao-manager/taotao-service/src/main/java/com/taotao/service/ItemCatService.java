package com.taotao.service;

import com.taotao.mapper.ItemCatMapper;
import com.taotao.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatService {


    @Autowired
    private ItemCatMapper itemCatMapper;

    public List<ItemCat> queryItemCatListByParentId(Long pid) {
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(pid);
        return itemCatMapper.select(itemCat);
    }
}
