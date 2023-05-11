package com.example.tp_validation_3.entity.dto;

import com.example.tp_validation_3.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    @Mapping(target = "userDto" , source = "contact.user")
    ContactDto ContactToContactDto(Contact contact);
}
