package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Exhibit;

import java.util.List;

public interface IAllExhibitService {

    List<Exhibit> findRequest();

    List<Exhibit> findAlready();
}
