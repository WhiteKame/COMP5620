package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    //Testing for userMapper.
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("T1");
        user.setPassword("1");
        user.setPhone("1");
        user.setEmail("1");
        Integer result = userMapper.insert(user);
        System.out.println(result);

    }

    @Test
    public void reset() {
        User user = new User();
        user.setUsername("T1");
        user.setPassword("2");
        user.setPhone("1");
        user.setEmail("1");
        Integer result = userMapper.reset(user);
        System.out.println(result);
    }

    @Test
    public void findById() {
        System.out.println(userMapper.findById(2));
    }

    @Test
    public void updateInfoById() {
        User user = new User();
        user.setId(2);
        user.setPhone("110");
        user.setEmail("110");
        userMapper.updateInfoById(user);
    }

}
