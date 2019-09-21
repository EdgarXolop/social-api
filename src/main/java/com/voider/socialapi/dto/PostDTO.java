package com.voider.socialapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostDTO {

    private Long id_post;

    private Long id_user_creator;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updated_at;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date deleted_at;

    private String content;

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public Long getId_user_creator() {
        return id_user_creator;
    }

    public void setId_user_creator(Long id_user_creator) {
        this.id_user_creator = id_user_creator;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
