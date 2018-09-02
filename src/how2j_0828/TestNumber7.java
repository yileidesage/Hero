package how2j_0828;
import java.util.Arrays;
//这题开始没做对，需重做过
/*
字符串数组排序
创建一个长度是8的字符串数组
使用8个长度是5的随机字符串初始化这个数组
对这个数组进行排序，按照每个字符串的首字母排序（无视大小写）

注1：不能使用Array.sort(),要自己写
注2：无视大小写，即AXXXX和axxxx没有先后先后顺序之分
*/

public class TestNumber7 {
    public static void main(String[] args) {
        String[] ss=new String[8];
        for (int i = 0; i <ss.length ; i++) {
            String randomString=randomString(5);
            ss[i]=randomString;
        }
        System.out.println("排序前的字符串数组");
        System.out.println(Arrays.toString(ss));
        for (int j = 0; j <ss.length ; j++) {
            for (int i = 0; i <ss.length-j-1 ; i++) {
                char firstchar1=ss[i].charAt(0);
                char firstchar2=ss[i+1].charAt(0);
                firstchar1=Character.toLowerCase(firstchar1);
                firstchar2=Character.toLowerCase(firstchar2);

                if(firstchar1>firstchar2){
                    String temp=ss[i];
                    ss[i]=ss[i+1];
                    ss[i+1]=temp;
                }

            }

        }
        System.out.println("排序后的字符数组：");
        System.out.println(Arrays.toString(ss));
    }


    public static String randomString(int length){
        String str2="";
        for (short i = '0'; i <='9' ; i++) {
            str2=str2+(char)i;

        }
        for (short i = 'a'; i <='z' ; i++) {
            str2=str2+(char)i;

        }
        for (int i = 'A'; i <='Z' ; i++) {
            str2=str2+(char)i;

        }
        char[]c=new char[length];

        for (int j = 0; j <c.length; j++) {
                int index=(int)(Math.random()*str2.length());
                c[j]=str2.charAt(index);
        }
            String str3=new String(c);
            return str3;


        }


    }

