package how2j_0830;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
准备一个额长度是9的日期数组
使用1970年-2000年之间的随机日期初始化该数组
按照这些日期的时间进行升序排序
比如 1988-1-21 12：33：32 就会排在1978-4-21 19：07：23 前面，因为它的时间更小，虽然日期更大
时间指 12：33：32 和19：07：23
解析：
将首尾日期的字符串转换成日期，日期转换成对应数字，数字相减得范围
范围中取值，得数组，输出排序前的数组
数组中的元素转化成字符串，再转换成时间格式，时间格式得数字，数字比较大小，给数组中的元素进行排序
输出排序后的数组

 */

public class TestDate6 {
    /*    public static void main(String[] args) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startDate="1970-1-1 8:00:00";
            String endDate="2000-12-31 23:59:59";
            String[] dates=new String[9];


            try {
                Date d1=sdf.parse(startDate);
                Date d2=sdf.parse(endDate);
                long random=d2.getTime()-d1.getTime();
                for (int i = 0; i <dates.length ; i++) {
                    long a=(long)(Math.random()*random);
                    Date s=new Date(a+d1.getTime());
                    String str=sdf.format(s);
                    dates[i]=str;

                }


            }
            catch (ParseException e){
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(dates));
            SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
            try {
                for (int i = 0; i <dates.length ; i++)
                    for (int j = 0; j < dates.length - i - 1; j++) {
                        Date time1 = sdf2.parse(dates[j]);
                        Date time2 = sdf2.parse(dates[j + 1]);
                        long timeNumber1 = time1.getTime();
                        long timeNumber2 = time2.getTime();
                        if (timeNumber1 < timeNumber2) {
                            String temp = dates[j];
                            dates[j] = dates[j + 1];
                            dates[j + 1] = temp;
                        }


                    }


            }
            catch (ParseException e){
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(dates));
        }
    }
    //题目没做对的原因：对于try 的作用域不清楚
    //非要使用字符串转日期的方式来比较大小，不合理
    //用字符转日期的方式，生成随机日期，将日期的转字符串方法自定义
    //将字符串直接转数字并用选择法或者冒泡法比较大小
     */
    public static void main(String[] args) {
        int startYear=1970;
        int endYear=2000;
        Date[] dates=new Date[9];
        for (int i = 0; i <dates.length ; i++) {
            dates[i]=getRandomDate(1970,2000);

        }
        System.out.println("得到的随机日期数组是：");
        for (int i = 0; i <dates.length ; i++) {
            System.out.print(toString(dates[i])+"\t");
            if(2==i%3){
                System.out.println();
            }

        }
        //选择法排序
        for (int i = 0; i <dates.length-1 ; i++) {
            for (int j = i+1; j <dates.length ; j++) {
                String datesTimeI=toString(dates[i],"HHmmss");
                String datesTimeJ=toString(dates[j],"HHmmss");

                int timeI=Integer.parseInt(datesTimeI);
                int timeJ=Integer.parseInt(datesTimeJ);

                if(timeI>timeJ){
                    Date temp=dates[i];
                    dates[i]=dates[j];
                    dates[j]=temp;
                }


            }

        }
        System.out.println("排序后的随机日期数组：");
        for (int i = 0; i <dates.length ; i++) {
            System.out.print(toString(dates[i])+"\t");
            if(2==i%3){
                System.out.println();
            }

        }

    }
    public static Date getRandomDate(int startYear,int endYear){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        try {
            Date dStart=sdf.parse(String.valueOf(startYear));
            Date dEnd=sdf.parse(String.valueOf(endYear+1));
            long timeStart=dStart.getTime();
            long timeEnd=dEnd.getTime()-1;
            long timeRandom=(long)(timeStart+Math.random()*(timeEnd-timeStart));
            return new Date(timeRandom);

        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
    //sdf.parse(1970) 输出结果是 1970.1.1 8：00：00

    public static String toString(Date d){
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf1.format(d);
    }
    public static String toString(Date d,String format){
        SimpleDateFormat sdf1=new SimpleDateFormat(format);
        return sdf1.format(d);
    }


}