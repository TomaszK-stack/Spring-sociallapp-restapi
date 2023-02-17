package com.example.sociallapp.models;


import com.sun.jdi.event.StepEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
@Entity
@Table(name = "users")
public class Users  {

    @Autowired

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    @Column(nullable = false)
    private String email;

    @Column(nullable = false , name = "username")
    private String username;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(name = "role")
    private Roles roles;



    @PrePersist
    public void prePersist(){
        if(roles == null){
            roles = Roles.USER;
        }
    }


}
