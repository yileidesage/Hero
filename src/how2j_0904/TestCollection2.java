package how2j_0904;

import java.util.HashSet;
import java.util.Iterator;

/*
HashSet
HashSet中的元素不能重复

Set中的元素,没有顺序
严格的说,是没有按照元素的插入顺序排列
HashSet的具体顺序,既不是按照插入顺序,也不是按照hashcode的顺序,
关于hashcode的原理,有专门章节讲解
换句话说,同样是插入0-9到HashSet中,在JVM的不同版本中,看到的顺序都是不一样的.
所以在开发的时候,不能依赖于某种臆测的顺序,这个顺序本身是不稳定的

遍历
Set不提供get()来获取指定位置的元素
所以遍历需要用到迭代器或者增强型for循环
 */
public class TestCollection2 {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("a");
        System.out.println(names);

        //第二次插入同样的数据,是插不进去的,容器中只会保留一个
        names.add("a");
        System.out.println(names);

        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);

        //Set中的元素排列,不是按照插入顺序
        System.out.println(numbers);

        //遍历
        HashSet<Integer> num = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            num.add(i);

        }
        //Set不提供get()方法来获取指定位置的元素:num.get(1);
        //用迭代器iterator

        for (Iterator<Integer> iterator = num.iterator(); iterator.hasNext(); ) {
            Integer i = (Integer) iterator.next();
            System.out.print(i);
        }

        //增强for循环
        for (Integer i : num) {
            System.out.print(i);
        }


    }

}
