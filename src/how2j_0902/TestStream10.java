package how2j_0902;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
练习:文件加密
准备一个文本文件(非二进制),其中包含ASCII码和中文字符
设计一个方法
public static void encodeFile(File encodingFile,File encodedFile);
在这个方法中,把encodingFile的内容进行加密,然后保存到encodeFile文件中
加密算法:
数字,如果不是9的数字,在原来的基础上加1,9变成0
字母字符
如果是非z字符,向右移动1个,比如d变成e
如果是z: z->a,Z->A;
字符需要保留大小写

非字母字符保留不变,中文字符保留不变
建议使用以前学习的练习题中的某个Java文件,比如循环练习,就有很多字符和数字

流程解析
1.创建一个循环练习时的java文件,记录地址,名字
2.准备文件
3.在try()中创建基于文件的Reader
4.创建字符数组,长度就是文件的长度
5.以字符流的形式读取文件的所有内容
6.遍历的形式取出每一个数组中的内容
7.如果字符的对应short属于1-8,a-z,A-Z,则转换该数字为数字加1:(char)((short)cs[i]+1)=cs[i]
8.如果字符等于9\z\Z,则cs[i]=0/z/Z;
9.如果字符不属于3者范围,则保持不变
10.准备一个新的同样长度的数组,一边判断一边赋值
11.将字符串数组写入到文件中
如何解密

 */
public class TestStream10 {
    /**
     * @param encodingFile 被加密的文件
     * @param encodedFile  加密后保存的位置
     */
    public static void encodeFile(File encodingFile, File encodedFile) {

        try (FileReader fr = new FileReader(encodingFile);
             FileWriter fw = new FileWriter(encodedFile)) {
            // 读取源文件
            char[] fileContent = new char[(int) encodingFile.length()];
            fr.read(fileContent);
            System.out.println("加密前的内容：");
            System.out.println(new String(fileContent));

            // 进行加密
            encode(fileContent);
            // 把加密后的内容保存到目标文件
            System.out.println("加密后的内容：");
            System.out.println(new String(fileContent));

            fw.write(fileContent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void encode(char[] fileContent) {
        for (int i = 0; i < fileContent.length; i++) {
            char c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '9':
                        c = '0';
                        break;
                    case 'z':
                        c = 'a';
                        break;
                    case 'Z':
                        c = 'A';
                        break;
                    default:
                        c++;
                        break;
                }
            }
            fileContent[i] = c;
        }
    }

    public static boolean isLetterOrDigit(char c) {
        // 不使用Character类的isLetterOrDigit方法是因为，中文也会被判断为字母
        // indexOf('');如果字符属于字符串,则返回字符串的下标位置,如果不属于,则返回"-1"
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 == letterOrDigital.indexOf(c) ? false : true;
    }

    public static void main(String[] args) {
        File encodingFile = new File("E:/project/j2se/src/Test1.txt");
        File encodedFile = new File("E:/project/j2se/src/Test2.txt");
        encodeFile(encodingFile, encodedFile);
    }
}
