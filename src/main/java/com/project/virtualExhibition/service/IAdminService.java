package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Admin;

public interface IAdminService {

    void signUp(Admin admin);

    Admin login(String username, String password);

    Admin reset(String username, String phone, String email, String password);

    Admin getById(Integer id);

    Admin getAllbyId(Integer id);

    void changeInfo(Integer id, String username, Admin admin);
}
