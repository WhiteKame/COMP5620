package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.User;
import com.project.virtualExhibition.service.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    //Testing the signUp service function.
    @Test
    public void signUp() {
        try {
            User user = new User();
            user.setUsername("Charless");
            user.setPassword("1");
            user.setPhone("1");
            user.setEmail("1");
            userService.signUp(user);
            System.out.println("UserService function is all good.");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
        }
    }

    //Testing the login service function.
    @Test
    public void login() {
        try {
            userService.login("1", "1");
            System.out.println("UserService login function is all good.");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
        }
    }

    @Test
    public void reset() {
        try {

            userService.reset("1", "1", "1", "4");
            System.out.println("Password is changed.");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
        }
    }
    @Test
    public void getById() {
        System.out.println(userService.getById(2));
    }

    @Test
    public void changeInfo() {
        User user = new User();
        user.setPhone("222");
        user.setEmail("222");
        userService.changeInfo(2, "XiaoChou", user);
    }


}
