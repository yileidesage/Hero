package how2j_0831;
/*
StringBuffer 是可变长的字符串
append 追加
delete 删除
insert 插入
reverse 反转
 */

public class TestString {
    public static void main(String[] args) {
        String str1="let there ";

        StringBuffer sb=new StringBuffer(str1);//根据str1创建一个StringBuffer对象
        sb.append("be light");//在最后追加
        System.out.println(sb);

        sb.delete(4,10);//删除4-10之间的字符,包含位置4,不包含位置10,基0,总计6个字符
        System.out.println(sb);

        sb.insert(4,"there ");//在4的位置插入there
        System.out.println(sb);

        sb.reverse();//反转
        System.out.println(sb);



    }
}
