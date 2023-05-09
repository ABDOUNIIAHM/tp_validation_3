package com.example.tp_validation_3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="contact")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String enterprise;
    private String email;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

}
