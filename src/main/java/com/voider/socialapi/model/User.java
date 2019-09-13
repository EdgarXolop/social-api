package com.voider.socialapi.model;

import java.util.Date;

import com.voider.socialapi.util.ValidationMessages;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id_user;

    @NotBlank(message = ValidationMessages.EMPTY_USERNAME)
    @Column
    private String user_name;

    @Email(message = ValidationMessages.WRONG_EMAIL)
    @NotBlank(message = ValidationMessages.EMPTY_EMAIL)
    @Column(unique = true)
    private String email;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column(columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_of_birth;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean banned;

    @Column
    private String phone_number;

    @NotBlank(message = ValidationMessages.EMPTY_PASSWORD)
    @Size(min = 4)
    @Column(updatable = false)
    private String password;

    @NotBlank(message = ValidationMessages.EMPTY_CONFIRM_PASSWORD)
    @Size(min = 4)
    @Transient
    private String password_confirm;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() { return password_confirm; }

    public void setPassword_confirm(String password_confirm) { this.password_confirm = password_confirm; }
}