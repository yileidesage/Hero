package how2j_0908;
/**
 * 编写DAO，分别JdbcTemplate和Mybatis连接数据库，
 * 注意使用JDBCTemplate的时候分离Interface和Imple，
 * 使用Mybatis的时候注意理解为什么不需要Impl，注意遵守命名规范。
 */

import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * 建立数据库中数据对应的对象类class EntryForm
 * 编写DAO接口
 * 实现DAO接口
 * 把驱动初始化放在方法里
 * 提供了一个getConnection方法返回连接
 * <p>
 * 所有的数据库操作都需要事先拿到一个数据库连接Connection，
 * 以前的做法每个方法里都会写一个，如果要改动密码，那么每个地方都需要修改。
 * 通过这种方式，只需要修改这一个地方就可以了。 代码变得更容易维护，而且也更加简洁。
 * jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8
 * jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8
 */
public class TestDAO implements DAO {
    public TestDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getCollcetion() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "123456");
    }

    //获取数据总数量
    public int getTotal() {
        int total = 0;
        try (Connection c = getCollcetion(); Statement s = c.createStatement()) {
            //sql中查询总数有多种,其中之一为:select count(*) from
            String sql = "select count(*) from EntryForm";
            //将sql语句的执行结果,赋值给rs
            ResultSet rs = s.executeQuery(sql);
            //将赋值后的rs表达出来,因为是数据赋值,则表达的最好方式就是用字段表达
            //如果下一行的值不为空?还是rs的值不为空?百度得:下一行不为空
            while (rs.next()) {
                //返回值的第一个数字
                total = rs.getInt(1);
            }
            System.out.println("total=" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }


    @Override
    public void add(EntryForm student) {
        String sql = "insert into EntryForm values(null,?,?,?,?)";
        try (Connection c = getCollcetion(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, student.name);
            ps.setInt(2, student.qq);
            ps.setString(3, student.type);
            ps.setString(4, student.graduateFrom);

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(EntryForm student) {
        String sql = "update EntryForm set name=?,qq=?,type=?,graduateFrom=? where id =?";
        try (Connection c = getCollcetion(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, student.name);
            ps.setInt(2, student.qq);
            ps.setString(3, student.type);
            ps.setString(4, student.graduateFrom);
            ps.setInt(5, student.id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (Connection c = getCollcetion(); Statement s = c.createStatement();) {
            String sql = "delete from entryform where id=" + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public EntryForm get(int id) {
        EntryForm student = null;
        try (Connection c = getCollcetion(); Statement s = c.createStatement()) {
            String sql = "select * from entryform where id=" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                student = new EntryForm();
                String name = rs.getString("name");
                int qq = rs.getInt(3);
                String type = rs.getString(4);
                String graduateFrom = rs.getString(5);
                student.name = name;
                student.qq = qq;
                student.type = type;
                student.graduateFrom = graduateFrom;
                student.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<EntryForm> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    /**把所有的student分页查询出来，转换为student对象后，放在一个集合中返回*/
    public List<EntryForm> list(int start, int count) {
        List<EntryForm> studentList = new ArrayList<>();
        String sql = "select * from EntryForm order by id desc limit ?,?";
        try (Connection c = getCollcetion(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EntryForm student = new EntryForm();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qq = rs.getInt(3);
                String type = rs.getString(4);
                String graduateFrom = rs.getString(5);

                student.id = id;
                student.name = name;
                student.qq = qq;
                student.type = type;
                student.graduateFrom = graduateFrom;

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
        //下面这两行.应该如何解读?
        TestDAO dao = new TestDAO();
        List<EntryForm> nf = dao.list();
        System.out.println("数据库中总共有" + nf.size() + "条数据");
        EntryForm student = new EntryForm();
        System.out.println("删除所有数据");
        for (int i = 1; i <= nf.size(); i++) {
            dao.delete(i);

        }
        System.out.println("数据库中总共有" + nf.size() + "条数据");
        System.out.println("取出id=65的数据,他的name是:");
        student = dao.get(65);
        System.out.println(student.name);
        System.out.println("把他的名字改为张三,并更新到数据库");
        student.name = "张三";
        dao.update(student);
        System.out.println("取出id=65的数据,他的name是:");
        student = dao.get(65);
        System.out.println(student.name);
    }
}
