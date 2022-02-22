package com.example.Aplikacja2.Services;

import com.example.Aplikacja2.User;
import com.example.Aplikacja2.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(){
        return new ArrayList<>(userRepository.getAllUsers());

    }
    public void saveusers(User user){
        userRepository.createuser(user);
    }
}
