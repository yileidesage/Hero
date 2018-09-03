package how2j_0903;
/*
DataInputStream 数据输入流
DataOutputStream 数据输出流

直接进行字符串的读写
使用数据流的writeUTF()和 readUTF()可以进行数据的格式化顺序读写
如本例,通过DataOutputStream向文件顺序写出 布尔值,整数和字符串
然后再通过DataInputStream顺序读入这些数据

注:要用DataInputStream读取一个文件,这个文件必须是由DataOutputStream写出的
否则会出现EOFException,因为DataOutputStream在写出的时候会做一些特殊标记
只有DataInputStream才能成功的读取
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream5 {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        File f = new File("/Users/apple/Documents/LOLFolder3/lol5.txt");
        try (
                FileInputStream fis = new FileInputStream(f);
                DataInputStream dis = new DataInputStream(fis);
        ) {
            boolean b = dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到的布尔值:" + b);
            System.out.println("读取到的整数:" + i);
            System.out.println("读取到的字符串:" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        File f = new File("/Users/apple/Documents/LOLFolder3/lol6.txt");
        try (
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 fdksjf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
