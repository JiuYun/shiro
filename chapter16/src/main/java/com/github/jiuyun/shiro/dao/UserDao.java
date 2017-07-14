package com.github.jiuyun.shiro.dao;

import com.github.jiuyun.shiro.entity.User;

import java.util.List;

/**
 * Created by Li Jie on 2017/7/14.
 */
public interface UserDao {

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUserName(String userName);

}
