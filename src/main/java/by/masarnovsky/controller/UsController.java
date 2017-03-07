package by.masarnovsky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsController {

//    @Qualifier("userServiceImpl")
//    @Autowired
//    private UserService userService;

    // @RequestMapping("/")
    public String getName(Model ui){
        ui.addAttribute("name", "Maxon");
        return "home";
    }

    @RequestMapping("/getMyUsers")
    String getMyUsers(Model ui){
       // ui.addAttribute("userss", userService.listUsers());
        return "endTesting";
    }

}
