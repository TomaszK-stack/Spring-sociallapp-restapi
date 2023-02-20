package com.example.sociallapp.api;

import com.example.sociallapp.dao.ProfileDao;
import com.example.sociallapp.dao.UserDao;
import com.example.sociallapp.models.Profile;
import com.example.sociallapp.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    UserDao userDao;

    @Autowired
    ProfileDao profileDao;

    @GetMapping("/user/{id}")
    public Users test(@PathVariable String id){
        Long id_d = Long.parseLong(id);
        System.out.println(id_d);
        Optional<Users> user = userDao.findById(id_d);
        Users user_d = user.orElse(null);
        return user_d;

}




    @GetMapping("/profile/{id}")
    public Profile getProfile(@PathVariable("id") long id){

        return profileDao.findByid(id);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/profile/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void update_profile(@PathVariable("id") Long id, @RequestBody Profile profile){
        Profile exprofile = profileDao.findByid(id);
        exprofile.setName(profile.getName());
        exprofile.setSurname(profile.getSurname());
        profileDao.save_profile(exprofile);

    }


}
