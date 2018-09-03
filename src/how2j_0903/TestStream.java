package how2j_0903;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/*
用FileReader字符流正确读取中文
FileReader得到的是字符,所以一定是已经把字节根据某种编码识别成了字符了
FileReader使用的编码方式Charset.defaultCharset()的返回值,
如果是中文操作系统,就是GBK
FileReader是不能手动设置编码方式的,为了使用其他的编码方式,只能使用InputStreamReader来代替
像这样:
new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"));
在本例中,用记事本另存为UTF-8格式,然耨用UTF-8就能识别对应的中文了
解释:为什么汉字前面有一个"?"
如果是用记事本另存为UTF-8的格式,那么在第一个字节有一个标示符,叫做BOM用来标志这个文件是用UTF-8来编码的
 */
public class TestStream {
    /*public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        File f=new File("/Users/apple/Documents/LOLFolder1/test.txt");
        System.out.println("默认编码方式:"+ Charset.defaultCharset());
        //FileReader得到的是字符,所以一定是已经把字符根据某种改变吗识别成了字符了
        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值,如果是中文系统,就是GBK
        try(FileReader fr=new FileReader(f)){
            char[] cs=new char[(int)f.length()];
            fr.read(cs);
            System.out.printf("FileReader会使用默认的编码方式s%,识别出的字符是:%n",Charset.defaultCharset());
            System.out.println(new String(cs));
        }catch (IOException e){
            e.printStackTrace();
        }
        //FileReader是不能手动设置编码方式的,为了使用其他的编码方式,只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new InputStream(f),Charset.forName("UTF-8"));这样的形式
        try(InputStreamReader isr=new InputStreamReader(new FileInputStream(f),Charset.forName("GBK"))){
            char[] cs=new char[(int)f.length()];
            isr.read(cs);
            System.out.printf("InputStreamReader 指定编码方式是UTF-8,识别出来的字符是:%n");
            System.out.println(new String(cs));

        }catch (IOException e){
            e.printStackTrace();
        }

    }*/
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        File f = new File("/Users/apple/Documents/LOLFolder1/test.txt");
        System.out.println("默认编码方式:" + Charset.defaultCharset());
        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
        try (FileReader fr = new FileReader(f)) {
            char[] cs = new char[(int) f.length()];
            fr.read(cs);
            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n", Charset.defaultCharset());
            System.out.println(Arrays.toString(cs));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"))) {
            char[] cs = new char[(int) f.length()];
            isr.read(cs);
            System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
            System.out.println(Arrays.toString(cs));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
/*

 */