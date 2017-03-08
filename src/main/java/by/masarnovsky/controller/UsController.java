package by.masarnovsky.controller;

import by.masarnovsky.DatabaseConnection;
import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;
import by.masarnovsky.service.AnswerService;
import by.masarnovsky.service.QuestionService;
import by.masarnovsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


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

    private List<Question> questions;
    private List<Answer> answers;
    private Map<Integer, List<Answer>> answersMap;
    private int qId = 0;
    private int rughtAnsw = 0;




    @RequestMapping("/getNextQuestion")
    String getNextQuestion(Model ui){
        String page = "test";
        if (qId >= questions.size()){
            rughtAnsw = 1;
            page = showEnd(ui);
        } else {
            ui.addAttribute("answersMap", answersMap);
            ui.addAttribute("questions", questions);
            ui.addAttribute("qId", qId);
            qId++;
        }

        return page;
    }

    String showEnd(Model ui){
        ui.addAttribute("rightAnsw", rughtAnsw);
        ui.addAttribute("avg", questions.size()/2);
        return "endTesting";
    }

    //@RequestMapping("/startTest")
    @RequestMapping("/")
    String pageTest(){
        return "startTest";
    }

    @RequestMapping("/startTestNow")
    String setTests(Model ui){
        qId = 0;
        rughtAnsw = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        final String GET_ALL_QUESTIONS = "select * from questions";
        final String GET_ALL_ANSQWERS = "select * from answers";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(GET_ALL_QUESTIONS);
            questions = new ArrayList<Question>();
            while (rs.next()){
                //System.out.println("+");
                questions.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            //System.out.println(questions);

            answersMap = new HashMap<Integer, List<Answer>>();
            rs = statement.executeQuery(GET_ALL_ANSQWERS);
            while (rs.next()){
                Answer a = new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4));
                if (answersMap.get(new Integer(a.getQuestionId())) == null){
                    List<Answer> aList = new ArrayList<Answer>();
                    aList.add(a);
                    answersMap.put(a.getQuestionId(), aList);
                }
                else {
                    List<Answer> answerList = answersMap.get(new Integer(a.getQuestionId()));
                    answerList.add(a);
                }
            }
            Collections.shuffle(questions);

            ui.addAttribute("answersMap", answersMap);
            ui.addAttribute("questions", questions);
            ui.addAttribute("qId", qId);
            qId++;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (statement != null){
                    statement.close();
                }
                if(connection != null)
                {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "test";
    }

}
