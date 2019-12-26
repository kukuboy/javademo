package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class mysqlConn {

    public static Connection getConnection(){
        Connection conn = null;//连接的实体
        try {
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            Class.forName(DRIVER);
            System.out.println("数据库驱动加载完成");
            String url = "jdbc:mysql://localhost:3306/mydemo?serverTimezone=UTC";
            String user="root";
            String passWord="root";
            conn = DriverManager.getConnection(url,user,passWord);
            System.out.println("已成功的与mysql建立了连接");
        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
