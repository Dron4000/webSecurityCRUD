package com.javacode.Service;

import com.javacode.Model.User;
import com.javacode.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        List<User>list = new ArrayList<>();
   userRepository.findAll().forEach(list::add);
        return list;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserBtId(Long id) {
        userRepository.deleteById( id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
