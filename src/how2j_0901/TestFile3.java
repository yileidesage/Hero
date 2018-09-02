package how2j_0901;

import java.io.File;

/*
一般来说操作系统都会安装在C盘,所以会有一个c:\windows目录
遍历这个目录下所有的文件(不用遍历子目录)
找出这些文件里,最大和最小(非0)的那个文件,打印出他们的文件名
注:最小的文件不能是0长度
因为用的是MAC,用其他文件替代
 */
public class TestFile3 {
    public static void main(String[] args) {
        File f=new File("/Users/apple/Documents/apache-maven-3.5.4/lib");

        File[] fs=f.listFiles();
        if(null==fs)
            return;
        long minSize=Integer.MAX_VALUE;
        long maxSize=0;
        File minfile=null;
        File maxfile=null;

        for(File file:fs){
            if(file.isDirectory())
                continue;
            if(file.length()>maxSize){
                maxSize=file.length();
                maxfile=file;

            }
            if(file.length()!=0&&file.length()<minSize){
                minSize=file.length();
                minfile=file;
            }

        }
        System.out.printf("最大的文件是%s,其大小是%d字节%n",maxfile.getAbsoluteFile(),maxSize);
        System.out.printf("最小的文件是%s,其大小是%d字节%n",minfile.getAbsolutePath(),minSize);




    }

}
