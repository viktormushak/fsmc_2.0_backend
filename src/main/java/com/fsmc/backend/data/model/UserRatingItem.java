package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingItem {

    private User user;
    private int score;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {

        private int uuid;
        private String rawData;
        private String rawAddress;
        private String name;
        private String surname;
        private String patronymic;
        private String region;
        private String city;
        private String street;
        private String building;
    }
}
