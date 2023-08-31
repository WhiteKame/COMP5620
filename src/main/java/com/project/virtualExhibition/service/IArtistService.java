package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Artist;
import com.project.virtualExhibition.entity.User;

public interface IArtistService {

    void signUp(Artist artist);

    Artist login(String username, String password);

    Artist reset(String username, String phone, String email, String password);

    Artist getById(Integer id);

    Artist getAllbyId(Integer id);

    void changeInfo(Integer id, String username, Artist artist);
}
