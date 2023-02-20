package com.example.sociallapp.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest  {

    private String email;
    private String password;


}
