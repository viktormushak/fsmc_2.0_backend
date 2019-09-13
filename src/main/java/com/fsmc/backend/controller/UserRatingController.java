package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.UserRatingItem;
import com.fsmc.backend.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class UserRatingController {

    private final UserRatingService userRatingService;

    @Autowired
    public UserRatingController(UserRatingService userRatingService) {
        this.userRatingService = userRatingService;
    }

    @GetMapping("/company/{company}")
    public List<UserRatingItem> getUsersByCompany(@PathVariable("company") String company){
        return userRatingService.getAllByCompany(company);
    }
}
