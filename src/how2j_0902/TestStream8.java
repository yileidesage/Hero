package how2j_0902;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
Reader字符输入流
Writer字符输出流
专门用于字符的形式读取和写入数据
FileReader是Reader的子类,以FileReader为例进行文件读取
/Users/apple/Documents/LOLFolder1
 */
public class TestStream8 {
    public static void main(String[] args) {
        //准备文件lol.txt,其中内容是AB
        File f = new File("/Users/apple/Documents/LOLFolder1/LOL.txt");
        //创建基于文件的Reader
        try (FileReader fr = new FileReader(f)) {
            //创建字符数组,长度是文件的长度
            char[] all = new char[(int) f.length()];
            //以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b : all) {
                System.out.println(b);
            }

        } catch (IOException E) {
            E.printStackTrace();
        }
    }
}
