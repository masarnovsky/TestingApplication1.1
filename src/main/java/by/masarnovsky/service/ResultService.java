package by.masarnovsky.service;

import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;

import java.util.List;

public interface ResultService{
    List<Result> getAllResults();
    int getUsersCountForModule(int module);
    List<Result> getUserResult(User user);
    List<Result> getUserResult(int id);
    List<Result> getUserResultByModule(int idUser, int idModule);
    List<String> getUserStringResultByModule(int idUser, int idModule);
    void save(Result result);
    void save(int userId, int moduleId, String result);
    int getPassedTestsCount();
    int getFailedTestsCount();
    int getPassedTestsCountForUser(User user);
    int getFailedTestsCountForUser(User user);
    int getPassedTestsCountForModule(int module);
    int getFailedTestsCountForModule(int module);
}
