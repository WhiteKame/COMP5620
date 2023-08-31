package com.project.virtualExhibition.mapper;

import com.project.virtualExhibition.entity.Artist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArtistMapperTests {

    @Autowired
    private ArtistMapper artistMapper;

    //Testing for userMapper.
    @Test
    public void insert() {
        Artist artist = new Artist();
        artist.setUsername("T1");
        artist.setPassword("1");
        artist.setPhone("1");
        artist.setEmail("1");
        Integer result = artistMapper.insert(artist);
        System.out.println(result);

    }

    @Test
    public void reset() {
        Artist artist = new Artist();
        artist.setUsername("T1");
        artist.setPassword("2");
        artist.setPhone("1");
        artist.setEmail("1");
        Integer result = artistMapper.reset(artist);
        System.out.println(result);
    }

    @Test
    public void findById() {
        System.out.println(artistMapper.findById(2));
    }

//    @Test
//    public void updateInfoById() {
//        Artist artist = new Artist();
//        artist.setId(2);
//        artist.setPhone("110");
//        artist.setEmail("110");
////        artist.updateInfoById(artist);
//    }

}
