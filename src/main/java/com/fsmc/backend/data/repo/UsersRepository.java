package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
