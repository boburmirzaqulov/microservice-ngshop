package io.ngshoop.userservice.controller;

import io.ngshoop.userservice.dto.UserDto;
import io.ngshoop.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
}
