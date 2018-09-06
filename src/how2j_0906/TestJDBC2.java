package how2j_0906;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
建立与数据库的Connection连接
这里需要提供：
数据库所处于的ip:127.0.0.1 (本机)
数据库的端口号： 3306 （mysql专用端口号）
数据库名称 how2java
编码方式 UTF-8
账号 root
密码 admin

com.mysql.jdbc.Driver

注： 这一步要成功执行，必须建立在mysql中有数据库how2java的基础上，
如果没有，点击创建数据库查看如何进行数据库的创建。
 */
public class TestJDBC2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //建立与数据库的Connection连接
            //这里需要提供:
            //数据库所处于的ip:127.0.0.1(本机)
            //数据库的端口号:3306(mysql专用端口号)
            //数据库名称how2java
            //编码方式 UTF-8
            //账号 root
            //密码 123456

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "123456");
            System.out.println("连接成功,获取连接对象: " + c);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
