package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.Profile;
import com.fsmc.backend.data.network.Result;
import com.fsmc.backend.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfilesController {

    private final ProfilesService profilesService;

    @Autowired
    public ProfilesController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @GetMapping("/me")
    public Result getMe(OAuth2Authentication authentication){
        return getProfileByUsername((String) authentication.getPrincipal());
    }

    @GetMapping("/{username}")
    public Result getByUsername(@PathVariable("username") String username){
        return getProfileByUsername(username);
    }

    private Result getProfileByUsername(String username) {
        Profile profile = profilesService.getByUsername(username);
        return Profile.EMPTY.equals(profile) ? new Result.Error("Profile not found") : new Result.Success<>(profile);
    }
}
