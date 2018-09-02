package how2j_0831;
/*
为什么StringBuffer可以变长
和String内部是一个字符数组一样,但是String表现就像一个常量一样,里面的内容永远不能被改变
而StringBuffer,也维护了一个字符数组,但是,这个字符数组,留有冗余长度
比如new StringBuffer("the"),其内部的字符数组的长度是19,而不是3,
这样调用插入和追加,在现成的数组的基础上就可以完成了

如果调用的长度超过了19,就会分配一个新的数组,长度比原来多一些,把原来的数组复制到新的数组中.
看上去就是数组长度变长了,参考MyStringBuffer

length:"the"的长度是3
capacity:分配的空间 19

注:19这个数量,不同的JDK数量是不一样的
 */
public class TeseString1 {
    String name;
    public static void main(String[] args) {
        TeseString1 h=new TeseString1();
        h.name="盖伦";
        System.out.println(h.toString());
        System.out.println(h);
        String str1="the";
        StringBuffer sb=new StringBuffer(str1);
        System.out.println(sb.length());//内容长度
        System.out.println(sb.capacity());//总空间
    }


}
