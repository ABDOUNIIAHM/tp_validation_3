package com.example.tp_validation_3.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ContactDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String enterprise;
    private UserDto userDto;
}
