package com.msdp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by shixk1 on 2017/7/4.
 */
public class Service implements Serializable {
    @Id
    public String id;//service_key
    public String app_id;
    public String service_name;
    public Date created_at, modified_at;
    public String code_url;
    public String description;
    public Boolean deleted;
    public String cn_caption;
    public String en_caption;
    public String en_description;
    public String owner;
    @DBRef
    public List<ServiceTag> tags;


    public Service(String service_name, Date date, String description, String en_caption, String cn_caption, String owner
            , List<ServiceTag> tags, String app_id, String en_description) {
        this.service_name = service_name;
        this.created_at = date;
        this.modified_at = date;
        this.description = description;
        this.deleted = false;
        this.owner = owner;
        this.tags = tags;
        this.app_id = app_id;
        this.en_caption = en_caption;
        this.cn_caption = cn_caption;
        this.en_description = en_description;
    }

    public Service() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<ServiceTag> getTags() {
        return tags;
    }

    public void setTags(List<ServiceTag> tags) {
        this.tags = tags;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCn_caption() {
        return cn_caption;
    }

    public void setCn_caption(String cn_caption) {
        this.cn_caption = cn_caption;
    }

    public String getEn_caption() {
        return en_caption;
    }

    public void setEn_caption(String en_caption) {
        this.en_caption = en_caption;
    }

    public String getEn_description() {
        return en_description;
    }

    public void setEn_description(String en_description) {
        this.en_description = en_description;
    }
}
