package how2j_0908;
/**
编写DAO，分别JdbcTemplate和Mybatis连接数据库，
注意使用JDBCTemplate的时候分离Interface和Imple，
使用Mybatis的时候注意理解为什么不需要Impl，注意遵守命名规范。
  */

import java.sql.*;
import java.util.Collection;
import java.util.List;


/**
 建立数据库中数据对应的对象类class EntryForm
 编写DAO接口
 实现DAO接口
 把驱动初始化放在方法里
 提供了一个getConnection方法返回连接

 所有的数据库操作都需要事先拿到一个数据库连接Connection，
 以前的做法每个方法里都会写一个，如果要改动密码，那么每个地方都需要修改。
 通过这种方式，只需要修改这一个地方就可以了。 代码变得更容易维护，而且也更加简洁。


 */
public class TestDAO implements DAO {
    public TestDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getCollcetion()throws SQLException {
        return  DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8","root","123456");
    }
    //获取数据总数量
    public int getTotal(){
        int total=0;
        try (Connection c=getCollcetion(); Statement s= c.createStatement()){
            //sql中查询总数有多种,其中之一为:select count(*) from
            String sql="select count(*) from EntryForm";
            //将sql语句的执行结果,赋值给rs
            ResultSet rs=s.executeQuery(sql);
            //将赋值后的rs表达出来,因为是数据赋值,则表达的最好方式就是用字段表达
            //如果下一行的值不为空?还是rs的值不为空?百度得:下一行不为空
            while(rs.next()){
                //返回值的第一个数字
                total=rs.getInt(1);
            }
            System.out.println("total="+total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }



    @Override
    public void add(EntryForm form) {

    }

    @Override
    public void update(EntryForm form) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public EntryForm get(int id) {
        return null;
    }

    @Override
    public List<EntryForm> list() {
        return null;
    }

    @Override
    public List<EntryForm> list(int start, int count) {
        return null;
    }

    public static void main(String[] args) {

    }
}
