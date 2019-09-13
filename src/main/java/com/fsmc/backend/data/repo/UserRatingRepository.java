package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.UserRatingItem;

import java.util.List;

public interface UserRatingRepository {
    List<UserRatingItem> getAllByCompany(String company);
}
