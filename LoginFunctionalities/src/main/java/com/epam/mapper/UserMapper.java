package com.epam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.ForgetPasswordDto;
import com.epam.dto.ResetPasswordDto;
import com.epam.dto.UserRegisterationDto;
import com.epam.entity.User;

@Mapper
public interface UserMapper {

	public final UserMapper Instance = Mappers.getMapper(UserMapper.class);

	ForgetPasswordDto toForgetPasswordDto(User user);

	ResetPasswordDto toResetPasswordDto(User user);

	UserRegisterationDto toUserRegisterationDto(User user);

	User toUserFromUserRegisterationDto(UserRegisterationDto dto);

}
