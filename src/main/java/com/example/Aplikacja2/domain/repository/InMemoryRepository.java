package com.example.Aplikacja2.domain.repository;

import com.example.Aplikacja2.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class InMemoryRepository implements UserRepository {

    Map<String, User> users = new HashMap<>();
    public InMemoryRepository(){

    }

    @Override
    public void createuser(String username, int age, String city) {
        users.put(username, new User(username,city));
    }

    @Override
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void removeuser(String username) {
        users.remove(username);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void build() {
        createuser("Marcin",55,"Sieradz");
        createuser("Tomasz",45,"Jeruzal");
    }

    @Override
    public void createuser(User user) {

    }
    @Override
    public String toString(){
        return "UserRepository{"+ "Users = " + users + "}";
    }
}
