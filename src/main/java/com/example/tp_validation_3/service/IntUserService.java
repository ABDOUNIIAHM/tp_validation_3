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
    List<Contact> findAllContacts(long userId);
    User findById(long id);
    Contact findContactByName(long userId, String name);
    void addContactForUser(long id,Contact contact);
    void updateContactOfUser(long id, Contact contact);
    void deleteContactFromUser(long id, long idContact);
}
