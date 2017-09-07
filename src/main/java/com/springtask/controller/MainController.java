package com.springtask.controller;

import com.springtask.about.AboutApplication;
import com.springtask.entity.User;
import com.springtask.entity.request.AddUserRequest;
import com.springtask.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Sergey Vasiliev on 9/5/17.
 */

@RestController
public class MainController {

    private MainRepository mainRepository;

    @Autowired
    public MainController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return mainRepository.findAll();
    }

    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        user.setLoginName(addUserRequest.getLoginName());
        user.setPassword(addUserRequest.getPassword());
        user.setAge(addUserRequest.getAge());
        user.setGender(addUserRequest.getGender());
        user.setNationality(addUserRequest.getNationality());
        mainRepository.save(user);
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public AboutApplication getAboutInformation() {
        return new AboutApplication();
    }

}
