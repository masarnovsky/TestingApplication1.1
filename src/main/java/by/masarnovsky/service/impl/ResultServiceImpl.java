package by.masarnovsky.service.impl;

import by.masarnovsky.dao.ResultDAO;
import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;
import by.masarnovsky.service.ResultService;

import java.util.List;

public class ResultServiceImpl implements ResultService{
    private ResultDAO resultDAO;

    public void setResultDAO(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    public List<Result> getAllResults() {
        return null;
    }

    @Override
    public int getUsersCountForModule(int module) {
        return resultDAO.getUsersCountForModule(module);
    }

    @Override
    public List<Result> getUserResult(User user) {
        return getUserResult(user.getId());
    }

    @Override
    public List<Result> getUserResult(int id) {
        return resultDAO.getUserResult(id);
    }

    @Override
    public List<Result> getUserResultByModule(int idUser, int idModule) {
        return resultDAO.getUserResultByModule(idUser, idModule);
    }

    @Override
    public List<String> getUserStringResultByModule(int idUser, int idModule) {
        return resultDAO.getUserStringResultByModule(idUser, idModule);
    }

    @Override
    public void save(Result result) {
        resultDAO.save(result);
    }

    @Override
    public void save(int userId, int moduleId, String result) {
        resultDAO.save(userId, moduleId, result);
    }

    @Override
    public int getPassedTestsCount() {
        return resultDAO.getPassedTestsCount();
    }

    @Override
    public int getFailedTestsCount() {
        return resultDAO.getFailedTestsCount();
    }

    @Override
    public int getPassedTestsCountForUser(User user) {
        return resultDAO.getPassedTestsCountForUser(user);
    }

    @Override
    public int getFailedTestsCountForUser(User user) {
        return resultDAO.getFailedTestsCountForUser(user);
    }

    @Override
    public int getPassedTestsCountForModule(int module) {
        return resultDAO.getPassedTestsCountForModule(module);
    }

    @Override
    public int getFailedTestsCountForModule(int module) {
        return resultDAO.getFailedTestsCountForModule(module);
    }
}
