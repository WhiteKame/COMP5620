package com.project.virtualExhibition.service;

import com.project.virtualExhibition.entity.Artist;
import com.project.virtualExhibition.service.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArtistServiceTests {

    @Autowired
    private IArtistService artistService;

    //Testing the signUp service function.
    @Test
    public void signUp() {
        try {
            Artist artist = new Artist();
            artist.setUsername("Charless");
            artist.setPassword("1");
            artist.setPhone("1");
            artist.setEmail("1");
            artistService.signUp(artist);
            System.out.println("UserService function is all good.");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
        }
    }

    //Testing the login service function.
    @Test
    public void login() {
        try {
            artistService.login("1", "1");
            System.out.println("UserService login function is all good.");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
        }
    }

    @Test
    public void reset() {
        try {

            artistService.reset("1", "1", "1", "4");
            System.out.println("Password is changed.");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
        }
    }
    @Test
    public void getById() {
        System.out.println(artistService.getById(2));
    }

    @Test
    public void changeInfo() {
        Artist artist = new Artist();
        artist.setPhone("222");
        artist.setEmail("222");
        artistService.changeInfo(2, "XiaoChou", artist);
    }


}
