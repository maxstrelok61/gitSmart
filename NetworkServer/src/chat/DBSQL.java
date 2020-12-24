package chat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSQL {
    private Connection dbConnection = null;
    private  Statement stmt = null;
    private ResultSet resSet = null;

    public DBSQL() throws SQLException, ClassNotFoundException {
        connect();
    }

    private void connect () throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        dbConnection = DriverManager.getConnection("jdbc:sqlite:base.db");
        stmt = dbConnection.createStatement();
    }

    public List<User> getListUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        resSet = stmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  login = resSet.getString("login");
            String  pass = resSet.getString("password");
            String  fio = resSet.getString("fio");

            list.add(new User(login, pass, fio));

        }

        return list;
    }
}
