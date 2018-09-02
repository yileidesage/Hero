package how2j_0902;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestStream2 {
    //ASCII码,以数字替代常见字符
    //InputStream是字节输入流,同时也是抽象类,只提供方法声明,不提供方法的具体实现
    //FileInputStream是InputStream的子类,以FileInputStream为例进行文件读取

    public static void main(String[] args) {
        try{
            //准备文件lol.txt,其中内容是AB,对应的ASCII分别是 65 66
            File f1=new File("/Users/apple/Documents/LOLFolder1/LOL.txt");
            f1.getParentFile().mkdirs();
            f1.createNewFile();

            //创建基于文件的输入流
            FileInputStream fis=new FileInputStream(f1);

            //创建字节数组,其长度就是文件的长度
            byte[] all=new byte[(int)f1.length()];
            //以字节流的形式读取文件所有的内容
            fis.read(all);
            for(byte each:all){
                System.out.println(each);
            }
            //每次使用完流,都应该关闭
            fis.close();


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
