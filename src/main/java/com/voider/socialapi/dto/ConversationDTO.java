package com.voider.socialapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversationDTO {
    private Long id_conversation;
    private boolean accepted;
    private boolean standby_mode;
    private String uuid;
    private String last_message;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updated_at;
    private UserDTO creator;
    private UserDTO invited;

    public Long getId_conversation() {
        return id_conversation;
    }

    public void setId_conversation(Long id_conversation) {
        this.id_conversation = id_conversation;
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

    public String    getUuid() {
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

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public UserDTO getInvited() {
        return invited;
    }

    public void setInvited(UserDTO invited) {
        this.invited = invited;
    }
}
