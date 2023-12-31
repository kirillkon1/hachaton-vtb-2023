package ru.vtb.vtbbackend.web.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vtb.vtbbackend.web.dto.request.RegisterRequest;
import ru.vtb.vtbbackend.auth.user.User;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    UserDto userToUserDto(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "firstName", target = "name")
    @Mapping(source = "lastName", target = "surname")
    @Mapping(source = "phone", target = "phoneNumber")
    User registerReqToUser(RegisterRequest registerReq);
}
