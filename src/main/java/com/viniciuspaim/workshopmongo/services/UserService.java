package com.viniciuspaim.workshopmongo.services;

import com.viniciuspaim.workshopmongo.DTO.UserDTO;
import com.viniciuspaim.workshopmongo.domain.User;
import com.viniciuspaim.workshopmongo.repository.UserRepository;
import com.viniciuspaim.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setMail(obj.getMail());
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
