package School;
class Test{
    Test test = null;
}
public class csdn {
    public static void main(String[] args) {
        //第一步引用
       Test a = new Test();
       Test b = new Test();
       //对象内部的引用
       a.test = b;
       b.test = a;
       //将对象的指向为null
        a = null;
        b = null;

    }
}
