package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Exhibit;
import com.project.virtualExhibition.mapper.ExhibitMapper;
import com.project.virtualExhibition.service.IExhibitService;
import com.project.virtualExhibition.service.exceptions.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExhibitServiceImpl implements IExhibitService {

    @Autowired
    private ExhibitMapper exhibitMapper;

    @Override
    public Exhibit findById(Integer id) {
        Exhibit result = exhibitMapper.findById(id);
        if (result == null) {
            throw new UsernameNotFoundException("Exhibit doesn't exist.");
        }
        return result;
    }

    @Override
    public List<Exhibit> findRequestByArtistId (Integer artistId){
        return exhibitMapper.findRequestByArtistId(artistId);
    }

    @Override
    public List<Exhibit> findAlreadyByArtistId (Integer artistId){
        return exhibitMapper.findAlreadyByArtistId(artistId);
    }


    @Override
    public int save(Integer artistId,Exhibit exhibit) {
        exhibit.setArtistId(artistId);
        return exhibitMapper.save(exhibit);
    }

    @Override
    public Integer delete(int id){
        return exhibitMapper.delete(id);
    }

    @Override
    public Integer pass(int id){
        return exhibitMapper.pass(id);
    }

    @Override
    public Integer rejected(int id){
        return exhibitMapper.rejected(id);
    }
}
