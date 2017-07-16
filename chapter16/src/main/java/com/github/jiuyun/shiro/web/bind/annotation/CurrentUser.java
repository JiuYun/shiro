package com.github.jiuyun.shiro.web.bind.annotation;

import com.github.jiuyun.shiro.web.Constant;

/**
 * Created by Li Jie on 2017/7/15 0015.
 * <p>绑定当前登录用户</p>
 * <p>不同于@ModelAttribute</p>
 *
 */
public @interface CurrentUser {


    String value() default Constant.CURRENT_USER;


}
