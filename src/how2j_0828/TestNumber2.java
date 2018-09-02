package how2j_0828;
/*
把浮点数3.14转换成字符串
再把字符串转换成浮点数
如果字符串是3.1a4，转换成浮点数会得到什么,会报错
 */

public class TestNumber2 {
    public static void main(String[] args) {
        float i1=3.14f;
        //方法1
        String str1=String.valueOf(i1);
        //方法2
        Float it1=i1;
        String str2=it1.toString();
        System.out.println(str1+"\n"+str2);
        System.out.println(str2);
        float i2=Float.parseFloat(str1);
        System.out.println(i2);


    }
}
