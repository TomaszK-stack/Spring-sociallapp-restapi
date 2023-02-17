package com.example.sociallapp.api;

import com.example.sociallapp.dao.UserDao;
import com.example.sociallapp.models.Test;
import com.example.sociallapp.models.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    UserDao userDao;

    @GetMapping("/user/{id}")
    public Users test(@PathVariable String id){
        Long id_d = Long.parseLong(id);
        System.out.println(id_d);
        Optional<Users> user = userDao.findById(id_d);
        Users user_d = user.orElse(null);
        return user_d;

}

    @PostMapping(value =  "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Users create_user(@RequestBody Users user){
        userDao.save(user);

        return user;

    }


}
