package how2j_0906;

import java.sql.*;

/*
查询语句
executeQuery执行SQL查询语句
注意:在查询第二列数据的时候,用的是rs.get(2),而不是get(1),
这个是整个Java自带的api里唯二的地方,使用基1的,即2代表第二个
另一处是在PrepareStatement
 */
public class TestJDBC6 {
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

            String sql = "select * from Hero";
            //执行查询语句,并把结果返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");//可以使用字段名
                String name = rs.getString(2);//也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);

            }
            //不一定要在这里关闭ResultSet,因为Statement关闭的时候.会自动关闭Result
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
