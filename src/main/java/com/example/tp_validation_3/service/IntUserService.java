package com.example.tp_validation_3.service;

import com.example.tp_validation_3.entity.Contact;
import com.example.tp_validation_3.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IntUserService {
    User createUser(User user);
    void updateUser(User user);
    List<Contact> findAllContacts(Long userId);
    User findById(Long id);
    Contact findContactByName(Long userId, String name);
    void addContactForUser(Long id,Contact contact);
    void updateContactOfUser(Long id, Contact contact);
    void deleteContactFromUser(Long id, Long idContact);
}
