package how2j_0830;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
有时候一段代码会抛出多种异常。解决办法之一是分别进行catch
另一种办法是把多个异常，放在一个catch里进行统一进行捕捉，
不足之处是，一旦发生异常，不确定是哪种异常，需要通过instanceof进行判断具体的异常类型
 */
public class TestException2 {
    public static void main(String[] args) {
        File f = new File("d:/LOL.exe");

        try {
            System.out.println("试图打开d:/LOL.exe");
            new FileInputStream(f);//试图打开文件f，文件f的路径及内容上文有定义
            System.out.println("成功打开");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date d=sdf.parse("2016-06-03");
        }
        catch (FileNotFoundException e){
            System.out.println("d:/LOL.exe不存在");
            e.printStackTrace();
        }catch (ParseException e){
            System.out.println("日期格式解析错误");
            e.printStackTrace();
        }
    }

}
