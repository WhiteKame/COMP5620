package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.User;
import com.project.virtualExhibition.mapper.UserMapper;
import com.project.virtualExhibition.service.IUserService;
import com.project.virtualExhibition.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void signUp(User user) {
        String username = user.getUsername();
        User account = userMapper.findByUsername(username);

        //check if the username is used when signing up.
        if(account != null) {
            throw new UsernameIsUsedException("Username is used!");
        }

        if(username == null){
            throw new UsernameIsEmptyException("Username is empty!");
        }

        //encrypt the password.
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        user.setPassword(md5Password);
        user.setSalt(salt);
        user.setPhone(phone);
        user.setEmail(email);
        //check if the registration information is inserted.
        Integer result = userMapper.insert(user);
        if (result != 1) {
            throw new ServiceException("Failed to register, system problem.");
        }
    }

    //Login Service functions
    @Override
    public User login(String username, String password) {

        User result = userMapper.findByUsername(username);

        //check if the username exists.
        if (result == null) {
            throw new UsernameNotFoundException("Username does not exist.");
        }

        //if exists, check if the password is correct.
        String passwordInDB = result.getPassword();
        String salt = result.getSalt();

        //encrypt the password.
        String InputMd5Password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();

        if (!InputMd5Password.equals(passwordInDB)) {
            throw new PasswordIsWrongException("Incorrect password.");
        }

        User user = new User();
        user.setId(result.getId());
        user.setUsername(result.getUsername());
        return user;
    }



    @Override
    public User reset(String username, String phone, String email, String password) {
        User result = userMapper.findByUsername(username);

        //check if the username exists.
        if (result == null) {
            throw new UsernameNotFoundException("Username does not exist.");
        }
        String phoneInDB = result.getPhone();
        String emailInDB = result.getEmail();
        String salt = result.getSalt();


        if(!phone.equals(phoneInDB) || !email.equals(emailInDB)) {
            throw new DetailsAreWrongException("Details are wrong.");
        }

        String newMd5Password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();

        result.setPassword(newMd5Password);

        Integer rows = userMapper.reset(result);
        if (rows != 1) {
            throw new ServiceException("Failed to register, system problem.");
        }
        return null;
    }

    @Override
    public User getById(Integer id) {
        User result = userMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Username doesn't exist.");
        }
        return result;
    }

    public User getAllbyId(Integer id){
        return userMapper.findById(id);
    }

    @Override
    public void changeInfo(Integer id, String username, User user) {
        User result = userMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Username doesn't exist.");
        }

        user.setId(id);
        user.setUsername(username);

        Integer rows = userMapper.updateInfoById(user);

        if (rows != 1) {
            throw  new ServiceException("Something wrong with database.");
        }
    }

}
