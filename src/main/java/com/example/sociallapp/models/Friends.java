package com.example.sociallapp.models;

import jakarta.persistence.*;

@Entity()
@Table(name = "Friends")
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "profile_1_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "profile_2_id")
    private Profile profile_2;

}
