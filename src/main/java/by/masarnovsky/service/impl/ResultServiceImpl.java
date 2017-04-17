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
    public List<Result> getUserResultByModule(int idUser, int id) {
        return null;
    }
}
