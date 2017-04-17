package by.masarnovsky.controller;

import by.masarnovsky.model.Module;
import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;
import by.masarnovsky.service.ModuleService;
import by.masarnovsky.service.ResultService;
import by.masarnovsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    ResultService resultService;

    @RequestMapping(method = RequestMethod.GET, params = "signin")
    public String sendSigninUserForm(Model model){
        model.addAttribute(new User());
        return "signin";
    }

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public String addNewUser(@Valid User user, BindingResult br, Model ui){
        if (br.hasErrors()){
            return "signin";
        }
        if (userService.getUserByLogin(user.getLogin()).isEmpty()){
            userService.addUser(user);
            ui.addAttribute("message", "Пользователь зарегистрирован. Пожалуйста, авторизуйтесь.");
        } else {
            ui.addAttribute("message", "Пользователь c таким логином уже существует!");
            return "signin";
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, params = "login")
    public String sendLoginUserForm(Model model){
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(User user, Model ui, HttpServletRequest request){
        List<User> currentUser = userService.getUserByLogin(user.getLogin());
        if (!currentUser.isEmpty() && currentUser.get(0).getPassword().equals(user.getPassword())){
            request.getSession().setAttribute("user", currentUser.get(0));
            request.getSession().setAttribute("isLogged", true);
        }
        else {
            ui.addAttribute("message", "Неверные данные");
            return "login";
        }
        return "redirect:/home";
    }

    @RequestMapping("/cabinet")
    public String cabinet(HttpServletRequest request){
        updateModulesResults(request);
        // get&set module status (from results)
        return "cabinet";
    }

    private void updateModulesResults(HttpServletRequest request){
        List<Module> modules = (List<Module>) request.getSession().getAttribute("modules");
        User user = (User) request.getSession().getAttribute("user");
        if (modules == null){
            modules = moduleService.getModules();
            request.getSession().setAttribute("modules", modules);
        }
        Map<Integer, String> resultStatus = new HashMap<>();
        List<Result> resultsForModule;
        String moduleStatus = "not_started";
        for (Module m: modules){
            resultsForModule = resultService.getUserResultByModule(user.getId(), m.getId());
            if (resultsForModule != null && resultsForModule.contains("passed")){
                moduleStatus = "passed";
            } else if (resultsForModule != null && resultsForModule.contains("failed")){
                moduleStatus = "failed";
            }
            resultStatus.put(m.getId(), moduleStatus);
        }
        request.getSession().setAttribute("resultStatus", resultStatus);
    }

    @RequestMapping("/logout")
    public String logoutUser(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
