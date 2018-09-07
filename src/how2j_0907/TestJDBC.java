package how2j_0907;
/*
预编译Statement
使用PreparedStatement
和Statement一样,PrepareStatement也是用来执行SQL语句的
和创建Statement不同的是,需要根据SQL语句创建PreparedStatement
除此之外,还能够通过设置参数,指定相应的值,而不是Statement那样使用字符串拼接

注:这是Java唯二的基1的地方,另一个是查询语句中的ResultSet

Statement 需要进行字符串拼接,可读性和维护性差
String sql="insert into hero values(null,"+"'提莫'"+","+313.0f","+50+")";
PrepareStatement使用参数设置,可读性好,不容易犯错
String sql="insert into hero values(null,?,?,?)";

PrepareStatement有预编译机制,性能比Statement更快
Statement执行10次,需要10次把10次把SQL语句传输到数据库端
数据库要对每一次SQL语句进行编译处理
PrepareStatement执行10次,只需要1次把SQL语句传输到数据库端
数据库对带?的SQL语句进行预编译
因为每次执行,只需要传输参数到数据库端
1.网络传输量比Statement更小
2.数据库不需要再进行编译,响应更快


 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";

        try (
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "123456"
                );
                //根据sql语句创建PrepareStatement
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            //设置参数
            ps.setString(1, "提莫");
            ps.setFloat(2, 313.0f);
            ps.setInt(3, 50);
            //执行
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
