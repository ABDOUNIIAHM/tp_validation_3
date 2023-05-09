package com.example.tp_validation_3.controller;

import com.example.tp_validation_3.entity.Contact;
import com.example.tp_validation_3.service.UserService;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/contacts")
public class UserController {
    private final UserService userService;
    private HttpSession session;
    @GetMapping
    public String getAllContacts( Model model){

        List<Contact> contacts = userService.findAllContacts(1);
        model.addAttribute("contacts",contacts);
        return "home.html";

    }

    @PostMapping("/delete")
    public String deleteContact(@RequestParam("id") long id){
        userService.deleteContactFromUser(1,id);
        return "redirect:/contacts";
    }

    @PostMapping
    public String addContactToUser(Contact contact){
        userService.addContactForUser(1,contact);

        return "redirect:/contacts";
    }
    @GetMapping("/edit")
    public String getFormToEdit(HttpServletRequest req, Model model) {

        long id = Long.parseLong(req.getParameter("id"));
        Contact contact = userService.findAllContacts(1)
                .stream().filter(c -> c.getId()==id)
                .findFirst().get();

        model.addAttribute("contact",contact);
        return "edit-contact";
    }
    @PostMapping("/edit")
    public String editContact(@RequestParam long id,@ModelAttribute("contact") Contact c){

       c.setId(id);
       userService.updateContactOfUser(1,c);
       return "redirect:/contacts";
    }
}
