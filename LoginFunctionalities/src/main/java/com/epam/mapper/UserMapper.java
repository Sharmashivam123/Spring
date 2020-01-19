package com.epam.mapper;

import org.mapstruct.Mapper;

import com.epam.Entity.User;

@Mapper
public interface UserMapper {

	User toForgetPasswordDto(User user);

	User toResetPasswordDto(User user);

}
