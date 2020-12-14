package chat.auth;


import chat.DBSQL;
import chat.User;

import java.sql.SQLException;
import java.util.List;


public class BaseAuthService implements AuthService {
    DBSQL db = new DBSQL();

    private static  List<User> clients;

//    private static  List<User> clients = List.of(
//            new User("user1", "1111", "Борис_Николаевич"),
//            new User("user2", "2222", "Гендальф_Серый"),
//            new User("user3", "3333", "Мартин_Некотов")
//    );

    public BaseAuthService() throws SQLException, ClassNotFoundException {
        clients = db.getListUsers();
    }


    public String getUsernameByLoginAndPassword(String login, String password) {
        for (User client : clients) {
            if(client.getLogin().equals(login) & client.getPassword().equals(password) ) {
                return client.getUsername();
            }
        }
        return null;
    }
}
