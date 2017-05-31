package by.masarnovsky.controller;

import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Module;
import by.masarnovsky.model.Question;
import by.masarnovsky.model.QuestionType;
import by.masarnovsky.service.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    ResultService resultService;

    @RequestMapping(value = "/adminhome")
    String adminHome(){
        return "adminhome";
    }

    @RequestMapping(value = "/statistics")
    String getStatistic(Model ui){
        ui.addAttribute("usersCount", userService.getUsersCount());
        ui.addAttribute("passedCount", resultService.getPassedTestsCount());
        ui.addAttribute("failedCount", resultService.getFailedTestsCount());
        return "adminstatistics";
    }

    @RequestMapping(value = "/createQuestion")
    String createQuestion(Model ui){
        collectModulesAndTypes(ui);
        return "admincreatequestion";
    }

    @RequestMapping(value = "/editQuestion")
    String editQuestion(Model ui){
        collectModulesAndTypes(ui);
        return "admineditquestion";
    }

    @RequestMapping(value = "/getQuestionsListForModule")
    String getQuestionsListForModule(Model ui, HttpServletRequest request){
        List<Question> questions = questionService.getAllQuestionsForModule(Integer.valueOf(request.getParameter("module")));
        ui.addAttribute("questions", questions);
        return "adminlistofquestions";
    }

    @RequestMapping(value = "/editQuestionById")
    String editQuestionById(@RequestParam (value = "id", required = true) int id, HttpServletRequest request, Model ui){
//        List<Question> questions = (List<Question>) request.getSession().getAttribute("questions");
        Question question = questionService.getQuestionById(id);
        List<Answer> answers = answerService.getAnswersForQuestion(question);
        collectModulesAndTypes(ui);
        request.getSession().setAttribute("question", question);
        request.getSession().setAttribute("answers", answers);
        return "editquestionform";
    }

    @RequestMapping(value = "/insertQuestionIntoDatabase", method = RequestMethod.POST)
    String insertQuestionIntoDatabase(Model ui,
                                      @RequestParam(value = "image", required = false)MultipartFile image,
                                      HttpServletRequest request){

        String imgName = null;
        int qType = Integer.valueOf(request.getParameter("qType"));
        int module = Integer.valueOf(request.getParameter("module"));
        String question = request.getParameter("questionInput");

        if (image == null)
            ui.addAttribute("uploadImage", null);
        else{
//            imgName = request.getParameter("image-name");
            imgName = saveImage(image);
        }

        Question q = new Question(module, question, imgName, qType);
        int questionId = questionService.save(q);
        insertAnswers(request, questionId, qType);
        ui.addAttribute("adminmessage", "Вопрос добавлен в базу данных");
        ui.addAttribute("link", "createQuestion");
        ui.addAttribute("linkmessage", "Добавить еще вопрос");
        return "adminquestionmanipulation";
    }

    @RequestMapping(value = "/updateQuestionInDatabase", method = RequestMethod.POST)
    String updateQuestionInDatabase(Model ui, @RequestParam(value = "image", required = false)MultipartFile image,
                                    HttpServletRequest request) {
        String questionInput = request.getParameter("questionInput");
        Question question = (Question) request.getSession().getAttribute("question");
        question.setQuestion(questionInput);
        questionService.update(question);
        updateAnswers(request);
        ui.addAttribute("adminmessage", "&nbsp; Вопрос был обновлен &nbsp;");
        ui.addAttribute("link", "editQuestion");
        ui.addAttribute("linkmessage", "Изменить еще вопрос");
        return "adminquestionmanipulation";
    }

    private void updateAnswers(HttpServletRequest request) {
        List<Answer> answers = (List<Answer>) request.getSession().getAttribute("answers");
        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).setText(request.getParameter("answer"+(i+1)));
            answerService.update(answers.get(i));
        }
    }

    private void insertAnswers(HttpServletRequest request, int questionId, int qType) {
        boolean isRight = false;
        int end = 5;
        int i = 1;
        if (qType == 2)
            end = 3;
        while (i < end){
            if (i == 1)
                isRight = true;
            else
                isRight = false;
            answerService.save(new Answer(
                    questionId, request.getParameter("answer"+i), isRight
            ));
            i++;
        }
    }

    private String saveImage(MultipartFile image) {
        if (!image.isEmpty()){
            try {
                String root = "C:/Apache/Tomcat9/webapps/TestingApplication1.1/src/main/webapp/resources/img/";
                String name = String.valueOf(image.hashCode());
                System.out.println(name);
                File file = new File(root + name + ".jpg");
                FileUtils.writeByteArrayToFile(file, image.getBytes());
                return name;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void collectModulesAndTypes(Model ui) {
        List<Module> modulesList = moduleService.getModules();
        List<QuestionType> qtList = questionService.getTypes();
        ui.addAttribute("modulesList", modulesList);
        ui.addAttribute("qtList", qtList);
    }
}