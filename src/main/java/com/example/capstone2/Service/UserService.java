package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    public List<User>  getAllUser (){
        return userRepository.findAll();
    }
    public void addUser(User user){
        if (user==null){
            throw new ApiException("User not found");
        }
        userRepository.save(user);

    }
    public void updateUser (Integer id , User user){
        User oldUser = userRepository.findUserById(id);
        if (oldUser==null){
            throw new ApiException("User not found");
        }
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        oldUser.setBio(user.getBio());
        userRepository.save(oldUser);
    }
    public void deleteUser(Integer id ){
        User user = userRepository.findUserById(id);
        if (user==null){
            throw new ApiException("User not found");
        }
        userRepository.delete(user);
    }
}
