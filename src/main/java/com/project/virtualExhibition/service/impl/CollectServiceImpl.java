package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.mapper.CollectMapper;
import com.project.virtualExhibition.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public List<Collect> findlistByUserId(Integer user_id){
        return collectMapper.findlistByUserId(user_id);
    }

    @Override
    public int save(Collect collect){
        return collectMapper.save(collect);
    }
}
