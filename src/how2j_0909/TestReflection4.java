package how2j_0909;


import how2j_0907.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 练习-通过配置文件获取对象
 * 首先准备一个文本文件：hero.config。 在这个文件中保存类的全名称，可以是charactor.APHero 或者是charactor.ADHero
 * 接着设计一个方法叫做：
 * public static Hero getHero()
 * 在这个方法中，读取hero.config的数据，取出其中的类名，根据类名实例化出对象，然后返回对象。
 * 以下为完成步骤
 * 在0908包中建立两个APHero ADHero都继承0907的Hero类,新建的两个类各自声明不同的方法,且方法含输出内容
 * 新建一个文本文件,内容为类的全名:how2i_0908.ADHero,另存为hero.config下
 * "E:\FangCloudV2\个人文件\易雷\修行\java工具包\hero.config"TMD要反斜杠
 * 读取文件的内容为字符数组,然后再转字符串
 * 通过字符串内容创建类对象,通过类对象创建构造器,通过构造器实例化一个新的对象
 * 所以创建类对象的时候,只能通过一种方式Class.forName("sql")
 *
 */
public class TestReflection4 {
    public static void main(String[] args) throws InterruptedException{
        Hero h=getHero();
        System.out.println(h);


    }
    public static Hero getHero(){
        File f=new File("E:/FangCloudV2/个人文件/易雷/修行/java工具包/hero.config");
        try(FileReader fr=new FileReader(f)){
            String className=null;
            char[] a=new char[(int)f.length()];
            fr.read(a);
            className= new String(a);
            System.out.println(className);
            Class fclass=Class.forName(className);
            Constructor c=fclass.getConstructor();
            Hero h=(Hero)c.newInstance();
            return h;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
