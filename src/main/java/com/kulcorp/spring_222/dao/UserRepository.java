package com.kulcorp.spring_222.dao;

import com.kulcorp.spring_222.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
