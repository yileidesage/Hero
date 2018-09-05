package how2j_09052;

public class Hero {
    public String name;
    public float hp;
    public int damage;

    //回血
    //直接在方法前加上修饰符synchronized
    //其所对应的同步对象，就是this
    //和hurt方法达到的效果一样
    public synchronized void recover() {
        hp = hp + 1;
        System.out.printf("%s回血1点,增加血后,%s的血量是%.0f%n", name, name, hp);
        //通知哪些等在this对象上的线程,可以醒过来了
        this.notify();
    }

    public synchronized void hurt() {
        if (hp == 1) {
            try {
                //让占有this的减血线程,暂时释放对this的占有,并等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        hp = hp - 1;
        System.out.printf("%s减血1点,减少血后,%s的血量是%.0f%n", name, name, hp);


    }

    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要的时间,每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp = h.hp - damage;//h.hp-=damage
        System.out.format("%s正在攻击%s,%s的血变成了%.0f%n", name, h.name, h.name, h.hp);

        //%.0f是什么意思?
        //hp的格式为浮点数

        if (h.isDead()) {
            System.out.println(h.name + "死了!");
        }
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

}
