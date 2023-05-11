package com.example.tp_validation_3.entity.dto;

import com.example.tp_validation_3.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ContactMapper.class})
public interface UserMapper {
    @Mapping(target = "contactList", source = "user.contacts")
    UserDto userToUserDto(User user);
}
