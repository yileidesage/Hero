package how2j_0906;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
CRUD是最常见的数据库操作,即增删改查
C 增加 Create
R 读取查询 Retrieve
U 更新 Update
D 删除 Delete

在JDBC中增删改的操作都很类似,只是传递不同的SQL语句就行了
查询因为要返回数据,所以和上面的不一样

设计一个方法
public static void execute(String sql)
方法接受的参数是SQL语句,无论是增加\删除\修改,都调用这个方法,
每次传不同的SQL语句作为参数
 */
public class TestJDBC5 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "123456");
                Statement s = c.createStatement();

        ) {
            //增加
            String sql = "insert into Hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql);
            //删除
            String sql2 = "delete from hero where id=4";
            s.execute(sql2);
            //修改
            String sql3 = "update hero set name='盖伦'where id=5";
            s.execute(sql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void execute1(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "123456");
                Statement s = c.createStatement();

        ) {
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
