package by.masarnovsky.dao;

import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;

import java.util.List;

public interface ResultDAO {
    List<Result> getAllResults();
    List<Result> getUserResult(User user);
    List<Result> getUserResult(int id);
    List<Result> getUserResultByModule(int idUser, int id);
}
