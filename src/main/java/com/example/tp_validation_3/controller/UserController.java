package com.example.tp_validation_3.controller;
import com.example.tp_validation_3.entity.Contact;
import com.example.tp_validation_3.entity.User;
import com.example.tp_validation_3.service.IntUserService;
import com.example.tp_validation_3.service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/contacts")
public class UserController {
    private final IntUserService userService;
    private final UserDetailsServiceImpl userDetailsService;

    private User getSessionEmailUser(HttpServletRequest req){
        String email = (String) req.getAttribute("email");
        User user = (User) userDetailsService.loadUserByUsername(email);
        return user;
    }
    @GetMapping
    public String getAllContacts(HttpServletRequest req, Model model){

        long id = getSessionEmailUser(req).getId();
        List<Contact> contacts = userService.findAllContacts(id);
        model.addAttribute("contacts",contacts);
        return "home.html";

    }
    @PostMapping("/delete")

    public String deleteContact(@RequestParam("id") long id,HttpServletRequest req){

        long idUser = getSessionEmailUser(req).getId();
        userService.deleteContactFromUser(idUser,id);
        return "redirect:/contacts";

    }
    @PostMapping
    public String addContactToUser(Contact contact,HttpServletRequest req){
        long idUser = getSessionEmailUser(req).getId();
        userService.addContactForUser(idUser,contact);
        return "redirect:/contacts";
    }
    @GetMapping("/edit")
    public String getFormToEdit(HttpServletRequest req, Model model) {

        long idUser = getSessionEmailUser(req).getId();
        long id = Long.parseLong(req.getParameter("id"));
        Contact contact = userService.findAllContacts(idUser)
                .stream().filter(c -> c.getId()==id)
                .findFirst().get();

        model.addAttribute("contact",contact);
        return "edit-contact";

    }
    @PostMapping("/edit")
    public String editContact(@RequestParam long id,@ModelAttribute("contact") Contact c,HttpServletRequest req){

       long idUser = getSessionEmailUser(req).getId();
       c.setId(id);
       userService.updateContactOfUser(idUser,c);
       return "redirect:/contacts";

    }
}
