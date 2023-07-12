package com.acm.api.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Student implements Serializable {
    private int id;

    private String email;

    private String username;

    private String password;

}