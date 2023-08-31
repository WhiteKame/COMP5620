package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Artist;
import com.project.virtualExhibition.service.exceptions.DetailsAreWrongException;
import com.project.virtualExhibition.service.exceptions.PasswordIsWrongException;
import com.project.virtualExhibition.service.exceptions.UsernameIsUsedException;
import com.project.virtualExhibition.service.exceptions.UsernameNotFoundException;
import com.project.virtualExhibition.service.IArtistService;
import com.project.virtualExhibition.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("artist")
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    @RequestMapping("signUp")
    public JsonResult<Void> signUp(Artist artist) {
        JsonResult<Void> result = new JsonResult<>();

        try {
            artistService.signUp(artist);
            result.setState(200);
        } catch (UsernameIsUsedException e) {
            result.setState(400);
        }
        return result;
    }

    @RequestMapping("login")
    public JsonResult<Artist> login(String username, String password, HttpSession session) {
        JsonResult<Artist> result = new JsonResult<>();
        try {
            Artist data = artistService.login(username, password);
            result.setState(200);
            session.setAttribute("id", data.getId());
            session.setAttribute("username", data.getUsername());
        } catch (PasswordIsWrongException e) {
            result.setState(402);
        } catch(UsernameNotFoundException e) {
            result.setState(401);
        }
        return result;
    }

    @RequestMapping("reset")
    public JsonResult<Artist> reset(String username, String phone, String email, String password) {
        JsonResult<Artist> result = new JsonResult<>();
        try {
            artistService.reset(username, phone, email, password);
            result.setState(200);
        } catch (DetailsAreWrongException e) {
            result.setState(501);
        } catch(UsernameNotFoundException e) {
            result.setState(502);
        }
        return result;
    }


    @RequestMapping("get_by_id")
    public JsonResult<Artist> getById(HttpSession session) {
        Artist data =
                artistService.getById(getIdFromSession(session));
        return new JsonResult<>(200, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(Artist user, HttpSession session) {
        Integer id = getIdFromSession(session);
        String username = getUsernameFromSession(session);
        artistService.changeInfo(id, username, user);
        return new JsonResult<>(200);
    }




}
