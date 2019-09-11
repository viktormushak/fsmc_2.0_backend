package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.model.UserProfile;
import com.fsmc.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return usersService.create(user);
    }

    @PostMapping("/profile/update")
    public UserProfile updateProfile(@RequestBody UserProfile userProfile, OAuth2Authentication authentication){
        return usersService.updateProfile(userProfile, (String) authentication.getPrincipal());
    }

    @GetMapping("/profile")
    public UserProfile getPrincipalProfile(OAuth2Authentication authentication){
        return usersService.getProfileByUuid((String) authentication.getPrincipal());
    }

    @GetMapping("/profile/id/{uuid}")
    public UserProfile getProfileByUuid(@PathVariable("uuid") String uuid){
        return usersService.getProfileByUuid(uuid);
    }
}
