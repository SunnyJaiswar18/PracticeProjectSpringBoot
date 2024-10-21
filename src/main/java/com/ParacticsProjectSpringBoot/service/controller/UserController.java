package com.ParacticsProjectSpringBoot.service.controller;

import com.ParacticsProjectSpringBoot.service.entity.UserInfo;
import com.ParacticsProjectSpringBoot.service.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//practices purpose
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(path = "/saveUser",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserInfo saveUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.saveUserInfo(userInfo);
    }

    @GetMapping(path = "/getAllUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserInfo> getAllUserInfo(){
        return userInfoService.getAllUserInfo();
    }

    @GetMapping(path = "/getUserById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserInfo getAllUserInfo(@PathVariable(name = "id")long id){
        return userInfoService.getUserById(id);
    }

    @DeleteMapping(path = "/deleteUserById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUserInfoById(@PathVariable(name = "id")long id){
        return userInfoService.deleteUserById(id);
    }

}
