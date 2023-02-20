package com.example.sociallapp.dao;

import com.example.sociallapp.models.Profile;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDao {

    @Autowired
    EntityManager entityManager;
    @Transactional
    public Profile save_profile(Profile profile){
        entityManager.persist(profile);
        return profile;
    }
    @Transactional
    public Profile findByid(long id){
        Profile profile = (Profile) entityManager.find(Profile.class, id);
        return profile;
    }
    @Transactional
    public Profile update(Profile profile){
        entityManager.merge(profile);
        return profile;
    }

}
