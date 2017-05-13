package by.masarnovsky.controller;

import by.masarnovsky.TestType;
import by.masarnovsky.model.*;
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
import java.util.Arrays;
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
        String page = "test";
        CurrentTestingSessionStorage testingSession = (CurrentTestingSessionStorage) request.getSession().getAttribute("testingSession");
        int userAnswer = -2;
        try {
            userAnswer = Integer.valueOf(request.getParameter("userAnswer"));
        } catch (NumberFormatException e) {
            //System.out.println("user input is empty");
        }
        boolean isTrue = false;
        if (testingSession.getRightAnswerId() == userAnswer) {
            isTrue = true;
        }
        testingSession.setUserAnswerToQuestion(isTrue);
        testingSession.setThatUserSeeQuestion(true);
//        testingSession.setUserAnswerToAnswersArray(isTrue);
        for (Boolean b: checkRightAnswers(testingSession)){
            System.out.println(b);
        }
        if (testingSession.toNextQuestion() == null){
//            page = getResults(request);
            return "forward:showResults";
        }
        request.getSession().setAttribute("testingSession", testingSession);
        return page;
    }

    @RequestMapping(value = "/getPrevQuestion", method = RequestMethod.POST)
    String getPrevQuestion(HttpServletRequest request) {
        CurrentTestingSessionStorage testingSession = (CurrentTestingSessionStorage) request.getSession().getAttribute("testingSession");
        testingSession.toPreviousQuestion();
        return "test";
    }

    @RequestMapping(value = "/showResults")
    String getResults(HttpServletRequest request, Model ui) {
        CurrentTestingSessionStorage testingSession = (CurrentTestingSessionStorage) request.getSession().getAttribute("testingSession");
        ui.addAttribute(testingSession);
        Boolean[] answers = checkRightAnswers(testingSession);
        int count = (int) Arrays.stream(answers).filter(a -> a == true).count();
        System.out.println(count);
        ui.addAttribute("answers", checkRightAnswers(testingSession));
        ui.addAttribute("rightAnswers", count);
        request.getSession().setAttribute("testingSession", null);
        return "endTesting";
    }

    Boolean[] checkRightAnswers(CurrentTestingSessionStorage testingSession) {
        Boolean[] answersArray = new Boolean[testingSession.getQuestionCount()];
        int ind = 0;
        for (QuestionWithAnswers q: testingSession.getQuestionWithAnswersList()){
            if (q.isUserChoseRightAnswer() == true && q.isUserSeeThisQuestion() == true){
                answersArray[ind++] = true;
            } else if (q.isUserChoseRightAnswer() == false && q.isUserSeeThisQuestion() == true) {
                answersArray[ind++] = false;
            } else {
                answersArray[ind++] = null;
            }
        }
        return answersArray;
    }

    void endTestAndCalculateResult() {
        //
    }

    private boolean isAnotherTestStarted(HttpServletRequest request){
        if (request.getSession().getAttribute("testingSession") == null)
            return false;
        return true;
    }
}

