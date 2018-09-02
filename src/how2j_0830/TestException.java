package how2j_0830;
/*
异常的定义：
导致程序的正常流程被中断的事件，叫做异常
步骤一：文件不存在异常
比如要打开d盘的LOL.exe文件，这个文件是由可能不存在的
Java中通过new FileInputStream(f)试图打开某文件
就有可能抛出：文件不存在异常： FileNotFoundException
如果不去处理异常，就会有编译错误
异常处理常见手段：try catch finally throws
步骤一：try catch
1.将可能抛出FileNotFoundException(文件不存在异常)的代码放在try里
2.如果文件存在，就会顺利往下执行，并且不执行catch块中的代码
3.如果文件不存在，try里的代码就会立即终止，程序流程会运行到对应的catch块中
4.e.printStackTrace();会打印出方法的调用痕迹，如此例，会打印出异常开始于TestException的第16行，这样就便于定位和分析到底哪里出了异常
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args) {
        File f=new File("d:/LOL.exe");
        //试图打开文件LOL.exe，会抛出FileNotFoundException,如果不处理异常，就会有编译错误
        try {
            System.out.println("试图打开d:/LOL.exe");
            new FileInputStream(f);
            System.out.println("成功打开");
        }
        /*catch (FileNotFoundException e){
            System.out.println("d:/LOL.exe不存在");
            e.printStackTrace();
        }*/
        //FileNotFoundException是Exception的子类，
        //使用Exception也可以catch住FileNotFoundException
        catch (Exception e){
            System.out.println("d:/LOL.exe不存在");
            e.printStackTrace();
        }
    }
}
