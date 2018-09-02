package how2j_0828;
/*
1.对byte,short,float,double进行自动拆箱和装箱
2.byte和Interger之间能否进行自动拆箱和自动装箱
3.通过Byte获取byte的最大值

 */

public class TestNumber1 {
    public static void main(String[] args) {
        byte i1 = 127;
        short i2 = 32767;
        int i3 = 128;
        float i4 = 3.5f;
        double i5 = 4.8;
        Byte it1 = i1;
        System.out.println(it1);
        byte i6=it1;
        System.out.println(i6);
        Short it2=i2;
        short i7=it2;
        System.out.println(it2+":"+i7);
        Float it3=i4;
        float i8=it3;
        System.out.println(it3+":"+i8);
        Double it4=i5;
        double i9=it4;
        System.out.println(it4+":"+i9);
        Integer it5=(int)i1;//不能直接拆装箱，要转换以后才可以
        byte i10=(byte)it5.intValue();
        System.out.println(it5+":"+i10);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
    }
}
