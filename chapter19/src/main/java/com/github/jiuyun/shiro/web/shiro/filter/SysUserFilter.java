package com.github.jiuyun.shiro.web.shiro.filter;

import com.github.jiuyun.shiro.service.UserService;
import com.github.jiuyun.shiro.web.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Li Jie on 2017/7/16 0016.
 */
public class SysUserFilter extends PathMatchingFilter {


    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constant.CURRENT_USER, userService.findByUsername(userName));
        return true;
    }
}
