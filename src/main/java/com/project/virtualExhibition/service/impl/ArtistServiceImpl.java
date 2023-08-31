package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Artist;
import com.project.virtualExhibition.entity.User;
import com.project.virtualExhibition.mapper.ArtistMapper;
import com.project.virtualExhibition.service.IArtistService;
import com.project.virtualExhibition.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Override
    public void signUp(Artist artist) {
        String username = artist.getUsername();
        Artist account = artistMapper.findByUsername(username);

        //check if the username is used when signing up.
        if(account != null) {
            throw new UsernameIsUsedException("Username is used!");
        }

        //encrypt the password.
        String phone = artist.getPhone();
        String email = artist.getEmail();
        String password = artist.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        artist.setPassword(md5Password);
        artist.setSalt(salt);
        artist.setPhone(phone);
        artist.setEmail(email);
        //check if the registration information is inserted.
        Integer result = artistMapper.insert(artist);
        if (result != 1) {
            throw new ServiceException("Failed to register, system problem.");
        }
    }

    //Login Service functions
    @Override
    public Artist login(String username, String password) {

        Artist result = artistMapper.findByUsername(username);

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

        Artist artist = new Artist();
        artist.setId(result.getId());
        artist.setUsername(result.getUsername());
        return artist;
    }

    @Override
    public Artist reset(String username, String phone, String email, String password) {
        Artist result = artistMapper.findByUsername(username);

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

        Integer rows = artistMapper.reset(result);
        if (rows != 1) {
            throw new ServiceException("Failed to register, system problem.");
        }
        return null;
    }

    @Override
    public Artist getById(Integer id) {
        Artist result = artistMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Username doesn't exist.");
        }


        return result;
    }

    public Artist getAllbyId(Integer id){
        return artistMapper.findById(id);
    }

    @Override
    public void changeInfo(Integer id, String username, Artist artist) {
        Artist result = artistMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Username doesn't exist.");
        }

        artist.setId(id);
        artist.setUsername(username);

        Integer rows = artistMapper.updateInfoById(artist);

        if (rows != 1) {
            throw  new ServiceException("Something wrong with database.");
        }
    }

}
