package servelt;

import com.alibaba.fastjson.JSONObject;
import com.sun.net.httpserver.HttpServer;
import data.user;
import db.mysqlConn;

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
public class doUser extends HttpServlet {
    public void init() throws ServletException {

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {//相应不带参数的get

        String sql = "select * from user";
        Connection conn = mysqlConn.getConnection();
        List<user> user = new ArrayList<>();
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);//反射JDBC包，这个一定要加，不然会报错
            // 设置响应内容类型
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user st = new user();
                st.setName(resultSet.getString("name"));
                st.setPhone(resultSet.getString("passWord"));
                user.add(st);
            }
            response.getWriter().println(JSONObject.toJSONString(user));//注意这里不是控制台输出了，是HttpServletResponse，用于返回json给http请求方
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {//关闭连接
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception ex) {
            }
        }

    }
}
