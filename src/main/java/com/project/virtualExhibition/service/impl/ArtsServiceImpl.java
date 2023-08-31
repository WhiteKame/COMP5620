package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Arts;
import com.project.virtualExhibition.mapper.ArtsMapper;
import com.project.virtualExhibition.service.IArtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtsServiceImpl implements IArtsService {

    @Autowired
    private ArtsMapper artsMapper;

    @Autowired
    public ArtsServiceImpl(ArtsMapper artsMapper) {
        this.artsMapper = artsMapper;
    }


    @Override
    public List<Arts> findList() {
        return artsMapper.findList();
    }

    @Override
    public Arts findbyId(int id){
        return artsMapper.findbyId(id);
    }


}
