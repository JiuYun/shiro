package com.atom.entity;

/**
 * Created by Administrator on 2017/5/11.
 */
public class SysPermissions {


    private Long            id;
    private String          permission;
    private String          description;
    private Long            available;


    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
