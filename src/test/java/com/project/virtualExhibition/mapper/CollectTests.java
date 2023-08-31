package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Artist;
import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.entity.MyCollect;
import com.project.virtualExhibition.service.ICollectService;
import com.project.virtualExhibition.service.IMyCollectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectTests {

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private ICollectService collectService;

    @Autowired
    private MyCollectMapper myCollectMapper;

    @Autowired
    private IMyCollectService myCollectService;

    @Autowired
    private  AllExhibitMapper allExhibitMapper;

//    Testing for userMapper.
    @Test
    public void insert() {
        Collect collect = new Collect();
        collect.setArt_id(1);
        collect.setUser_id(1);
        collectService.save(collect);
    }


    @Test
    public void findListbyUserId() {
        System.out.println(collectMapper.findlistByUserId(1));
    }

    @Test
    public void find() {
        System.out.println(myCollectMapper.findMyCollect(1));
    }

    @Test
    public void find2() {
        System.out.println(allExhibitMapper.findRequest());
    }

}
