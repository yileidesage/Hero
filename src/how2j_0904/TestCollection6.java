package how2j_0904;
/*
ArrayList与LinkedList相比,定位速度要快的多
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TestCollection6 {
    public static void main(String[] args) {
        List<Integer> l;
        l = new ArrayList<>();
        modify(l, "ArrayList");

        l = new LinkedList<>();
        modify(l, "LinkedList");
    }

    private static void modify(List<Integer> l, String type) {
        int total = 100 * 1000;
        int index = total / 2;
        final int number = 5;
        //初始化
        for (int i = 0; i < total; i++) {
            l.add(number);

        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            int n = l.get(index);
            n++;
            l.set(index, n);

        }
        long end = System.currentTimeMillis();
        System.out.printf("%s总长度是%d,定位到%d个数据,取出来," +
                "加1,再放回去%n重复%d遍,总共耗时%d毫秒 %n", type, total, index, total, end - start);
    }
}
