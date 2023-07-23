package io.ngshoop.userservice.service.mapper;

import io.ngshoop.userservice.dto.UserDto;
import io.ngshoop.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {
    public UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getAddress(),
                user.getCountry().getName(),
                user.getState().getName(),
                user.getState().getZipCode(),
                user.getCardName(),
                user.getCardNumber(),
                user.getExpiration(),
                user.getCvv()
        );
    }

}
