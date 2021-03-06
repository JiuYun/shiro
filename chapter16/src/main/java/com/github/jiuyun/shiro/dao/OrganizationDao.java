package com.github.jiuyun.shiro.dao;

import com.github.jiuyun.shiro.entity.Organization;

import java.util.List;

/**
 * Created by Li Jie on 2017/7/13 0013.
 */
public interface OrganizationDao {

    public Organization createOrganization(Organization organization);

    public Organization updateOrganization(Organization organization);

    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);

    List<Organization> findAll();

    List<Organization> findAllWithExclude(Organization excludeOraganization);

    void move(Organization source,Organization target);






}
