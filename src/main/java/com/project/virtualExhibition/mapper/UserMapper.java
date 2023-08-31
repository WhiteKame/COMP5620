package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.User;

public interface UserMapper {


    User findByUsername(String username);

    Integer insert(User user);

    Integer reset(User user);

    User findById(Integer id);


    Integer updateInfoById(User user);


}
