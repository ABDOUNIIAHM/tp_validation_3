package com.example.tp_validation_3.service;

import com.example.tp_validation_3.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IntContactService {
    Optional<Contact> findById(Long id);
    void deleteContact(Long idContact);

}
