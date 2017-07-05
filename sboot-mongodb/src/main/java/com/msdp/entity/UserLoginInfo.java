package com.msdp.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by shixk1 on 2017/7/4.
 */
public class UserLoginInfo {
    @Id
    private String id;
    private String username;
    private Date create_at, modified_at;

    public UserLoginInfo(String username, Date create_at, Date modified_at) {
        this.username = username;
        this.create_at = create_at;
        this.modified_at = modified_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
