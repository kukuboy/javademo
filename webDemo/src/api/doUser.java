package api;

import com.alibaba.fastjson.JSONObject;
import data.user;
import DB.mySql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class doUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql = "select * from user";
        Connection conn = mySql.getConnection();
        List<user> user = new ArrayList<>();
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);//反射JDBC包，这个一定要加，不然会报错
            // 设置响应内容类型
            String name = request.getQueryString();
            System.out.println(name);
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
