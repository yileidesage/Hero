package how2j_0830;
/*
当前日期的毫秒数
new Date().getTime()和System.currentTimeMills()是一样的
不过由于机器性能的原因，可能会相差几十毫秒，毕竟每执行一行代码，都是需要时间的
 */

import java.util.Date;

public class DatePractice3 {
    public static void main(String[] args) {
        Date now=new Date();
        //当前日期的毫秒数
        System.out.println("Date.getTime()\t\t\t\t返回值是："+now.getTime());
        //通过System.currentTimeMillis()获取当前日期的毫秒数
        System.out.println("System.currentTimeMillis()\t返回值是："+System.currentTimeMillis());
    }

}
