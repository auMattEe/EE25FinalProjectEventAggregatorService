package com.example.EE25FinalProjectEventAggregatorService.user;

import com.example.EE25FinalProjectEventAggregatorService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByUsernameAndPassword(String username, String password);

    boolean existsByUsernameOrEmail(String username, String email);
}
