package com.springtask.entity.request;

import com.springtask.entity.User;

/**
 * Created by Sergey Vasiliev on 9/5/17.
 */

public class AddUserRequest {

    private String loginName;
    private String password;
    private short age;
    private User.Gender gender;
    private User.Nationality nationality;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
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

    public User.Gender getGender() {
        return gender;
    }

    public void setGender(User.Gender gender) {
        this.gender = gender;
    }

    public User.Nationality getNationality() {
        return nationality;
    }

    public void setNationality(User.Nationality nationality) {
        this.nationality = nationality;
    }
}
