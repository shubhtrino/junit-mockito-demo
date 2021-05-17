package com.trinocode.junitmockito.controller;


import com.trinocode.junitmockito.model.User;
import com.trinocode.junitmockito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User SaveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/addAll")
    public List<User> SaveUser(@RequestBody List<User> users){
        return userService.saveAllUser(users);
    }
}
