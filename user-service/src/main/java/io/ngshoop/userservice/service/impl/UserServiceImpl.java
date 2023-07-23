package io.ngshoop.userservice.service.impl;

import io.ngshoop.userservice.dto.UserDto;
import io.ngshoop.userservice.exception.NoResourceFoundException;
import io.ngshoop.userservice.model.User;
import io.ngshoop.userservice.repo.UserRepository;
import io.ngshoop.userservice.service.UserService;
import io.ngshoop.userservice.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public ResponseEntity<UserDto> getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoResourceFoundException("user not found"));
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
