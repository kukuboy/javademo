package api;

import com.alibaba.fastjson.JSONObject;
import data.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hello")//注解，免于在xml注册，/hello表示在主页后加/hello访问此页面
public class putUser extends HttpServlet {
    private String message;

    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {//相应不带参数的get

        String dbURL = "jdbc:mysql://localhost:3306/mydemo";
        String userName = "root";
        String userPwd = "root";
        String sql = "select * from user";
        List<user> user = new ArrayList<>();
        Connection dbConn = null;
        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverName);//反射JDBC包，这个一定要加，不然会报错
            // 设置响应内容类型
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            Statement statement = dbConn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user st = new user();
                st.setName(resultSet.getString("Sname"));
                st.setPhone(resultSet.getString("12313"));
                user.add(st);
            }
            response.getWriter().println(JSONObject.toJSONString(user));//注意这里不是控制台输出了，是HttpServletResponse，用于返回json给http请求方
            //out.println(JSONObject.toJSONString(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {//关闭连接
                if (dbConn != null) {
                    dbConn.close();
                    dbConn = null;
                }
            } catch (Exception ex) {
            }
        }

    }
}