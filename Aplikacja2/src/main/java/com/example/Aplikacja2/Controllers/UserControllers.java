package com.example.Aplikacja2.Controllers;

import com.example.Aplikacja2.Services.UserServices;
import com.example.Aplikacja2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllers {
    @Autowired
    UserServices userServices;

    @GetMapping("/users")
    public String getUsers (Model model){
        List<User> allusers = userServices.getAllUsers();
        model.addAttribute("user",allusers);
        return "users";
    }
    @GetMapping("/newuser")
    public String createuser (Model model){
        model.addAttribute("user",new User());
       return "newuser";
    }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String saveUser(User user){
        userServices.saveusers(user);
        return "redirect:/users";
    }

}
