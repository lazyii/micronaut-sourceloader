package com.nuonuo.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.model.naming.NamingStrategies;

import java.util.Date;

/**
 * Created by admin on 2019/12/22 0:54:30.
 */
@MappedEntity(value = "auth_user", namingStrategy = NamingStrategies.Raw.class)
public class AuthUser {
    
    @Id
    @GeneratedValue(value = GeneratedValue.Type.IDENTITY)
    private Integer id;
    
    private String userId;
    
    private String appKey;
    
    private String thirdUserId;
    
    private Date createDate;
    
    private Date updateDate;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getAppKey() {
        return appKey;
    }
    
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    
    public String getThirdUserId() {
        return thirdUserId;
    }
    
    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
    }
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getUpdateDate() {
        return updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
