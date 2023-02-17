package com.example.sociallapp.dao;

import com.example.sociallapp.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<Users, Long> {
    Optional<Users> findById(Long id);
}
