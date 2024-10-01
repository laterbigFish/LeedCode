
class teste{
    public teste(){
        System.out.println("teste");
    }
    static {
        System.out.println("hello");
    }
}
public class demo11 {
    public  static  teste teste1 = new teste();
    public static void main(String[] args) {
        System.out.println("teste开始执行");
        new teste();
    }
}
