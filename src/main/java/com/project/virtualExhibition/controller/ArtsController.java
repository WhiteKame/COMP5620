package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Arts;
import com.project.virtualExhibition.service.IArtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ArtsController {

    @Resource
    @Autowired
    private IArtsService artsService;

    @GetMapping("/web/list")
    public String list(Model mod) {
        List<Arts> Arts = artsService.findList();
        mod.addAttribute("arts", Arts);
        return "list";
    }

    @GetMapping("/web/detail/{id}")
    public String detail(Model model, @PathVariable Integer id){
        Arts arts = artsService.findbyId(id);
        model.addAttribute("artInfo", arts);
        return "detail";
    }
}
