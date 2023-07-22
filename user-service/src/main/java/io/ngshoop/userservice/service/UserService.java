package io.ngshoop.userservice.service;

import io.ngshoop.userservice.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserDto> getUserByUsername(String username);
}
