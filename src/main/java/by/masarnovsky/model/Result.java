package by.masarnovsky.model;

import java.util.Date;

public class Result {
    private int id;
    private int userId;
    private int module;
    private int result;
    private Date date;

    public Result() {
    }

    public Result(int userId, int module, int result) {
        this.userId = userId;
        this.module = module;
        this.result = result;
    }

    public Result(int id, int userId, int module, int result, Date date) {
        this.id = id;
        this.userId = userId;
        this.module = module;
        this.result = result;
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", module=").append(module);
        sb.append(", result=").append(result);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
