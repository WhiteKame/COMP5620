package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Arts;

import java.util.List;

public interface IArtsService {

    List<Arts> findList();

    Arts findbyId(int id);
}
