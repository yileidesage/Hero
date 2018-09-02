package how2j_0831;


public interface IStringBuffer {
    public void append(String str)throws IndexIsNagetiveException,IndexIsOutOfRangeException;//追加字符串
    public void append(char c)throws IndexIsNagetiveException,IndexIsOutOfRangeException;//追加字符
    public void insert(int pos,char b)throws IndexIsNagetiveException,IndexIsOutOfRangeException;//指定位置插入字符
    public void insert(int pos,String b)throws IndexIsNagetiveException,IndexIsOutOfRangeException;//指定位置插入字符串
    public void delete(int start)throws IndexIsNagetiveException,IndexIsOutOfRangeException;//从指定位置开始,删除剩下的
    public void delete(int start,int end)throws IndexIsNagetiveException,IndexIsOutOfRangeException;//从开始位置删除结束结束位置-1;
    public void reverse();//反转
    public int length();//返回长度
}
