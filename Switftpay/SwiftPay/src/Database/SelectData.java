package Database;

import java.sql.*;

public class SelectData extends DataBase {
    public void selectUserData(String phone) {
        Connection con = null;
        try {
            con = connectDatabase();
            String query = "SELECT * FROM users WHERE phone = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, phone);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
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