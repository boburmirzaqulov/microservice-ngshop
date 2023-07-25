package io.ngshop.basket.clients;

import io.ngshop.basket.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-service")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}")
    UserDTO getUser(@PathVariable String username);
}
