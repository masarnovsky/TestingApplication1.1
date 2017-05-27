package by.masarnovsky.controller;

import by.masarnovsky.model.Module;
import by.masarnovsky.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/")
    String getStart(){
        return "index";
    }

    @RequestMapping("/u/home")
    String getHome(HttpServletRequest request) {
        List<Module> modules = (List<Module>) request.getSession().getAttribute("modules");
        if (modules == null){
            modules = moduleService.getModules();
            request.getSession().setAttribute("modules", modules);
        }
        return "home";
    }
}
