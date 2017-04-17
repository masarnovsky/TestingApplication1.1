package by.masarnovsky.service;

import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;

import java.util.List;

public interface ResultService {
    List<Result> getAllResults();
    List<Result> getUserResult(User user);
    List<Result> getUserResult(int id);
    List<Result> getUserResultByModule(int idUser, int id);
}
