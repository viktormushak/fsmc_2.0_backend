package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.UserRatingItem;
import com.fsmc.backend.data.repo.UserRatingRepository;
import com.fsmc.backend.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRatingServiceImpl implements UserRatingService {

    private final UserRatingRepository userRatingRepository;

    @Autowired
    public UserRatingServiceImpl(UserRatingRepository userRatingRepository) {
        this.userRatingRepository = userRatingRepository;
    }

    @Override
    public List<UserRatingItem> getAllByCompany(String company) {
        return userRatingRepository.getAllByCompany(company);
    }
}
