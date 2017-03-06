package by.masarnovsky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {

   // @RequestMapping("/")
    public String getName(Model ui){
        ui.addAttribute("name", "Maxon");
        return "home";
    }
}
