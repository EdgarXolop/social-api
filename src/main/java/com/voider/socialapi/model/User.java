package com.voider.socialapi.model;

import java.util.Date;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;

    @Column
    private String user_name;

    @Column(unique = true)
    private String email;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column(columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_of_birth;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean banned;

    @Column
    private String phone_number;

    public Long getId_user() {
        return id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public boolean isBanned() {
        return banned;
    }

    public String getPhone_number() {
        return phone_number;
    }

}