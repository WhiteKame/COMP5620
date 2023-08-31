package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.entity.MyCollect;

import java.util.List;

public interface IMyCollectService {

    List<MyCollect> findMyCollect(Integer user_id);

}
