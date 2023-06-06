package com.devsuperior.hroauth.feign;

import com.devsuperior.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {

    @GetMapping("/{userId}")
    User findById(@PathVariable long userId);

    @GetMapping("/search")
    User findByEmail(@RequestParam String email);

}
