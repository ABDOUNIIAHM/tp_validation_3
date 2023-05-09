package com.example.tp_validation_3.repository;

import com.example.tp_validation_3.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    Contact findByEmail(String email);
    Optional<Contact> findById(Long id);
}
