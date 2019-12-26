package get;
import data.user;
import db.mysqlConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getUser {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from user";
        Connection conn = mysqlConn.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            user st = new user();
            st.setName(resultSet.getString("Sname"));
            st.setPhone(resultSet.getString("12313"));
        }
    }
}
