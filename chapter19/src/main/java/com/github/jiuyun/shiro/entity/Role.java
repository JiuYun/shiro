package com.github.jiuyun.shiro.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li Jie on 2017/7/13 0013.
 */
public class Role implements Serializable{


    private Long id;
    private String role;
    private String description;
    private List<Long> resourceIds;
    private Boolean available = Boolean.FALSE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getResourceIds() {
        return resourceIds == null ? new ArrayList<Long>() : resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getResourceIdsStr() {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIds) {
            s.append(resourceId);
            s.append(",");
        }
        return s.toString();
    }

    public void setResourceIdsStr(String resourceIdsStr) {
        if(StringUtils.isEmpty(resourceIdsStr)) {
            return;
        }
        String[] resourceIdStrs = resourceIdsStr.split(",");
        for(String resourceIdStr : resourceIdStrs) {
            if(StringUtils.isEmpty(resourceIdStr)) {
                continue;
            }
            getResourceIds().add(Long.valueOf(resourceIdStr));
        }
    }




}
