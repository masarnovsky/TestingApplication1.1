package by.masarnovsky.controller;

import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Module;
import by.masarnovsky.model.Question;
import by.masarnovsky.model.QuestionType;
import by.masarnovsky.service.AnswerService;
import by.masarnovsky.service.ModuleService;
import by.masarnovsky.service.QuestionService;
import by.masarnovsky.service.UserService;
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

    @RequestMapping(value = "/adminhome")
    String adminHome(){
        return "adminhome";
    }

    @RequestMapping(value = "/statistic")
    String getStatistic(Model ui){
        return "adminstatistic";
    }

    @RequestMapping(value = "/createQuestion")
    String createQuestion(Model ui){
        List<Module> modulesList = moduleService.getModules();
        List<QuestionType> qtList = questionService.getTypes();
        ui.addAttribute("modulesList", modulesList);
        ui.addAttribute("qtList", qtList);
        return "admincreatequestion";
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
            imgName = request.getParameter("image-name");
            saveImage(imgName, image);
        }

        Question q = new Question(module, question, imgName, qType);
        int questionId = questionService.save(q);
        insertAnswers(request, questionId, qType);

        ui.addAttribute("adminmessage", "Вопрос добавлен в базу данных");

        return "forward:createQuestion";
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

    private void saveImage(String filename, MultipartFile image) {
        if (!image.isEmpty()){
            try {
                String root = "C:/Apache/Tomcat9/webapps/TestingApplication1.1/src/main/webapp/resources/img/";
                File file = new File(root + image.hashCode() + ".jpg");
                FileUtils.writeByteArrayToFile(file, image.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //
        }
    }
}