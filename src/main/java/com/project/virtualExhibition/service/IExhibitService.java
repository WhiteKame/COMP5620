package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Arts;
import com.project.virtualExhibition.entity.Exhibit;
import com.project.virtualExhibition.entity.User;

import java.util.List;

public interface IExhibitService {

    Exhibit findById(Integer id);

    List<Exhibit> findRequestByArtistId(Integer aid);

    List<Exhibit> findAlreadyByArtistId(Integer aid);

    int save(Integer artistId, Exhibit exhibit);

    Integer delete(int id);

    Integer pass(int id);

    Integer rejected(int id);
}
