package com.test.shiro.parmission;

import org.apache.shiro.authz.Permission;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class BitPermission implements Permission{

    private String resourceIdentify;
    private int permissionBit;
    private String instanceId;


    public BitPermission(String permissionString) {
        String[] array = permissionString.split("\\+");
        if(array.length > 1){
            resourceIdentify = array[1];
        }
        if(resourceIdentify == null || resourceIdentify.length() == 0){
            resourceIdentify = "*";
        }

        if(array.length > 2){
            permissionBit = Integer.parseInt(array[2]);
        }

        if(array.length > 3){
            instanceId = array[3];
        }
        if(instanceId == null || instanceId.length() == 0){
            instanceId = "*";
        }

    }




    public boolean implies(Permission p) {
        if(!(p instanceof BitPermission)){
            return false;
        }
        BitPermission permission = (BitPermission)p;

        if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(permission.resourceIdentify))){
            return false;
        }

        if(!(this.permissionBit == 0 || (this.permissionBit & permission.permissionBit) != 0)){
            return false;
        }

        if(!("*".equals(instanceId) || this.instanceId.equals(permission.instanceId))){
            return false;
        }

        return true;
    }
}
