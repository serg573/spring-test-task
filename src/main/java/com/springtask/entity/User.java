package com.springtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Sergey Vasiliev on 9/5/17.
 */

@Entity
public class User {

    public enum Gender {male, female}
    public enum Nationality {american, australian, canadian, japanese, german, french, ukranian, russian}

    @Id
    private String id;
    private Date date;
    private String loginName;
    private String password;
    private short age;
    private Gender gender;
    private Nationality nationality;

    public User() {
        id = UUID.randomUUID().toString();
        date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public Date getDate() {
        return date;
    }

    public String getCreationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(calendar.getTime());
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        //return password.equals("")  ? "" : "*****";
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
