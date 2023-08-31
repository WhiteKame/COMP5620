package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.entity.MyCollect;

import java.util.List;

public interface MyCollectMapper {

    List<MyCollect> findMyCollect(Integer user_id);

}
