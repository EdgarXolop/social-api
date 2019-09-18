package com.voider.socialapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id_post;

    @Column(updatable = false)
    private Long id_user_creator;

    @Column(insertable = false,updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updated_at;

    @Column(insertable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date deleted_at;

    @Lob
    @Column(name="content", length=512)
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