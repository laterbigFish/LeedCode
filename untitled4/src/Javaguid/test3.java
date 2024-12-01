package Javaguid;

import java.util.Scanner;

class A {
    public int a;

    public A () {
        System.out.println ( "A进行加载了" );
    }
}
class B extends A{
    private int age;
    public B(){
        System.out.println ("B进行加载");
    }
}
public class test3 {
//    public static B b = new B ();
//    public  static A a = new A ();
//    public test3(){
//        System.out.println ("test3加载了");
//    }
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        while(scan.hasNextInt()){
            int t = scan.nextInt();
            int count = 0;
            for(int i=0;i<t;i++){
                String str = String.valueOf(scan.nextInt());
                boolean flag = true;
                if(str.length()>2){
                    for(int j = 1;j<str.length();j++){
                        if(str.charAt(j)!=str.charAt(j-1)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) count++;
                }
            }
            System.out.println(count);
        }
        scan.close();
    }
}
