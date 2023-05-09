package com.example.tp_validation_3.service;

import com.example.tp_validation_3.entity.Contact;
import com.example.tp_validation_3.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ContactService implements IntContactService{
    private final ContactRepository contactRepository;


    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void deleteContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isEmpty()){
            throw new RuntimeException("No contact found with id:"+ id);
        }
        contactRepository.delete(contact.get());
    }

}
