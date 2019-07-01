package com.nemo.registartion.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;
}
