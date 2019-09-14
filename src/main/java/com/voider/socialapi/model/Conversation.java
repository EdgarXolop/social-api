package com.voider.socialapi.model;

import com.voider.socialapi.util.ErrorUtil;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Table(name = "conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id_conversation;

    @Column(updatable = false)
    private Long id_user_creator;

    @Min(value = 0L, message = ErrorUtil.INVALID_USER_INVITED)
    @Column(updatable = false)
    private Long id_user_invited;

    @Column(insertable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean accepted;

    @Column( insertable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean standby_mode;

    @Column(insertable = false)
    private String uuid;

    @Column(insertable = false)
    private String last_message;

    @Column(insertable = false,updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updated_at;

    public Long getId_conversation() {
        return id_conversation;
    }

    public void setId_conversation(Long id_conversation) {
        this.id_conversation = id_conversation;
    }

    public Long getId_user_creator() {
        return id_user_creator;
    }

    public void setId_user_creator(Long id_user_creator) {
        this.id_user_creator = id_user_creator;
    }

    public Long getId_user_invited() {
        return id_user_invited;
    }

    public void setId_user_invited(Long id_user_invited) {
        this.id_user_invited = id_user_invited;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isStandby_mode() {
        return standby_mode;
    }

    public void setStandby_mode(boolean standby_mode) {
        this.standby_mode = standby_mode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLast_message() {
        return last_message;
    }

    public void setLast_message(String last_message) {
        this.last_message = last_message;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
