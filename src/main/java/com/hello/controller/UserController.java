package com.hello.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hello.model.User;
import com.hello.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = POST, consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(CREATED)
    public void create(@RequestBody User user) {
        userService.create(user);
    }
    
    @RequestMapping(method = GET, produces = {APPLICATION_JSON_VALUE})
    @ResponseStatus(OK)
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}