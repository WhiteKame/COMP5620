package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Artist;
import com.project.virtualExhibition.entity.User;
import com.project.virtualExhibition.service.IArtistService;
import com.project.virtualExhibition.service.IArtsService;
import com.project.virtualExhibition.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserInfoController {
    @Resource
    @Autowired
    private IUserService userService;

    @Autowired
    private IArtistService artistService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    @GetMapping("/web/information")
    public String viewerInfo(Model model, HttpSession session) {
        Integer id = getIdFromSession(session);
        User info = userService.getAllbyId(id);
        model.addAttribute("userInfo", info);
        return "information";
    }

    @GetMapping("/web/informationArtist")
    public String artistInfo(Model model, HttpSession session) {
        Integer id = getIdFromSession(session);
        Artist info = artistService.getAllbyId(id);
        model.addAttribute("userInfo", info);
        return "informationArtist";
    }
}
