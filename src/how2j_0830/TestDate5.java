package how2j_0830;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
字符串转日期，关键字：parse
模式（yyyy/MM/dd HH:mm:ss）需要和字符串格式保持一致，如果不一样就会抛出解析异常Parse Exception
 */
public class TestDate5 {
    public static void main(String[] args) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str="2018/9/12 13:12:10";
        try {
            Date d=sdf.parse(str);
            System.out.printf("字符串%s 通过格式 yyyy/MM/dd HH:mm:ss %n转换为日期对象：%s",str,d.toString());
        }catch (ParseException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
