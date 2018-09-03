package how2j_0903;

/*
ArrayList和List
ArrayList实现了接口List
常见的写法会把引用声明为接口List类型
注意:是java.util,而不是java.awt.List
 */

import java.util.ArrayList;
import java.util.List;

public class TestCollection3 {
    public static void main(String[] args) {
        //ArrayList实现了接口List
        //常见的写法会把引用声明为接口类型
        //注意:是java.util.List,而不是java.awt.List
        //接口引用指向子类对象(多态)

        List heros = new ArrayList();
        heros.add(new Hero("盖伦"));
        System.out.println(heros.size());
    }
}
