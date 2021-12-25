package com.app.snayallspringboot.service;

import com.app.snayallspringboot.model.User;
import com.app.snayallspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> listOfUsers(){
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public ResponseEntity<Object> findUserById(int id){
        Optional<User> user = userRepository.findUserbyId(id);
        if(user.isEmpty()){
            return new ResponseEntity<>("There is no user",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }
}
