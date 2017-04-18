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
    public List<Result> getUserResult(User user) {
        return null;
    }

    @Override
    public List<Result> getUserResult(int id) {
        return null;
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
    public void insertResult(Result result) {
        resultDAO.insertResult(result);
    }

    @Override
    public void insertResult(int userId, int moduleId, String result) {
        resultDAO.insertResult(userId, moduleId, result);
    }
}
