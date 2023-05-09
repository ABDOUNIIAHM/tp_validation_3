package com.example.tp_validation_3.controller;

import com.example.tp_validation_3.entity.User;
import com.example.tp_validation_3.service.IntUserService;
import com.example.tp_validation_3.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginSignUpController {
    private final IntUserService userService;
    @GetMapping("/signup")
    public String registerUser(Model model){

        User user = new User();
        model.addAttribute("user",user);
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user") User user, Model model){

        if(userService.validRegistration(user.getEmail())==true){
            userService.createUser(user);
            return "redirect:/login";
        }
        model.addAttribute("error","email already exists try again!");
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model, HttpServletRequest req){
        req.getSession().invalidate();

        model.addAttribute("user",new User());
        //model.addAttribute("session",req.getSession());
        return "login";
    }
    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("user") User user,Model model, HttpServletRequest req){
        if(userService.validLogin(user.getEmail(),user.getPassword())==true){
            req.getSession().setAttribute("email",user.getEmail());
            return "redirect:/contacts";
        }
        model.addAttribute("error","bad credentials try again!");
        return "login";
    }

}
