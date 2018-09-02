package how2j_0830;


import java.util.Date;

public class DataPractice {
    public static void main(String[] args) {
        //当前时间
        Date d1=new Date();
        System.out.println("当前时间：");
        System.out.println(d1);
        System.out.println();
        //从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2=new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(d2);
    }

}
/*
Data类，java.util.Date，而非java.sql.Data,java.sql.Data是给数据库访问的
示例一
时间原点的概念
所有的数据类型，无论是整数、布尔、浮点数还是字符串，最后都需要以数字的形式表现出来
日期类型也不例外，换句话说，一个日期，比如2020年10月1日，在计算机里，会用一个数字来代替。
那么最特殊的一个数字，就是零，零这个数字代表java中的时间原点，对应的日期是1970年1月1日8点0分0秒
中国的时区是UTC-8，与格林威治时间差8小时
为什么对应1970年呢，因为1969年，发布了第一个UNIX版本：AT&T，综合考虑，就把1970年作为时间远点
所有的日期，都是这个0点为基准，每过一毫秒，就+1




 */