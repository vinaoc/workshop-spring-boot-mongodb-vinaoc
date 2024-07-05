package com.viniciuspaim.workshopmongo.repository;

import com.viniciuspaim.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

