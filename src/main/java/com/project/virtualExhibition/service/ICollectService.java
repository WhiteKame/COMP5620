package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Collect;

import java.util.List;

public interface ICollectService {

    List<Collect> findlistByUserId(Integer user_id);

    int save(Collect collect);

}
