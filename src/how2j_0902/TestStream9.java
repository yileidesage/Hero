package how2j_0902;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter 是Write的子类,以FileWrite为例,把字符串写入到文件
 */
public class TestStream9 {
    public static void main(String[] args) {
        File f = new File("/Users/apple/Documents/LOLFolder1/LOL2.txt");
        //用try()的形式创建基于文件的Writer
        try (FileWriter fw = new FileWriter(f)) {
            //以字符流的形式把数据写入到文件中
            String data = "abcdefg1234567890";
            char[] cs = data.toCharArray();
            fw.write(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
