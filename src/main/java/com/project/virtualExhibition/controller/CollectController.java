package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Collect;
import com.project.virtualExhibition.entity.Exhibit;
import com.project.virtualExhibition.service.ICollectService;
import com.project.virtualExhibition.service.IMyCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

@Controller
public class CollectController {

    @Autowired
    private ICollectService collectService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    @RequestMapping("/favourite/{id}")
    public String add(@PathVariable int id, HttpSession session) throws IOException {
        Collect collect = new Collect();
        Integer uid = getIdFromSession(session);
        collect.setArt_id(id);
        collect.setUser_id(uid);
        collectService.save(collect);
        return "redirect:/web/detail/{id}";
    }
}
