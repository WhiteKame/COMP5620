package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.service.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectServiceTests {

    @Autowired
    private ICollectService collectService;

    //Testing the signUp service function.
    @Test
    public void findId() {
        System.out.println(collectService.findlistByUserId(1));
    }
}
