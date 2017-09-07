package com.springtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sergey Vasiliev on 9/7/17.
 */

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private Date date;

    private int numberOfUsers;
    private int averageAge;
    private int numberOfMales;
    private int numberOfFemales;
    private String numberOfNationalities;

    public Statistic() {
        this.date = new Date();
        this.numberOfUsers = 0;
        this.averageAge = 0;
        this.numberOfMales = 0;
        this.numberOfFemales = 0;
        this.numberOfNationalities = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(calendar.getTime());
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public int getNumberOfMales() {
        return numberOfMales;
    }

    public void setNumberOfMales(int numberOfMales) {
        this.numberOfMales = numberOfMales;
    }

    public int getNumberOfFemales() {
        return numberOfFemales;
    }

    public void setNumberOfFemales(int numberOfFemales) {
        this.numberOfFemales = numberOfFemales;
    }

    public String getNumberOfNationalities() {
        return numberOfNationalities;
    }

    public void setNumberOfNationalities(String numberOfNationalities) {
        this.numberOfNationalities = numberOfNationalities;
    }
}
