package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateById(int id, User user) {
        userRepository.findOneById(id).orElseThrow(EntityNotFoundException::new);
        user.setId(id);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}