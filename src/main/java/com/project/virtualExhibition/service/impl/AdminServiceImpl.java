package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Admin;
import com.project.virtualExhibition.mapper.AdminMapper;
import com.project.virtualExhibition.service.IAdminService;
import com.project.virtualExhibition.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void signUp(Admin admin) {
        String username = admin.getUsername();
        Admin account = adminMapper.findByUsername(username);

        //check if the username is used when signing up.
        if(account != null) {
            throw new UsernameIsUsedException("Username is used!");
        }

        //encrypt the password.
        String phone = admin.getPhone();
        String email = admin.getEmail();
        String password = admin.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        admin.setPassword(md5Password);
        admin.setSalt(salt);
        admin.setPhone(phone);
        admin.setEmail(email);
        //check if the registration information is inserted.
        Integer result = adminMapper.insert(admin);
        if (result != 1) {
            throw new ServiceException("Failed to register, system problem.");
        }
    }

    //Login Service functions
    @Override
    public Admin login(String username, String password) {

        Admin result = adminMapper.findByUsername(username);

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

        Admin admin = new Admin();
        admin.setId(result.getId());
        admin.setUsername(result.getUsername());
        return admin;
    }



    @Override
    public Admin reset(String username, String phone, String email, String password) {
        Admin result = adminMapper.findByUsername(username);

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

        Integer rows = adminMapper.reset(result);
        if (rows != 1) {
            throw new ServiceException("Failed to register, system problem.");
        }
        return null;
    }

    @Override
    public Admin getById(Integer id) {
        Admin result = adminMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Username doesn't exist.");
        }
        return result;
    }

    public Admin getAllbyId(Integer id){
        return adminMapper.findById(id);
    }

    @Override
    public void changeInfo(Integer id, String username, Admin admin) {
        Admin result = adminMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Username doesn't exist.");
        }

        admin.setId(id);
        admin.setUsername(username);

        Integer rows = adminMapper.updateInfoById(admin);

        if (rows != 1) {
            throw  new ServiceException("Something wrong with database.");
        }
    }

}
