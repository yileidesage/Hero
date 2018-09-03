package how2j_0903;
/*
ArrayList的常用操作

add,增加
add有两种用法
第一种格式直接add对象,把对象加在最后面
heros.add(new Hero("hero"+i))
第二种是指定位置加对象
heros.add(3,specialHero)

contains,判断是否存在
通过contains,判断一个对象是否在容器中
判断标准:是否同一个对象,而不是name是否相同

get,获取指定位置的对象
通过get获取指定位置的对象,如果下标越界,一样会报错

indexOf,获取对象所处的位置
indexOf用于判断一个对象在ArrayList中所处的位置
和contains一样,判断标准是对象是否相同,而非对象的属性值是否相等

remove用于把对象从ArrayList中删除
remove可以根据下标删除ArrayList的元素:heros.remove(2)
也可以根据对象删除heros.remove(heros3)

set,替换
set用于替换指定位置的元素

size,大小

toArray,可以吧一个ArrayList对象转换为数组
需要注意的是,如果要转换为一个Hero数组,那么需要传递一个Hero数组类型的对象给toArray().
这样toArray方法才知道,你希望转换为那种类型的数组,否则只能转换为Object数组

addAll 把另一个容器所有对象加进来
 */

import java.util.ArrayList;

public class TestCollection2 {
    public static void main(String[] args) {

        ArrayList heros = new ArrayList();

        //把5个对象加入到ArrayList中
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i));
        }
        System.out.println(heros);

        //在指定位置增加对象
        Hero specialHero = new Hero("special hero");
        heros.add(3, specialHero);
        System.out.println(heros.toString());

        System.out.println(heros);
        //判断一个对象是否在容器中
        //判断的标准:是否是同一个对象,而不是name是否相同
        System.out.printf("虽然一个新的英雄,名字也叫hero1,但是contains返回的是:");
        System.out.println(heros.contains(new Hero("hero 1")));
        System.out.printf("而对specialHero的判断,contains返回的是:");
        System.out.println(heros.contains(specialHero));

        //获取指定位置的对象
        System.out.println(heros.get(5));
        //如果超出了范围,依然会报错
        System.out.println(heros.get(0));

        //indexOf
        System.out.println("specialHero所处的位置:" + heros.indexOf(specialHero));
        System.out.println("新的英雄,但是名字是\"hero1\"所处的位置:" + heros.indexOf(new Hero("hero 1")));

        //remove
        System.out.println(heros);
        heros.remove(2);
        System.out.println("删除下标是2的对象");
        System.out.println(heros);
        heros.remove(specialHero);
        System.out.println("删除special hero");
        System.out.println(heros);
        System.out.println(heros);


        //set
        Hero specalHero = new Hero("specail hero");
        heros.add(3, specalHero);
        System.out.println(heros);
        System.out.println("把下标是3的元素,替换为\"hero 5\"");
        heros.set(3, new Hero("hero 5"));
        System.out.println(heros);

        //size 大小
        System.out.printf("获取ArrayList的大小:");
        System.out.println(heros.size());

        //toArray
        heros.add(3, specalHero);
        System.out.println(heros);
        Hero[] hs = (Hero[]) heros.toArray(new Hero[]{});
        System.out.println("数组:" + hs);

        //addAll 把另一个容器所有对象加进来
        System.out.println("ArraysList heros:\t" + heros);

        ArrayList anotherHeros = new ArrayList();
        anotherHeros.add(new Hero("hero a"));
        anotherHeros.add(new Hero("hero b"));
        anotherHeros.add(new Hero("hero c"));
        System.out.println("anotherHeros heros:\t" + anotherHeros);
        heros.addAll(anotherHeros);
        System.out.println("把另一个容器的所有元素都加到当前容器中:");
        System.out.println("ArrayList heros:\t" + heros);

        System.out.println("请空前:" + anotherHeros);
        anotherHeros.clear();
        System.out.println("清空后:" + anotherHeros);


    }


}
