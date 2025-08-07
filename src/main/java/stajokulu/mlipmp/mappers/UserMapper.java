package stajokulu.mlipmp.mappers;

import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.user.GetUserDto;
import stajokulu.mlipmp.entities.dto.user.LoginDto;

public class UserMapper {

    public static User toEntity(LoginDto loginDto){
        User user = new User();
        user.setEmail(loginDto.getEmail());
        user.setPassword_hash(loginDto.getPasswordHash());
        return user;
    }

    public static LoginDto toDto(User user){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(user.getEmail());
        loginDto.setPasswordHash(user.getPassword_hash());
        return loginDto;
    }

}
