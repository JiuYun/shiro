package com.github.jiuyun.shiro.web.controller;

import com.github.jiuyun.shiro.entity.Resource;
import com.github.jiuyun.shiro.entity.User;
import com.github.jiuyun.shiro.service.ResourceService;
import com.github.jiuyun.shiro.service.UserService;
import com.github.jiuyun.shiro.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * Created by Li Jie on 2017/7/15 0015.
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(@CurrentUser User loginUser,Model model){

        Set<String>     permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource>  menus       = resourceService.findMenus(permissions);
        model.addAttribute("menus",menus);

        return "index";
    }


    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }



















}
