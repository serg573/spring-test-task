package com.springtask.entity.generation;

import com.springtask.entity.User;
import com.springtask.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.Random;

/**
 * Created by Sergey Vasiliev on 9/8/17.
 */

@Component
public class GenerateUser {

    @Autowired
    private UserRepository userRepository;

    private Random rand = new Random();

    public User getNewUser() {

        User user = new User();
        user.setLoginName(getNameForNewUser());
        user.setPassword(getNewPasswordForNewUser());
        user.setAge(getNewAgeForNewUser());
        user.setGender(getNewGenderForNewUser());
        user.setNationality(getNewNationalityForNewUser());

        return user;

    }

    private String getNameForNewUser() {
        long numberOfUsers = userRepository.count();
        return "User"+(numberOfUsers+1);
    }

    private String getNewPasswordForNewUser() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        return RandomStringUtils.random( 15, characters );
    }

    private short getNewAgeForNewUser() {
        return (short) ((short) rand.nextInt(115) + 7);  // suggest that the minimum age is seven years
    }

    private User.Gender getNewGenderForNewUser() {
        return rand.nextBoolean() ? User.Gender.male : User.Gender.female;
    }

    private User.Nationality getNewNationalityForNewUser() {
        int numberOfNationality = rand.nextInt(User.Nationality.values().length); // TODO: 9/8/17 check it
        User.Nationality[] nationalities = User.Nationality.values();
        return nationalities[numberOfNationality];

    }
}
