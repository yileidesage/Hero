package how2j_0901;

import java.io.File;

/*
Java中,文件和文件夹都是用File代表
使用绝对路径或者相对路径创建一个File对象
 */
public class TestFile {
    public static void main(String[] args) {
        //绝对路径
        File f1= new File("/Users/apple/Documents/LOLFolder");
        File f11= new File("/Users/apple/Documents/LOL2.exe");
        System.out.println("f1的绝对路径:"+f1.getAbsolutePath());
        System.out.println("f11的绝对路径:"+f11.getAbsolutePath());


        //相对路径,相对于工作目录,如果再eclipse中,就是项目目录
        File f2=new File("LOL.exe");
        File f21=new File("/XXX/lol.exe");
        System.out.println("f2的绝对路径:"+f2.getAbsolutePath());
        System.out.println("f21的绝对路径:"+f21.getAbsolutePath());

        //把f1作为父目录创建文件对象
        File f3=new File(f1,"LOL.exe");
        File f31=new File(f11,"LOL.exe");
        System.out.println("f3的绝对路径:"+f3.getAbsolutePath());
        System.out.println("f31的绝对路径:"+f31.getAbsolutePath());
    }
}
//遇到的问题
/*
1.创建的是对象,不是创建了一个文件
2.需要去PC电脑上做同样测试
 */