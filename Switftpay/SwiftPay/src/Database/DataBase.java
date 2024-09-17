package Database;
import java.sql.*;

public class DataBase {
    private static final String password = "root";
    private static final String username = "";
    private static final String host = "jdbc:derby://localhost:3306/Swiftpay";

    public Connection connectDatabase() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return con;
    }

    public void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }
    public String checkDatabaseStatus(Connection con) {
        String status;
        try {
            if (con != null && !con.isClosed()) {
                status = "CONNECTED";
            } else {
                status = "DISCONNECTED";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            status = "ERROR";
        }

        return switch (status) {
            case "CONNECTED" -> "Database is connected.";
            case "DISCONNECTED" -> "Database is disconnected.";
            case "ERROR" -> "An error occurred while checking the database status.";
            default -> "Unknown status.";
        };
    }


}
