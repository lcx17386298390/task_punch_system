package com.acm.api.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Admin implements Serializable {
    int id;
    String email;
    String username;
    String password;
    String role;
}