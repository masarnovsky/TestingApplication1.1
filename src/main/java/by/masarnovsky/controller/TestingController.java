package by.masarnovsky.controller;

import by.masarnovsky.TestType;
import by.masarnovsky.model.Answer;
import by.masarnovsky.model.CurrentTestingSessionStorage;
import by.masarnovsky.model.Question;
import by.masarnovsky.model.User;
import by.masarnovsky.service.AnswerService;
import by.masarnovsky.service.QuestionService;
import by.masarnovsky.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/testing")
public class TestingController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/start/training", method = RequestMethod.GET)
    String startTraining(@RequestParam(value = "module", required = true) int module,
                         HttpServletRequest request, Model ui){
        if (isAnotherTestStarted(request)) {
            System.out.println();
            ui.addAttribute("msg", "Другой тест уже запущен!");
            return "home";
        }
        User user = (User) request.getSession().getAttribute("user");
        CurrentTestingSessionStorage testingSession = new CurrentTestingSessionStorage(user, TestType.TRAINING);
        List<Question> questions = questionService.getQuestionsForModule(module, testingSession.getTestType().getIntValue());
        Collections.shuffle(questions);
        testingSession.addQuestionsFromList(questions);
        for (Question q: questions){
            List<Answer> answers = answerService.getAnswersForQuestion(q);
            Collections.shuffle(answers);
            testingSession.getQuestionById(q.getId()).setAnswers(answers);
        }
        request.getSession().setAttribute("testingSession", testingSession);
        return "test";
    }

    @RequestMapping(value = "/start/testing", method = RequestMethod.GET)
    String startTesting(){
        return "test";
    }

    @RequestMapping(value = "/getNextQuestion", method = RequestMethod.POST)
    String getNextQuestion(HttpServletRequest request) {
        CurrentTestingSessionStorage testingSession = (CurrentTestingSessionStorage) request.getSession().getAttribute("testingSession");
        String userAnswer = request.getParameter("userAnswer");
        testingSession.toNextQuestion();
        request.getSession().setAttribute("testingSession", testingSession);
        return "test";
    }

    String getResults() {
        return "endTesting";
    }

    private boolean isAnotherTestStarted(HttpServletRequest request){
        if (request.getSession().getAttribute("testingSession") == null)
            return false;
        return true;
    }
}

