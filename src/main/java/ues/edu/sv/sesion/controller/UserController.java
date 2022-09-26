package ues.edu.sv.sesion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ues.edu.sv.sesion.service.UserService;


//http://localhost:8080/user/all-user
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/all-user")
    public String getAllUsersView(Model model) {
        model.addAttribute("user-list",userService.getAllUser());
        return "index.html";//devolviendo el template html
    }
    
    
}
