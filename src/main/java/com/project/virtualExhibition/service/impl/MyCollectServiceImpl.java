package com.project.virtualExhibition.service.impl;

import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.entity.MyCollect;
import com.project.virtualExhibition.mapper.CollectMapper;
import com.project.virtualExhibition.mapper.MyCollectMapper;
import com.project.virtualExhibition.service.IMyCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCollectServiceImpl implements IMyCollectService {

    @Autowired
    private MyCollectMapper myCollectMapper;

    @Override
    public List<MyCollect> findMyCollect(Integer user_id){
        return myCollectMapper.findMyCollect(user_id);
    }

}
