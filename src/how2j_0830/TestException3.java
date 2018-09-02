package how2j_0830;

/*
另一种办法是把多个异常，放在一个catch里进行统一进行捕捉，
不足之处是，一旦发生异常，不确定是哪种异常，需要通过instanceof进行判断具体的异常类型
finally:无论何种异常，finally中的代码都会被执行
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestException3 {
    public static void main(String[] args) {
        File f = new File("d:/LOL.exe");

        try {
            System.out.println("试图打开d:/LOL.exe");
            new FileInputStream(f);//试图打开文件f，文件f的路径及内容上文有定义
            System.out.println("成功打开");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date d=sdf.parse("2016-06-03");
        }
        catch (FileNotFoundException |ParseException e){
            if(e instanceof FileNotFoundException){
            System.out.println("d:/LOL.exe不存在");}
            if(e instanceof ParseException){
                System.out.println("日期格式解析错误");
            }
            e.printStackTrace();
        }
        finally {
            System.out.println("finally中的语句一定会被执行");
        }

        }
}
