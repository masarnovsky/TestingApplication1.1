package by.masarnovsky.controller;

import by.masarnovsky.model.User;
import by.masarnovsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String sendUserForm(Model model){
        model.addAttribute(new User());
        return "signin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") User user, Model ui){
        User u = userService.getUserByLogin(user.getLogin());
        System.out.println(u);
        if (u != null){
            ui.addAttribute("msg", "Пользователь уже существует");
        } else {
            userService.addUser(user);
            ui.addAttribute(user);
        }
        return "home";
    }
}
