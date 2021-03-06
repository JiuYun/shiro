package com.github.jiuyun.shiro.dao;

import com.github.jiuyun.shiro.entity.Resource;

import java.util.List;

/**
 * Created by Li Jie on 2017/7/14.
 */
public interface ResourceDao {

    public Resource createResource(Resource resource);

    public Resource updateResource(Resource resource);

    public void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);

    List<Resource> findAll();
}
