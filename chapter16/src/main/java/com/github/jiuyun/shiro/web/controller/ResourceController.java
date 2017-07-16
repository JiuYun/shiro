package com.github.jiuyun.shiro.web.controller;

import com.github.jiuyun.shiro.entity.Resource;
import com.github.jiuyun.shiro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Li Jie on 2017/7/15 0015.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ModelAttribute("types")
    public Resource.ResourceType[] resourceTypes() {
        return Resource.ResourceType.values();
    }

}
