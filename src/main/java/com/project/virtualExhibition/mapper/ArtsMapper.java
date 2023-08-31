package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Arts;

import java.util.List;

public interface ArtsMapper {

    List<Arts> findList();

    Arts findbyId(int id);
}
