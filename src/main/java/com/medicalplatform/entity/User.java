package com.medicalplatform.entity;

import javax.persistence.*;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String hashedPassword;

    @Column(nullable = false)
    private String userRole;
}
