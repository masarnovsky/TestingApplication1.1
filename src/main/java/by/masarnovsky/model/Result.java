package by.masarnovsky.model;

import java.sql.Time;
import java.util.Date;

public class Result {
    private int id;
    private int userId;
    private int module;
    private String result;
    private Date date;
    private Time time;

    public Result() {
    }

    public Result(int userId, int module, String result) {
        this.userId = userId;
        this.module = module;
        this.result = result;
    }

    public Result(int id, int userId, int module, String result, Date date, Time time) {
        this.id = id;
        this.userId = userId;
        this.module = module;
        this.result = result;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", module=").append(module);
        sb.append(", result=").append(result);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
