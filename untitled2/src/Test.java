class A {
    public A() {
        System.out.println("A");
    }
    static {
        System.out.println("A static");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
    static {
        System.out.println("B static");
    }
}

public class Test {
    static B b = new B(); //先进行加载列类之后再进行初始化，先执行A的静态代码块之后再执行B的静态代码块

    public static void main(String[] args) {
//        new A();
//        new B();
    }
}