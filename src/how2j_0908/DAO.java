package how2j_0908;

import java.util.List;

public interface DAO {
    //增加
    public void add(EntryForm student);
    //修改
    public void update(EntryForm student);
    //删除
    public void delete(int id);
    //获取
    public EntryForm get(int id);
    //查询
    public List<EntryForm> list();
    //分页查询
    public List<EntryForm> list(int start, int count);
}

