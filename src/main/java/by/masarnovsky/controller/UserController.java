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
    public String addNewUser(@Valid User user, BindingResult br, HttpServletRequest request,Model ui){
        if (br.hasErrors()){
            return "signin";
        }
        if (userService.getUserByLogin(user.getLogin()).size() <= 0){
            if (!request.getParameter("repeatPassword").equals(user.getPassword())){
                ui.addAttribute("message", "Пароли не совпадают");
                return "signin";
            }
            userService.save(user);
            ui.addAttribute("message", "Пользователь зарегистрирован. Пожалуйста, авторизуйтесь.");
        } else {
            ui.addAttribute("message", "Пользователь c таким логином уже существует!");
            return "signin";
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, params = "login")
    public String sendLoginUserForm(Model model){
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(User user, Model ui, HttpServletRequest request){
        List<User> currentUser = userService.getUserByLogin(user.getLogin());
        String page = "redirect:/u/home";
        if (currentUser != null && currentUser.size() > 0 && currentUser.get(0).getPassword().equals(user.getPassword())){
            if (userService.isAdmin(currentUser.get(0))){
                page = "redirect:/admin/adminhome";
            }
            request.getSession().setAttribute("user", currentUser.get(0));
            request.getSession().setAttribute("isLogged", true);
        }
        else {
            ui.addAttribute("message", "Неверные данные");
            page = "login";
        }
        return page;
    }

    @RequestMapping("/u/cabinet")
    public String cabinet(HttpServletRequest request, Model ui){
        updateModulesResults(request);
        updateResultHistory(request, ui);
        updateChart(request, ui);
        return "cabinet";
    }

    private void updateChart(HttpServletRequest request, Model ui) {
        User user = (User) request.getSession().getAttribute("user");
        ui.addAttribute("failedAttempts", resultService.getFailedTestsCountForUser(user));
        ui.addAttribute("passedAttempts", resultService.getPassedTestsCountForUser(user));
    }

    private void updateModulesResults(HttpServletRequest request){
        List<Module> modules = (List<Module>) request.getSession().getAttribute("modules");
        User user = (User) request.getSession().getAttribute("user");
        if (modules == null){
            modules = moduleService.getModules();
            request.getSession().setAttribute("modules", modules);
        }
        Map<Integer, String> resultStatus = new HashMap<>();
        List<String> resultsForModule;
        String moduleStatus = "not_started";
        for (Module m: modules){
            resultsForModule = resultService.getUserStringResultByModule(user.getId(), m.getId());
            if (resultsForModule != null && resultsForModule.contains("passed")){
                moduleStatus = "passed";
            } else if (resultsForModule != null && resultsForModule.contains("failed")){
                moduleStatus = "failed";
            }
            resultStatus.put(m.getId(), moduleStatus);
            moduleStatus = "not_started";
        }
        request.getSession().setAttribute("resultStatus", resultStatus);
    }

    private void updateResultHistory(HttpServletRequest request, Model ui){
        User user = (User) request.getSession().getAttribute("user");
        List<Result> resultHistory = resultService.getUserResult(user);
        ui.addAttribute("resultHistory",resultHistory);
    }

    @RequestMapping("/logout")
    public String logoutUser(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
