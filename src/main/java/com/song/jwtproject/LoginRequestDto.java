package com.song.jwtproject;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
