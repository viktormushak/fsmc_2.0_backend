package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.network.Result;
import com.fsmc.backend.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody User user){
        User newUser = usersService.createUser(user);
        return User.EMPTY.equals(newUser) ? new Result.Error("User already exists!") : new Result.Success<>(newUser);
    }
}
