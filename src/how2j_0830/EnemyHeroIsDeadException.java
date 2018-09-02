package how2j_0830;

class EnemyHeroIsDeadException extends Exception{
    //无参的构造方法，修饰词+类名（参数类型 参数名）{表达式123}
    public EnemyHeroIsDeadException(){

    }
    public EnemyHeroIsDeadException(String msg){
        super(msg);
    }
}
