package com.viniciuspaim.workshopmongo.services;

import com.viniciuspaim.workshopmongo.domain.User;
import com.viniciuspaim.workshopmongo.repository.UserRepository;
import com.viniciuspaim.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = this.repo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ObjectNotFoundException("User not found");
        }
    }
}
