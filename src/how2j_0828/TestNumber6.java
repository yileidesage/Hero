package how2j_0828;
/*
字符串数组排序
创建一个长度是8的字符串数组
使用8个长度是5的随机字符串初始化这个数组
对这个数组进行排序，按照每个字符串的首字母排序（无视大小写）

注1：不能使用Array.sort(),要自己写
注2：无视大小写，即AXXXX和axxxx没有先后先后顺序之分
 */

import java.util.Arrays;

public class TestNumber6 {
    public static void main(String[] args) {
        String[] str=new String[8];
        String str2="";
        for (short i = 'a'; i <='z' ; i++) {
            str2=str2+(char)i;

        }
        for (int i = 'A'; i <='Z' ; i++) {
            str2=str2+(char)i;

        }
        System.out.println(str2);

        for (int j = 0; j <str.length ; j++) {

            char[]c=new char[5];
            for (int i = 0; i <5; i++) {
                int index=(int)(Math.random()*str2.length());
                c[i]=str2.charAt(index);

            }
            String str3=new String(c);
            str[j]=str3;


        }
        String str4= Arrays.toString(str);
        System.out.println(str4);



    }
}
//程序报错，原因不明，需调试
//问题找到：for循环里的限制条件设置错误
//问题找到：数组打印，需要用Array.toString(arrayName)
