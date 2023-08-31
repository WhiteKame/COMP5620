package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Arts;
import com.project.virtualExhibition.entity.User;
import com.project.virtualExhibition.service.IArtsService;
import com.project.virtualExhibition.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @Resource
    @Autowired
    private IArtsService artsService;
//
//
//    @GetMapping("/web/test")
//    public String test(Model mod) {
//        String text = "测试";
//        mod.addAttribute("test", text);
//        List<Arts> Arts = artsService.findList();
//        mod.addAttribute("arts", Arts);
//        return "test";
//    }
//
//    @GetMapping("/web/list")
//    public String list(Model mod) {
//        String text = "测试";
//        mod.addAttribute("test", text);
//        return "list";
//    }

//    @GetMapping("/web/test/{id}")
//    public String detail(Model model, @PathVariable Integer id){
//        Arts arts = artsService.findbyId(id);
////        List<Arts> Artsinfo = artsService.findList();
//        model.addAttribute("artInfo", arts);
//        return "test";
//    }

    @Autowired
    private IUserService userService;

//    protected final Integer getIdFromSession(HttpSession session) {
//        return Integer.valueOf(session.getAttribute("id").toString());
//    }
//
//    @GetMapping("/web/information")
//    public String info(Model model, HttpSession session){
//        Integer id = getIdFromSession(session);
//        User info = userService.getAllbyId(id);
//        model.addAttribute("userInfo", info);
//        return "information";
//    }
//}

}