package how2j_0902;
/*
字符在文件中的保存
字符保存在文件肯定也是以数字形式保存的,即对应不同的棋盘上的不同的数字
用记事本打开任意文本文件,并且另存为,就能够在编码这里看到一个下拉菜单
ANSI:不是ASCII,是采用本地编码的意思,如果用的中文操作系统,就会使用GBK,如果是英文,就会用ISO-885901
Unicode是UNICODE原生的编码方式
Unicode big endian 另一个UNICODE编码方式
UTF-8 最常见的编码方式,数字和字母用一个字节,汉字用3个字节

用FileInputStream字节流正确读取中文
为了能够正确的读取中文内容
1.必须了解文本是那种编码方式保存字符的
2.使用字节流读取了文本后,再使用编码方式去识别这些数字,得到正确的字符

如下例,一个文件中的内容是字符中,编码方式是GBK,那么读出来的数据一定是D6D0
再使用GBK编码吗方式识别D6D0,就能得到字符中

注:在GBK的棋盘上找到中字后,JVM会自动找到中在UNICODE这个棋盘上对应的数字,并且以UNICODE上的数字保存在内存中

 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestStream13 {
    public static void main(String[] args) {
        File f = new File("/Users/apple/Documents/LOLFolder1/test.txt");//mac中的中文是UTF-8
        try (FileInputStream Fis = new FileInputStream(f);) {
            byte[] all = new byte[(int) f.length()];
            Fis.read(all);
            //文件中读取出来的数据是
            System.out.println("文件中读取出来的数据是:");
            for (byte b : all) {
                int i = b & 0x000000ff;//只取16进制的后两位
                System.out.println(Integer.toHexString(i));

            }
            System.out.println("把这个数字,放在UTF-8的棋盘上去");
            String str = new String(all, "UTF-8");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
遇到的问题:
int i=b&0x000000ff;//只取16进制的后两位
这句话什么意思
Integer.toHeString(i):是不是就是指整数转16进制?
 */