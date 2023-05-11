package com.example.tp_validation_3.entity.dto;

import com.example.tp_validation_3.entity.Contact;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserDto {

    private long id;

    private String firstName;

    private String lastName;

    private String email;
    private String password;
    private List<ContactDto> contactList;
}
