package com.example.springsecurityjwt.resource;

import com.example.springsecurityjwt.jwt.JwtUtil;
import com.example.springsecurityjwt.model.AuthenticationRequest;
import com.example.springsecurityjwt.model.AuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloResource {

    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;

    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }

    @PostMapping("/authenticate")
    ResponseEntity<?> createToken(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));

    }
}
