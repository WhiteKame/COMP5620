package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Exhibit;

import java.util.List;

public interface ExhibitMapper {

    int save(Exhibit exhibit);

    Exhibit findById(Integer id);

    List<Exhibit> findRequestByArtistId(Integer artistId);

    List<Exhibit> findAlreadyByArtistId(Integer artistId);

    Integer delete(int id);

    Integer pass(int id);

    Integer rejected(int id);

    Integer UpdateImageById(Integer id, String image);
}
