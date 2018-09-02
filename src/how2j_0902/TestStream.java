package how2j_0902;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream {
    //流(Stream),就是一系列数据
    /*
    当不同的介质之间有数据交互的时候,JAVA就使用流来实现
    数据源可以是文件,还可以是数据库,网络,其他程序

    比如读取文件到程序中,站在程序的角度来看,就叫做输入流

    输入流:InputStream
    输出流:OutputStream

    如下代码,建立了文件输入流,这个流可以用来把数据从硬盘的文件,读取到JVM(内存).
    目前代码只是建立了流,还没有开始读取,真正的读取在接下来的章节讲解
     */
    public static void main(String[] args) {
        try{
            File f=new File("/Users/apple/Documents/LOLFolder2/LOL.txt");
            //创建基于文件的输入流
            //把数据从硬盘,读取到java的虚拟机中来,也就是读取到内存中来
            FileInputStream fis=new  FileInputStream(f);

            //把java虚拟机中的数据,读取到文件中去
            FileOutputStream fos=new FileOutputStream(f);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
