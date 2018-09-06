package how2j_0906;
/*
创建Statement
Statement是用于执行SQL语句的,比如增加 删除
s.execute执行sql语句
执行成功后,用Navicat 进行查看,明确插入成功
执行SQL语句之前,要确保数据库how2java中有表hero的存在,如果没有,需要先创建表

关闭连接
数据库的连接是有限的资源,相关操作结束后,养成关闭数据库的好习惯
先关闭Statement
再关闭Connection
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC3 {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java2?characterEncoding=UTF-8",
                    "root", "123456");
            //注意使用的是java.sql.Statement
            //不要不小心使用到:com.mysql.jdbc.Statement
            s = c.createStatement();
            System.out.println("获取 Statement对象: " + s);

            //准备sql语句
            //注意:字符串要用单引号
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql);
            System.out.println("执行插入语句成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //数据库是有限的资源,相关操作结束后,养成关闭数据库的良好习惯
        //先关闭Statement,再关闭Connection
        finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
