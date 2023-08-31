package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Exhibit;
import com.project.virtualExhibition.mapper.AllExhibitMapper;
import com.project.virtualExhibition.service.IAllExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllExhibitServiceImpl implements IAllExhibitService {

    @Autowired
    private AllExhibitMapper allexhibitMapper;

    @Override
    public List<Exhibit> findRequest(){
        return allexhibitMapper.findRequest();
    }

    @Override
    public List<Exhibit> findAlready(){
        return allexhibitMapper.findAlready();
    }

}
