package com.medicalplatform.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@RestController("/user")
public class UserController {
    @GetMapping("/add")
    public String addUser(){
        return "add user";
    }
    @GetMapping("/delete")
    public String deleteUser(){
        return "delete user";
    }
    @GetMapping("/findall")
    public List<String> findAll(){
        return null;
    }
    @GetMapping("/findbyid")
    public String findById(){
        return "find by id";
    }
}
