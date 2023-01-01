import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import static bdd.ManagerSQL.closeConnection;
import static bdd.ManagerSQL.getConnectionSQL;
import static bdd.ManagerSQL.getUsersList;

public class SqlTest {
    public static void main(String[] args) {
//        Connection connection = getConnectionSQL(); //Probar conexion
//        closeConnection(connection); //Close connection
        List<String[]> userList = getUsersList();

        for (String[] user : userList) {
            System.out.println(Arrays.toString(user));
        }
    }
}
