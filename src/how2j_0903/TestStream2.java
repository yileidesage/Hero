package how2j_0903;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException
*/
/*
以介质是硬盘为例,字节流和字符流的弊端:
在每一读写的时候都会访问硬盘,如果读写的频率比较高的时候,其性能表现不佳.
为了解决以上弊端,会采用缓存流
缓存流在读取数据的时候,会一次性读取较多的数据到缓存中,以后每一次读取,都是在缓存中访问
指导缓存中的数据读取完毕,再到硬盘中读取
就好比吃饭,不用缓存就是每吃一口都到锅里去铲,用缓存就是先把饭盛到碗里,碗里的吃完了,再到锅里去铲
缓存流写入数据的时候,会先把数据写入到缓存区,直到缓存区达到一定的量,才把这些数据,一起写入到硬盘里
按照这种操作模式,就不会像字节流\字符流那样,每写一个字节都要访问硬盘
从而减少了IO操作

缓存字符输入流BufferedReader可以一次读取一行数据
 */
public class TestStream2 {
    public static void main(String[] args) {
        //准备文件lol.txt其中的内容是
        //garen kill teemo
        //teemo revive after 1 munutes
        //teemo try to garen,but killed again
        File f = new File("/Users/apple/Documents/LOLFolder3/lol3.txt");

        //创建文件字符流
        //缓存流必须建立在一个存在的流的基础上
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
        ) {
            while (true) {
                //一次读一行
                String line = br.readLine();
                if (null == line)
                    break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
