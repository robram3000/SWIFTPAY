package Database;
import java.sql.*;

public class InsertData extends DataBase {

    public void insertData(String accountName, Double amount) {
        Connection con = null;
        try {
            con = connectDatabase();
            String status = checkDatabaseStatus(con);
            if (status.equals("Database is connected.")) {
                String query = "INSERT INTO your_table_name (account_name, amount) VALUES (?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, accountName);
                pstmt.setDouble(2, amount);
                pstmt.executeUpdate();
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
