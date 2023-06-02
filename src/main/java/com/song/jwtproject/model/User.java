package com.song.jwtproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles;

    public List<String> getRoles(){
        if (roles.length() > 0){
            return Arrays.asList(roles.split(","));
        }else {
            return new ArrayList<String>();
        }
    }
}
