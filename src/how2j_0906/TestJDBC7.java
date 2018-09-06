package how2j_0906;

import java.sql.*;

/*
SQL语句判断账号密码是否正确

1.创建一个用户表,有字段name,password
2.插入一条数据
3.SQL语句判断账号密码是否正确
判断账号密码的正确方式是根据账号和密码到表中去找数据,
如果有数据,就表明密码正确了,如果没数据,就表明密码错误
不恰当的方式,是把uers表的数据全部查到内存中,挨个进行比较,
如果users表里的数据有100万条呢?内存不够用的
 */
public class TestJDBC7 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "123456"
                );
                Statement s = c.createStatement();
        ) {
            String name = "dashen";
            //正确的密码是:thisispassword
            String password = "thisispassword1";
            String sql = "select * from user where name='" + name + "'and password='" + password + "'";

            //执行查询语句,并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                System.out.println("账号密码正确");

            } else
                System.out.println("账号密码错误");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
