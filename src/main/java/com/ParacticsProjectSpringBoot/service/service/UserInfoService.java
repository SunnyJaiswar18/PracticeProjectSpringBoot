package com.ParacticsProjectSpringBoot.service.service;

import com.ParacticsProjectSpringBoot.service.entity.UserInfo;
import com.ParacticsProjectSpringBoot.service.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo saveUserInfo(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getAllUserInfo(){
        return userInfoRepository.findAll();
    }

    public UserInfo getUserById(long id){
        return userInfoRepository.findById(id).orElse(null);
    }

    public String deleteUserById(long id){
        userInfoRepository.deleteById(id);
        return "User deleted with given id:"+id;
    }
}
