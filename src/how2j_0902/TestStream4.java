package how2j_0902;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
如果文件不存在,写出操作会自动创建该文件
但是如果是文件的父文件夹不存在,则会抛出异常
那么怎么自动创建父文件夹呢
如果是多层目录呢?
/Users/apple/Documents/LOLFolder1/LOL2.txt
/Users/apple/Documents/LOLFolder3/LOLFolder4/LOL2.txt
 */
public class TestStream4 {
    public static void main(String[] args) {


        try {
            File f1 = new File("/Users/apple/Documents/LOLFolder3/LOLFolder4/LOL2.txt");
            if(!f1.getParentFile().exists()){
                f1.getParentFile().mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(f1);
            byte[] a = {88, 89};
            fos.write(a);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
