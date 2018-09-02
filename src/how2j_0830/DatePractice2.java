package how2j_0830;

import java.util.Date;

/*
getTime()得到一个long型的整数
这个整数代表从 1970.1.1 08：00：00：000 开始，每经历一毫秒，就增加1
直接打印对象，会看到 Thu Aug 30 08:09:41 CST 2018 这样的格式，可读性较差
日期格式可以转化
 */
public class DatePractice2 {
    public static void main(String[] args) {
        //注意导入的包是：java.util.Date;
        //而非 java.sql.Date，此类是给数据库访问的时候使用的
        Date now=new Date();
        //打印当前的时间
        System.out.println("当前时间："+now.toString());
        //getTime()得到一个long型的整数
        //这个整数代表从 1970.1.1 08：00：00：000 开始，每经历一毫秒，就增加1
        System.out.println("当前时间getTime()的返回值是："+now.getTime());

        Date zero=new Date(0);
        System.out.println("用0作为构造方法，得到的日期是："+zero);


    }


}
