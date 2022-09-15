package com.training.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.training.model.User;

@Repository
public interface UserRepo extends ReactiveMongoRepository<User, Integer> {

}
