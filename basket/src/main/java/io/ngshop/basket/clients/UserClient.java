package io.ngshop.basket.clients;

import io.ngshop.basket.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",url = "http://localhost:8095")
@Component
public interface UserClient {
    @GetMapping("/users/{username}")
    UserDto getUserByUsername(@PathVariable String username);
}
