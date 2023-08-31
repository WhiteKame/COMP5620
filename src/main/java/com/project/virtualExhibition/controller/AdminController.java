package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Admin;
import com.project.virtualExhibition.service.IAdminService;
import com.project.virtualExhibition.service.exceptions.DetailsAreWrongException;
import com.project.virtualExhibition.service.exceptions.PasswordIsWrongException;
import com.project.virtualExhibition.service.exceptions.UsernameIsUsedException;
import com.project.virtualExhibition.service.exceptions.UsernameNotFoundException;
import com.project.virtualExhibition.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    @RequestMapping("signUp")
    public JsonResult<Void> signUp(Admin admin) {
        JsonResult<Void> result = new JsonResult<>();

        try {
            adminService.signUp(admin);
            result.setState(200);
        } catch (UsernameIsUsedException e) {
            result.setState(400);
        }
        return result;
    }

    @RequestMapping("login")
    public JsonResult<Admin> login(String username, String password, HttpSession session) {
        JsonResult<Admin> result = new JsonResult<>();
        try {
            Admin data = adminService.login(username, password);
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
    public JsonResult<Admin> reset(String username, String phone, String email, String password) {
        JsonResult<Admin> result = new JsonResult<>();
        try {
            adminService.reset(username, phone, email, password);
            result.setState(200);
        } catch (DetailsAreWrongException e) {
            result.setState(501);
        } catch(UsernameNotFoundException e) {
            result.setState(502);
        }
        return result;
    }


    @RequestMapping("get_by_id")
    public JsonResult<Admin> getById(HttpSession session) {
        Admin data =
                adminService.getById(getIdFromSession(session));
        return new JsonResult<>(200, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(Admin admin, HttpSession session) {
        Integer id = getIdFromSession(session);
        String username = getUsernameFromSession(session);
        adminService.changeInfo(id, username, admin);
        return new JsonResult<>(200);
    }




}
