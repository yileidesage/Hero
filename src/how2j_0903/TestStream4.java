package how2j_0903;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
有的时候需要立即把数据写入到硬盘,而不是等缓存满了才写进去
这时候就要用到flush
 */
public class TestStream4 {
    public static void main(String[] args) {
        //向目标文件写入3行语句
        File f = new File("/Users/apple/Documents/LOLFolder3/lol4.txt");

        //创建文件字符流
        //缓存流必须创建在一个存在的流的基础上
        try (
                FileWriter fr = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fr);

        ) {
            pw.println("garen save teemo");
            //强制把缓存中的数据写入硬盘,无论缓存是否已满
            pw.flush();
            pw.println("garen save teemo2");
            pw.flush();
            pw.println("garen save teemo3");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
