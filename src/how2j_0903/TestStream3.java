package how2j_0903;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
PrintWriter 缓存字符输出流,可以一次写出一行数据
 */
public class TestStream3 {
    public static void main(String[] args) {
        //向目标文件写入3行语句
        File f = new File("/Users/apple/Documents/LOLFolder3/lol2.txt");
        try (
                //创建文件字符流
                FileWriter fw = new FileWriter(f);
                //缓存流必须建立在一个存在的流基础上
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println("garen kill teemo");
            pw.println("garen kill teemo2");
            pw.println("garen kill teemo3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
