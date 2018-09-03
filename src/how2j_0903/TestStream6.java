package how2j_0903;

/*
对象流指的是可以直接把一个对象以流的形式传输给其他介质,比如硬盘
一个对象以流的形式进行传输,叫做序列化,
该对象所对应的类,必须是实现Serializable接口

序列化一个对象
创建一个Hero对象,设置其名称为garen
然后把该对啊ing序列化到一个文件garen.lol
然后再通过徐泪花把该文件转化为一个Hero对象

注:把一个对象序列化的一个前提是,这个对象的类,必须实现了Serializable接口

 */

import java.io.*;

public class TestStream6 {
    public static void main(String[] args) {
        //创建一个Hero garen
        //要把Hero对象直接保存到文件上,务必让Hero类实现Serializable接口
        Hero h = new Hero("");
        h.name = "garen";
        h.hp = 616;
        //准备一个文件用于保存该对象

        File f = new File("/Users/apple/Documents/LOLFolder3/garen,lol");
        try (
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            oos.writeObject(h);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
