package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Arts;
import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.entity.MyCollect;
import com.project.virtualExhibition.service.IMyCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyCollectController {

    @Autowired
    private IMyCollectService myCollectService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    @GetMapping("/web/favouriteList")
    public String list(Model mod, HttpSession session) {
        Integer user_id = getIdFromSession(session);
        List<MyCollect> Collect = myCollectService.findMyCollect(user_id);
        mod.addAttribute("collect", Collect);
        return "favouriteList";
    }
}
