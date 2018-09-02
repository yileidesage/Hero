package how2j_0902;

//OutputStream是字节输出流,同时也是抽象类,只提供方法声明,不提供方法的具体实现
//FileOutputStream是OutputSream的子类,以FileOutputStream为例向文件写出数据

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//注:如果文件不存在,写出操作会自动创建该文件
//但是如果是文件的父文件夹不存在,则会抛出异常
public class TeseStream3 {
    public static void main(String[] args) {
       try {
           //准备文件lol2.txt,其中内容是空的
           File f = new File("/Users/apple/Documents/LOLFolder1/LOL2.txt");

           //准备长度是2的字节数组,用88,89初始化,其对应的字符分别是X,Y
           byte[] data = {88, 89};

           //创建基于文件的输出流
           FileOutputStream fos = new FileOutputStream(f);

           //把数据写入到输出流
           fos.write(data);

           //关闭输出流
           fos.close();
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}
