package by.masarnovsky.controller;

import by.masarnovsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsController {

    @Autowired
    UserService userService;



    // @RequestMapping("/")
    public String getName(Model ui){
        ui.addAttribute("name", "Maxon");
        return "home";
    }

    @RequestMapping("/getMyUsers")
    String getMyUsers(Model ui){
       ui.addAttribute("users", userService.listUsers());
        return "endTesting";
    }

}
