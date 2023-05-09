package com.example.tp_validation_3.repository;

import com.example.tp_validation_3.entity.Contact;
import com.example.tp_validation_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
