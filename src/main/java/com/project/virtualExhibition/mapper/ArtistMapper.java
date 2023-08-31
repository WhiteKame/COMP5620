package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Artist;

public interface ArtistMapper {


    Artist findByUsername(String username);

    Integer insert(Artist artist);

    Integer reset(Artist artist);

    Artist findById(Integer id);

    Integer updateInfoById(Artist artist);


}
