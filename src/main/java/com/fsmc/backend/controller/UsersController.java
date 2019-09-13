package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.Credentials;
import com.fsmc.backend.data.model.Profile;
import com.fsmc.backend.service.CredentialsService;
import com.fsmc.backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final ProfileService profileService;
    private final CredentialsService credentialsService;

    @Autowired
    public UsersController(ProfileService profileService, CredentialsService credentialsService) {
        this.profileService = profileService;
        this.credentialsService = credentialsService;
    }

    @PostMapping("/add/credentials")
    public Credentials createUserCredentials(@RequestBody Credentials credentials){
        return credentialsService.saveNewCredentials(credentials);
    }

    @PostMapping("/update/profile")
    public Profile updateUserProfile(@RequestBody Profile profile, OAuth2Authentication authentication){
        return profileService.updateProfileByUsername(profile, (String) authentication.getPrincipal());
    }

    @PostMapping("/attach")
    public Profile updateUserAttachment(@RequestParam("rawName") String rawName, OAuth2Authentication authentication){
        return profileService.attachRawData(rawName, (String) authentication.getPrincipal());
    }

    @GetMapping
    public Profile getUserProfile(OAuth2Authentication authentication){
        return profileService.getUserProfile((String) authentication.getPrincipal());
    }
}
