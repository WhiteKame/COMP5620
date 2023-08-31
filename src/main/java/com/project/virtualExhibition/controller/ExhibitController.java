package com.project.virtualExhibition.controller;

import com.project.virtualExhibition.entity.Arts;
import com.project.virtualExhibition.entity.Exhibit;
import com.project.virtualExhibition.service.IArtsService;
import com.project.virtualExhibition.service.IExhibitService;
import com.project.virtualExhibition.service.exceptions.FileStateException;
import com.project.virtualExhibition.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ExhibitController {
    @Autowired
    private IExhibitService exhibitService;

    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpServletResponse servletResponse) throws IOException {
        exhibitService.delete(id);
        return "redirect:/web/indexArtist";
    }


    @PostMapping("add")
    public String save(Exhibit exhibit, HttpSession session){
        Integer artistId = getIdFromSession(session);
        exhibitService.save(artistId, exhibit);
        return "redirect:/web/indexArtist";
    }

}
