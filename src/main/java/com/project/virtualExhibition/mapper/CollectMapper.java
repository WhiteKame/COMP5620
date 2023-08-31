package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {

    List<Collect> findlistByUserId(Integer user_id);

    int save(Collect collect);
}
