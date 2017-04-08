package by.masarnovsky.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


public class User {

    private int id;

    @Size(min = 2, max = 25, message = "2-25 символов")
    private String name;

    @Size(min = 2, max = 25, message = "2-25 символов")
    private String surname;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Неверный email")
    private String email;

    @Size(min = 3, max = 20, message = "Логин должен состоять минимум из 3 символов, максимум 20")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Только буквы и цифры, без пробелов.")
    private String login;

    @Size(min = 6, max = 20, message = "Минимум 6 символов.")
    private String password;
    private String role;
    private Date regDate;

    public User(String name, String surname, String email, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User(int id, String name, String surname, String email, String login, String password, String role, Date regDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
        this.regDate = regDate;
    }

    public User(){}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
