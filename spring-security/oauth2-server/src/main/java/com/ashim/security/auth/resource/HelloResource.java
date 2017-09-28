package com.ashim.security.auth.resource;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloResource {

    @GetMapping("/principal")
    public Authentication getPrincipal(Authentication authentication) {
        return authentication;
    }

    @GetMapping
    public String hello() {
        return "Hello World";
    }

}
