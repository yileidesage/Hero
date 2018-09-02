package how2j_0830;

import java.text.SimpleDateFormat;
import java.util.Date;

//借助随机数，创建一个1995.1.1 00：00：00到1995.12.31 23：59：59之间的随机日期
//Date d1= Date(int)，来表达日期
//本练习略
/*
日期格式化类：SimpleDateFormat
关键字：format
 */
public class TestDate4 {
    public static void main(String[] args) {
        /*
        y 代表年
        M 代表月
        d 代表日
        H 代表24进制的小时
        h 代表12进制的小时
        m 代表分钟
        s 代表秒
        S 代表毫秒
         */
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date d=new Date();
        String str=sdf.format(d);
        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出："+str);

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日");
        Date d1=new Date();
        String str1=sdf1.format(d1);
        System.out.println("当前时间通过yyyy-MM-dd格式化后的输出："+str1);
    }



}
