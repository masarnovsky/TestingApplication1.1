package by.masarnovsky;

import java.sql.Connection;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/ecdltesting";
//            String username = "root";
//            String password = "root";
//            connection = DriverManager.getConnection(url, username, password);
//            return connection;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return connection;
    }
}
