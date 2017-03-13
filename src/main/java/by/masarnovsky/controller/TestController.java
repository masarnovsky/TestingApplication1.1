package by.masarnovsky.controller;

import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;
import by.masarnovsky.service.AnswerService;
import by.masarnovsky.service.QuestionService;
import by.masarnovsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    private final int TRAINING_SIZE = 3;
    private final int TESTING_SIZE = 6;

    private static int qId = 0;
    private static int qCount = 1;
    private static int rightAnswers = 0;
    private List<Question> questions = null;
    private boolean[] questionsAnsw = null;
    private Map<Integer, List<Answer>> answersMap = null;
    private Answer answer;
    private String testType = null;

    @RequestMapping("/startTest/{type}")
    String startTest(@PathVariable(value = "type") String type, HttpServletRequest request, Model ui){
        if (testType != null){ //request.getSession().getAttribute("testType")
            ui.addAttribute("msg", "another test started!");
            return "endTesting";
        }

        qId = 0;
        qCount = 1;
        rightAnswers = 0;
        if ("training".equals(type)){
            testType = "training";
            qCount = TRAINING_SIZE;
        } else if ("testing".equals(type)){
            testType = "testing";
            qCount = TESTING_SIZE;
        }

        questions = questionService.getQuestionSet(qCount);
        questionsAnsw = new boolean[qCount];
        answersMap = new HashMap<Integer, List<Answer>>();
        for (Question q: questions){
            List<Answer> a = answerService.getAnswersForQuestion(q);
            Collections.shuffle(a);
            answersMap.put(q.getId(), a);
        }

        ui.addAttribute("answersMap", answersMap);
        ui.addAttribute("questions", questions);
        ui.addAttribute("qId", qId);
        ui.addAttribute("qCount", qCount);
        ui.addAttribute("rightAnswers", rightAnswers);
        qId++;

        return "test";
    }

    @RequestMapping(value = "/getNextQuestion/{id}", method = RequestMethod.POST)
    String nextQuestion(@PathVariable(value = "id") int id, HttpServletRequest request, Model ui){
        String page = "test";
        List<Answer> a = answersMap.get(questions.get(qId-1).getId());


        for (Answer an: a){
            if (an.getId() == id){
                if (an.isRight()){
                    rightAnswers++;
                    questionsAnsw[qId-1] = true;
                }
                else
                    questionsAnsw[qId-1] = false;
            }
        }

        if (qId >= qCount){
            page = showEnd(ui);
        } else {

            ui.addAttribute("answersMap", answersMap);
            ui.addAttribute("questions", questions);
            ui.addAttribute("qId", qId);
            ui.addAttribute("qCount", qCount);
            ui.addAttribute("rightAnswers", rightAnswers);
            qId++;
        }

        return page;
    }

    String showEnd(Model ui){
        ui.addAttribute("rightAnsw", rightAnswers);
        ui.addAttribute("questions", questions);
        ui.addAttribute("qCount", qCount);
        ui.addAttribute("avg", qCount/2);
        ui.addAttribute("questionsAnsw", questionsAnsw);
        testType = null;
        return "endTesting";
    }



    @RequestMapping("/")
    String getStart(){
        return "startTest";
    }
}
