package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Exhibit;
import com.project.virtualExhibition.service.IAllExhibitService;
import com.project.virtualExhibition.service.IExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ExhibitDisplayController {


    @Autowired
    private IExhibitService exhibitService;

    @Autowired
    private IAllExhibitService allexhibitService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }


    @GetMapping("/web/indexArtist")
    public String listInProcess(Exhibit exhibit, HttpSession session, Model model){
        Integer artistId = getIdFromSession(session);
        List<Exhibit> Exhibit = exhibitService.findRequestByArtistId(artistId);
        model.addAttribute("exhibitsAlready", Exhibit);
        return "/indexArtist";
    }

    @GetMapping("/web/indexArtistAlready")
    public String listAlready(Exhibit exhibit, HttpSession session, Model model){
        Integer artistId = getIdFromSession(session);
        List<Exhibit> Exhibit = exhibitService.findAlreadyByArtistId(artistId);
        model.addAttribute("exhibitsAlready", Exhibit);
        return "/indexArtistAlready";
    }

    @GetMapping("/web/indexAdmin")
    public String adminInProcess(Exhibit exhibit, Model model){
        List<Exhibit> Exhibit = allexhibitService.findRequest();
        model.addAttribute("exhibitsAlready", Exhibit);
        return "/indexAdmin";
    }

    @GetMapping("/web/indexAdminAlready")
    public String adminAlready(Exhibit exhibit, Model model){
        List<Exhibit> Exhibit = allexhibitService.findAlready();
        model.addAttribute("exhibitsAlready", Exhibit);
        return "/indexAdminAlready";
    }

    @RequestMapping("/pass/{id}")
    public String pass(@PathVariable int id, HttpServletResponse servletResponse) throws IOException {
        exhibitService.pass(id);
        return "redirect:/web/indexAdminAlready";
    }

    @RequestMapping("/rejected/{id}")
    public String rejected(@PathVariable int id, HttpServletResponse servletResponse) throws IOException {
        exhibitService.rejected(id);
        return "redirect:/web/indexAdmin";
    }

}
