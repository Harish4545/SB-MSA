package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
