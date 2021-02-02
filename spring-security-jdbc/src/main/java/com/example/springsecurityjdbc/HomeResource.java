package com.example.springsecurityjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    String home(){
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    String user(){
        return "<h1>Welcome User</h1>";
    }

    @GetMapping("/admin")
    String admin(){
        return "<h1>Welcome Admin</h1>";
    }
}
