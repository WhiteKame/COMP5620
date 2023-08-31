package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Exhibit;

import java.util.List;

public interface AllExhibitMapper {
    List<Exhibit> findRequest();
    List<Exhibit> findAlready();
}
