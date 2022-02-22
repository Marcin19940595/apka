package com.example.Aplikacja2.domain.repository;

import com.example.Aplikacja2.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository {
    void createuser(String username, int age, String city);
    Collection<User> getAllUsers();
    User getUser(String username);
    void removeuser(String username);
    List<User> findAll();
    @PostConstruct
    void build();
    void createuser(User user);


}
