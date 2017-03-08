package by.masarnovsky.controller;

import by.masarnovsky.model.Question;
import by.masarnovsky.service.AnswerService;
import by.masarnovsky.service.QuestionService;
import by.masarnovsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UsController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;


    // @RequestMapping("/")
    public String getName(Model ui){
        ui.addAttribute("name", "Maxon");
        return "home";
    }

    @RequestMapping("/getMyUsers")
    String getMyUsers(Model ui){
        List<Question> q = questionService.getQuestionSet(3);
       ui.addAttribute("users", userService.listUsers());
       ui.addAttribute("quest", q);
       ui.addAttribute("answ", answerService.getAnswersForQuestion(q.get(1)));
        return "endTesting";
    }

}
