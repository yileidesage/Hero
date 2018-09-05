package how2j_0903;
/*
二叉树
二叉树由各种节点组成,每个节点可以有左子节点,右子节点
每一个节点,都有一个值
二叉树排序
假设通过二叉树对如下10个随机数进行排序
67,7,30,73,10,0,78,81,10,74
排序的第一个步骤是吧数据插入到该二叉树中
插入的基本逻辑是,小,相同的放左边,大的放右边
1.67放根节点
2.7比67小,放67的左节点
3.30比67小,找到67的左节点7,30比7大,就放在7的右节点
4.73比67大,放在67的右节点
5.10比67小,比7大,找到7的右节点30,比30小,放在30的左节点
6.0比67小,比7小,放在7的左节点
7.78比67大,找到67的右节点73,比73大,放在73的右节点
8.81比67大,找到73的右节点78,比78大,放在78的右节点
9.10比67小,找到67的左节点7,比7大,找到7的右节点30,比30小,找到30的左节点,10,与10相等,放在10的左节点
10.74比67大,找到67的右节点73,比73大,找到73的右节点78,比78小,放在78的左节点
 */


import java.util.ArrayList;
import java.util.List;

public class Node {
    //左子节点
    public Node leftNode;
    //右子节点
    public Node rightNode;
    //值
    public Object value;

    public void add(Object v) {
        //如果当前节点没有值,就把数据放在当前节点上
        if (null == value) {
            value = v;
        }
        //如果当前节点有值,新增的值与当前节点的值进行大小比较
        else {
            //如果新增的值比当前值小或者相等
            if ((Integer) v - (Integer) value <= 0) {
                //如果左节点的为未空,则左节点指向新的Node对象,新的Node对象就是插入的对象
                if (null == leftNode) {
                    leftNode = new Node();//为什么不用leftNode=v?
                }
                //递归:如果左节点的值不为空,则将左节点作为value,来调用本方法
                leftNode.add(v);


            }
            //新增的值比当前值大
            else {
                if (null == rightNode) {
                    rightNode = new Node();
                }
                rightNode.add(v);

            }
        }
    }

    //中序遍历所有节点(声明方法,返回List)
    public List<Object> values() {
        List<Object> values = new ArrayList<>();

        //左节点的遍历结果
        //如果当前节点(根节点)的左节点不为空,就把当前节点(根节点)的左节点的values值取出来,放在values中
        //解释如下
        /*
        传入的值为

         */
        if (null != leftNode) {
            values.addAll(leftNode.values());
        }
        //当前节点
        values.add(value);

        //右节点遍历结果
        if (null != rightNode) {
            values.addAll(rightNode.values());
        }
        return values;

    }

    public static void main(String[] args) {
        int[] randoms = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        System.out.println(roots.values());
    }


}
/*
 //左子节点
    public Node leftNode;
    //右子节点
    public Node rightNode;
    //值
    public Object value;

    这些声明是方法,属性,还是Object类?抽象类?内部类?

    public void add(Object v)
    object 是什么类型?对象?属性?值?数组?元素?表?
 */