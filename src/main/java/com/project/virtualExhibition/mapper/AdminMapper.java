package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Admin;

public interface AdminMapper {


    Admin findByUsername(String username);

    Integer insert(Admin admin);

    Integer reset(Admin admin);

    Admin findById(Integer id);

    Integer updateInfoById(Admin admin);


}
