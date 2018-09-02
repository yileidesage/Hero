package how2j_0902;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
找到一个大于100k的文件,按照100k位单位,拆分成多个子文件,并以编号作为文件名结束.
再将拆分后的文件合并为一个新的文件
改名后替换掉原文件,看是否成功运行
/Users/apple/Documents/LOLFolder1/Sublime Text.icns
大小:586K
简析:
创建一个char数组,数组的长度为文件大小
将文件写入到数组中
将数组拆分为1024*100
每个数组输出到一个对应的文件
将拆分的多个文件读取到对应数组
将多个对应数组合并成一个数组
再写出到一个空文件中

数组的类型为什么只能是byte,可不可以是其他格式,为什么?
如何对项目的各参数合理命名,才能避免混淆?



 */
/*
public class TestStream5 {

    public static void main(String[] args) {
        File f1=new File("/Users/apple/Documents" +
                "/LOLFolder1/Sublime Text.icns");
        int f1length=(int)f1.length();
        byte fileSplitSrc[]=new byte[f1length];

        try{
            FileInputStream fisF1=new FileInputStream(f1);
            fisF1.read(fileSplitSrc);
            for (int i = 0; i <=(int)(f1length/(1024*100)) ; i++) {
                byte [] fileSplit1= Arrays.copyOfRange(fileSplitSrc,
                        (100*1024*i),(100*1024*(i+1)+1));
                String f1SplitName=f1.getName()+"-"+i;
                File f1Split1=new File(f1SplitName);

                FileOutputStream fosF1= new FileOutputStream(f1Split1);
                fosF1.write(fileSplit1);
                System.out.println("拆分后的文件为:"+f1Split1.getAbsolutePath()
                        +"其大小是:"+f1Split1.length()+"字节");


            }


        }catch(IOException e){
            e.printStackTrace();
        }


    }


}
*/
/*
错误原因分析:
1.如何用for循环生成字符串没有作对,int可以直接拼接到字符串后面
2.用for循环生成文件的时候,应该调用的是父文件路径及文件名的方式生成文件
File file = new File(父文件路径,文件名)
需要对File的方法再研究下
3.对于给文件分份数的问题,没有考虑到余数为0的情况
4.最后一次从文件读取数据时,数组长度应为剩余部分,而不是固定的100*1024
5.最重要的是:不善于通过使用类方法来解决问题,类方法很方便其他程序调用,是一劳永逸的办法
以下为参考答案

 */

public class TestStream5 {

    public static void main(String[] args) {
        int eachSize = 100 * 1024; // 100k
        File srcFile = new File("/Users/apple/Documents/LOLFolder1/Sublime Text.icns");
        splitFile(srcFile, eachSize);
    }

    /**
     * 拆分的思路，先把源文件的所有内容读取到内存中，然后从内存中挨个分到子文件里
     * @param srcFile 要拆分的源文件
     * @param eachSize 按照这个大小，拆分
     */
    private static void splitFile(File srcFile, int eachSize) {

        if (0 == srcFile.length())
            throw new RuntimeException("文件长度为0，不可拆分");

        byte[] fileContent = new byte[(int) srcFile.length()];
        // 先把文件读取到数组中
        try {
            FileInputStream fis = new FileInputStream(srcFile);
            fis.read(fileContent);
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 计算需要被划分成多少份子文件
        int fileNumber;
        // 文件是否能被整除得到的子文件个数是不一样的
        // (假设文件长度是25，每份的大小是5，那么就应该是5个)
        // (假设文件长度是26，每份的大小是5，那么就应该是6个)
        if (0 == fileContent.length % eachSize)
            fileNumber = (int) (fileContent.length / eachSize);
        else
            fileNumber = (int) (fileContent.length / eachSize) + 1;

        for (int i = 0; i < fileNumber; i++) {
            String eachFileName = srcFile.getName() + "-" + i;
            File eachFile = new File(srcFile.getParent(), eachFileName);
            byte[] eachContent;

            // 从源文件的内容里，复制部分数据到子文件
            // 除开最后一个文件，其他文件大小都是100k
            // 最后一个文件的大小是剩余的
            if (i != fileNumber - 1) // 不是最后一个
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
            else // 最后一个
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);

            try {
                // 写出去
                FileOutputStream fos = new FileOutputStream(eachFile);
                fos.write(eachContent);
                // 记得关闭
                fos.close();
                System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}