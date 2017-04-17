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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    private final int TRAINING_SIZE = 3;
    private final int TESTING_SIZE = 6;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    String startTesting(@RequestParam(value = "module", required = true) int moduleId,
                     @RequestParam(value = "type", required = true) String type,
                     HttpServletRequest request, Model ui){
        if (request.getSession().getAttribute("testType") != null){
            ui.addAttribute("msg", "another test started!");
            return "endTesting";
        }

        int qId = 0;
        int qCount = 1;
        int rightAnswers = 0;
        String testType = null;
        if ("training".equals(type)){
            testType = "training";
            qCount = TRAINING_SIZE;
        } else if ("testing".equals(type)){
            testType = "testing";
            qCount = TESTING_SIZE;
        }

        List<Question> questions = questionService.getQuestionsForModule(moduleId, qCount);
        boolean[] questionsAnsw = new boolean[qCount];
        Map<Integer, List<Answer>> answersMap = new HashMap<>();
        for (Question q: questions){
            List<Answer> a = answerService.getAnswersForQuestion(q);
            Collections.shuffle(a);
            answersMap.put(q.getId(), a);
        }

        request.getSession().setAttribute("answersMap", answersMap);
        request.getSession().setAttribute("questions", questions);
        request.getSession().setAttribute("qId", qId);
        request.getSession().setAttribute("qCount", qCount);
        request.getSession().setAttribute("rightAnswers", rightAnswers);
        request.getSession().setAttribute("questionsAnsw", questionsAnsw);
        request.getSession().setAttribute("testType", testType);
        request.getSession().setAttribute("module", moduleId);

        return "test";

    }

    @RequestMapping(value = "/start/{type}", method = RequestMethod.GET)
    String startTest(@PathVariable(value = "type") String type, HttpServletRequest request, Model ui){
        if (request.getSession().getAttribute("testType") != null){
            ui.addAttribute("msg", "another test started!");
            return "endTesting";
        }

        int qId = 0;
        int qCount = 1;
        int rightAnswers = 0;
        String testType = null;
        if ("training".equals(type)){
            testType = "training";
            qCount = TRAINING_SIZE;
        } else if ("testing".equals(type)){
            testType = "testing";
            qCount = TESTING_SIZE;
        }

        List<Question> questions = questionService.getQuestionSet(qCount);
        boolean[] questionsAnsw = new boolean[qCount];
        Map<Integer, List<Answer>> answersMap = new HashMap<>();
        for (Question q: questions){
            List<Answer> a = answerService.getAnswersForQuestion(q);
            Collections.shuffle(a);
            answersMap.put(q.getId(), a);
        }

        request.getSession().setAttribute("answersMap", answersMap);
        request.getSession().setAttribute("questions", questions);
        request.getSession().setAttribute("qId", qId);
        request.getSession().setAttribute("qCount", qCount);
        request.getSession().setAttribute("rightAnswers", rightAnswers);
        request.getSession().setAttribute("questionsAnsw", questionsAnsw);
        request.getSession().setAttribute("testType", testType);

        return "test";
    }

    @RequestMapping(value = "/getNextQuestion/{id}", method = RequestMethod.POST)
    String nextQuestion(@PathVariable(value = "id") int id, HttpServletRequest request, Model ui){
        String page = "test";

        int qId = (Integer) request.getSession().getAttribute("qId");
        qId++;
        int qCount = (Integer) request.getSession().getAttribute("qCount");
        int rightAnswers = (Integer) request.getSession().getAttribute("rightAnswers");
        List<Question> questions = (List<Question>) request.getSession().getAttribute("questions");
        Map<Integer, List<Answer>> answersMap = (Map<Integer, List<Answer>>) request.getSession().getAttribute("answersMap");
        boolean[] questionsAnsw = (boolean[]) request.getSession().getAttribute("questionsAnsw");

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

        request.getSession().setAttribute("questionsAnsw", questionsAnsw);
        request.getSession().setAttribute("answersMap", answersMap);
        request.getSession().setAttribute("questions", questions);
        request.getSession().setAttribute("qId", qId);
        request.getSession().setAttribute("qCount", qCount);
        request.getSession().setAttribute("rightAnswers", rightAnswers);
        if (qId >= qCount){
            page = showEnd(request);
        }

        return page;
    }

    String showEnd(HttpServletRequest request){
        int qCount = (Integer) request.getSession().getAttribute("qCount");
        request.getSession().setAttribute("avg", (Integer)request.getSession().getAttribute("qCount")/2);
        request.getSession().setAttribute("qCount", qCount);
        request.getSession().setAttribute("testType", null);

        return "endTesting";
    }

}
