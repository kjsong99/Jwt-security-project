package com.song.jwtproject.controller;

import com.song.jwtproject.model.User;
import com.song.jwtproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    public UserRepository userRepository;
    @GetMapping("/home")
    public String home(){
        return "<h1>home</h1>";
    }

    @PostMapping ("/token")
    public String token(){
        return "<h1>token</h1>";
    }


    @PostMapping("/join")
    public @ResponseBody String join(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");

        userRepository.save(user);
        LOGGER.info("User : {}", user);
        return "회원가입 완료";


    }

    @GetMapping("/manager/test")
    public @ResponseBody String managerAuthTest(){
        return "<h1>Manager</h1>";
    }

    @GetMapping("/admin/test")
    public @ResponseBody String AdminAuthTest(){
        return "<h1>Admin</h1>";
    }
    @GetMapping("/user/test")
    public @ResponseBody String UserAuthTest(){
        return "<h1>User</h1>";
    }
}
