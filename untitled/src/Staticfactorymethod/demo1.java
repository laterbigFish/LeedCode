package Staticfactorymethod;
//生成器
class NutritionFacts{
    private final  int serving;
    private final  int  servingSize;
    private final  int age;
    //静态内部类
    public static  class Builder {
        private final int serving;
        private final int servingSize;
        private int age;

        public  Builder(int serving, int servingSize) {
            this.serving = serving;
            this.servingSize = servingSize;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }
        public NutritionFacts Build(){
            return new NutritionFacts(this);
        }

    }

    NutritionFacts(Builder builder){
        serving = builder.serving;
        servingSize = builder.servingSize;
        age = builder.age;
    }
}
//单例模式
class Singleton {
    private static Singleton singleton = new Singleton();
    private int age;

    private Singleton() {
    }//防止被实例化

    //静态工厂方法
    private static Singleton getInstance() { //可以有特定的名称 不用每次都建立一个新对象
        return singleton;
    }
}
public class demo1 {
    public static void main(String[] args) {
        //通过这种方式就解决了，不可变类的情况 保证了线程安全问题
    NutritionFacts nutritionFacts = new NutritionFacts.Builder(100,
            100).
            age(10).
            Build();

    }
}
