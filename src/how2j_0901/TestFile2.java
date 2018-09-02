package how2j_0901;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

//文件常用方法1 /Users/apple/Documents/LOLFolder Users/apple/Documents/LOLFolder
//注意1:需要在/Users/apple/Documents 确实存在一个LOL.exe,才可以看到对应的文件长度\修改时间等信息
//注意2:renameTo方法用于对物理文件名称进行修改,但是并不会修改File对象的name属性
public class TestFile2 {
    public static void main(String[] args) throws IOException {
        File f=new File("/Users/apple/Documents/LOL.exe");
        File f1=new File("/Users/apple/Documents/LOLFolder");
        String f1Name="LOLFolder";
        System.out.println("当前文件是:"+f);
        System.out.println("当前文件是:"+f1);


        //文件是否存在
        System.out.println("判断f是否存在:"+f.exists());
        System.out.println("判断f1是否存在:"+f1.exists());

        //是否是文件夹
        System.out.println("f是否是文件夹:"+f.isDirectory());
        System.out.println("f1是否是文件夹:"+f1.isDirectory());

        //是否是文件
        System.out.println("f是否是文件:"+f.isFile());
        System.out.println("f1是否是文件:"+f1.isFile());

        //文件长度(对于文件来说是大小,对于文件夹来说,不清楚长度的意义,但确定不是文件名的长度)
        System.out.println("获取文件f的长度:"+f.length());
        System.out.println("获取文件f1的长度:"+f1.length());
        System.out.println("f1文件夹名字的长度:"+f1Name.length());

        //文件最后修改时间
        long time=f.lastModified();
        long time1=f1.lastModified();
        Date d=new Date(time);
        Date d1=new Date(time1);
        System.out.println("获取文件f的最后修改时间:"+d);
        System.out.println("获取文件f1的最后修改时间:"+d1);

        //设置文件的修改时间为 1970.1.1 08:00:00 没有修改成功,可能是系统权限的问题?
        //不是,是因为语句不完整,没有打印出真正的对象,d和d1指向的还是原来的时间
        f.setLastModified(0);
        f1.setLastModified(500);
         time=f.lastModified();
         time1=f1.lastModified();
         d=new Date(time);
         d1=new Date(time1);
        System.out.println("获取文件f的最后修改时间:"+d);
        System.out.println("获取文件f1的最后修改时间:"+d1);

        //文件重命名
        File f01=new File("/Users/apple/Documents/DOTA.exe");
        File f11=new File("/Users/apple/Documents/LOLFolder2");

        f.renameTo(f01);
        f1.renameTo(f11);

        //修改文件名成功

        System.out.println("把LOL.exe改名成了DOTA.exe");
        System.out.println("注意:需要在/Users/apple/Documents确实存在一个LOL.exe," +
                "\r\n才可以看到对应的文件的长度,修改时间等信息");

        File f3=new File("/Applications/QQBrowserLite.app/Contents/Resources/web_ui/images");
        //以字符串数组的形式,返回当前文件夹下(images文件夹)的所有文件(不包含子文件及子文件夹)
        //注意,返回的是路径文件夹中的所有文件,而不是所在文件夹的所有文件
        // (是images文件夹下的文件,而不是web_ui文件夹下的)
        //注意,返回的只有文件夹下的文件,不含文件夹中子文件的文件,以及不含子文件的子文件夹

        f3.list();
        System.out.println(Arrays.toString(f3.list()));

        //以文件数组的形式,返回当前文件夹下的所有文件(不包含文件及子文件夹)
        //该数组的元素都是文件以及文件夹的对象
        File[] fs=f3.listFiles();
        System.out.println(fs[0]);

        //以字符串形式返回获取所在文件夹
        f3.getParent();
        System.out.println(f3.getParent());

        //以文件形式返回获取所在文件夹
        f3.getParentFile();
        System.out.println(f3.getParentFile());

        //创建文件夹,如果父文件不存在,创建就无效
        //首先在这个语句执行以前,父文件Documents下没有LOLFolder3这个文件夹,执行以后,创建了该文件夹
        File f4=new File("/Users/apple/Documents/LOLFolder3");
        f4.mkdir();

        //创建文件夹,如果父文件夹不存在,就会创建父文件夹
        //注意创建的是文件夹,包括.exe结尾的文件夹,而不是文件
        //创建父文件夹及该文件夹
        File f5=new File("/Users/apple/Documents/LOLFolder6/LOL.exe/l");
        f5.mkdirs();

        //创建一个空文件,如果父文件夹不存在,就会抛出异常
        File f6=new File("/Users/apple/Documents/LOLFolder6/lol");
        f6.createNewFile();
        //所以创建一个空文件以前,通常都会创建父目录
        //注意不能省略getParentFile(),否则创建的就是该文件夹了
        File f7=new File("/Users/apple/Documents/LOLFolder7/lol.exe");
        f7.getParentFile().mkdirs();
        File f8=new File("/Users/apple/Documents/LOLFolder8/lol.exe");
        f8.mkdirs();

        //列出所有的符盘c: d: e:等等
        //这个没懂
        f8.listRoots();
        f8.delete();

        //JVM结束的时候,删除文件,常用于临时文件的删除
        f7.deleteOnExit();












    }
}
