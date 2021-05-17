package com.trinocode.junitmockito.service;

import com.trinocode.junitmockito.model.User;
import com.trinocode.junitmockito.repository.UserRepository;
import com.trinocode.junitmockito.util.NotificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return  userRepository.save(user);
    }

    public List<User> saveAllUser(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User>  findByUsreName(String userName){
        return userRepository.findByUserName(userName);
    }

    public void deleteUser(User user){
         userRepository.delete(user);
    }


    public String sendNotification(String email){
        return NotificationUtil.sendNotification(email);
    }
}
