package com.fsmc.backend.service;

import com.fsmc.backend.data.model.UserRatingItem;

import java.util.List;

public interface UserRatingService {
    List<UserRatingItem> getAllByCompany(String company);
}
