package com.jack.api_user.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jack.api_user.infrastructure.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
