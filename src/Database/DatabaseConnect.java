package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Amantii
 */
public class DatabaseConnect {

    Connection connect = null;
    Statement statement = null;

    static String host = "";
    static String username = "root";
    static String password = "root";

    public DatabaseConnect() {

    }

    private void connect() {
        try {
            this.connect = (Connection) DriverManager.getConnection(DatabaseConnect.host, DatabaseConnect.username, DatabaseConnect.password);
            this.statement = (Statement) connect.createStatement();
        } catch (SQLException ex) {
            System.out.println("Cannot connect to Database ");
        }
    }
}
