package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.UserRatingItem;
import com.fsmc.backend.data.repo.UserRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRatingRepositoryImpl implements UserRatingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRatingRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserRatingItem> getAllByCompany(String company) {
        String sql =
                "select e_uuid, r_employee, r_address, user_name, user_surname, user_patronymic, region, city, street, building, quantity " +
                    "from " +
                        "(select e_uuid, r_address, r_employee, sum(quantity) as quantity " +
                            "from raw_data left join address on a_uuid = address.uuid where company_name = ? group by r_employee) as a " +
                    "left join  " +
                        "(select user.uuid as uuid, user_name, user_surname, user_patronymic, region, city, street, building " +
                            "from user left join address on main_address = address.uuid) as b " +
                                "on e_uuid = uuid order by quantity desc";
        return jdbcTemplate.query(sql, new String[]{company}, (rs, rowNum) -> UserRatingItem.builder()
                .user(UserRatingItem.User.builder()
                        .uuid(rs.getInt("e_uuid"))
                        .rawData(rs.getString("r_employee"))
                        .rawAddress(rs.getString("r_address"))
                        .name(rs.getString("user_name"))
                        .surname(rs.getString("user_surname"))
                        .patronymic(rs.getString("user_patronymic"))
                        .region(rs.getString("region"))
                        .city(rs.getString("city"))
                        .street(rs.getString("street"))
                        .building(rs.getString("building"))
                        .build())
                .score(rs.getInt("quantity"))
                .build());
    }
}
