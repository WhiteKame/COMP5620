package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.User;
import com.project.virtualExhibition.service.exceptions.*;
import com.project.virtualExhibition.service.IUserService;

import com.project.virtualExhibition.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;




@RestController
@RequestMapping("user")
public class UserController{

    @Autowired
    private IUserService userService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    @RequestMapping("signUp")
    public JsonResult<Void> signUp(User user) {
        JsonResult<Void> result = new JsonResult<>();

        try {
            userService.signUp(user);
            result.setState(200);
        } catch (UsernameIsUsedException e) {
            result.setState(400);
        } catch (UsernameIsEmptyException e) {
            result.setState(405);
        }
        return result;
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        JsonResult<User> result = new JsonResult<>();
        try {
            User data = userService.login(username, password);
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
    public JsonResult<User> reset(String username, String phone, String email, String password) {
        JsonResult<User> result = new JsonResult<>();
        try {
            userService.reset(username, phone, email, password);
            result.setState(200);
        } catch (DetailsAreWrongException e) {
            result.setState(501);
        } catch(UsernameNotFoundException e) {
            result.setState(502);
        }
        return result;
    }


    @RequestMapping("get_by_id")
    public JsonResult<User> getById(HttpSession session) {
        User data =
                userService.getById(getIdFromSession(session));
        return new JsonResult<>(200, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        Integer id = getIdFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(id, username, user);
        return new JsonResult<>(200);
    }




}
