package com.example.sociallapp.auth;

import com.example.sociallapp.dao.ProfileDao;
import com.example.sociallapp.dao.UserDao;
import com.example.sociallapp.models.Profile;
import com.example.sociallapp.models.Users;
import com.example.sociallapp.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthSerwice {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final ProfileDao profileDao;

    @Autowired
    public AuthSerwice(JwtService jwtService, AuthenticationManager authenticationManager, UserDao userDao, PasswordEncoder passwordEncoder, ProfileDao profileDao) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.profileDao = profileDao;
    }

    public boolean register_walidace(RegisterRequest request) {
        Users f_by_email = userDao.findByEmail(request.getEmail()).orElse(null);
        Users f_by_username = userDao.findByUsername(request.getUsername()).orElse(null);
        if (f_by_email == null && f_by_username == null) return true;
        else return false;
    }

    public String register(RegisterRequest request) {
        if (register_walidace(request)) {

            var user = Users.builder()
                    .email(request.getEmail())
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();
            Profile profile = new Profile();
            userDao.save(user);
            profileDao.save_profile(profile);

            return "Registration Sucseed";
        } else {
            return null;
        }


    }

    public AuthResponse authenticate(AuthRequest request) {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())

            );
        } catch (AuthenticationException e) {
            return null;
        }
        Object user = null;
        user = userDao.findByEmail(request.getEmail()).orElseThrow();
        var jwt_token = jwtService.generateToken((UserDetails) user);
        return AuthResponse.builder().
                token(jwt_token).
                build();

    }


}
