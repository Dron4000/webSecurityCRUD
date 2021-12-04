package com.javacode.Controller;


import com.javacode.Model.User;
import com.javacode.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    String getAllUsers(Model model) {
        List<?> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "index";

    }

    @GetMapping(value = "/new")
    String showPageFormUsers(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping(value = "/save")
    String saveNewUser(@ModelAttribute(value = "user") User user) {
        userService.saveUser(user);
        return "redirect:/";

    }
    @GetMapping(value = "/edit/{id}")
    String updateUserById(@PathVariable(name = "id")int id,Model model){
        User user =  userService.getUserById((long) id);
        model.addAttribute("user",user);
        return "edit_user";

    }

    @GetMapping(value = "/delete/{id}")
    String deleteUserById(@PathVariable(name = "id")int id){
        userService.deleteUserBtId((long)id);
        return "redirect:/";
    }
}
