package how2j_0906;
/*
如果觉得关闭连接的方式很麻烦,可以参考关闭流的方式
使用try-with-resource的方式自动关闭连接,
因为Connection和Statement都实现了AutoCloseAble接口
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC4 {
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
            for (int i = 0; i < 100; i++) {
                String sql = "insert into Hero values(" +
                        "null," + "'英雄" + i + "'" + "," + 313.0f + "," + 50 + ")";
                s.execute(sql);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
