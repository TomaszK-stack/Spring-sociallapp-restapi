package com.example.sociallapp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    AuthSerwice authSerwice;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        String reg = authSerwice.register(request);
        if(reg != null){return ResponseEntity.ok(reg);}
        else{return ResponseEntity.status(HttpStatus.CONFLICT).body("Username or Email is currently used");}


    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        AuthResponse ar = authSerwice.authenticate(request);
        if (ar != null) {
            return ResponseEntity.ok(ar);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }


}
