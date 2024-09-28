package School;

public class Main {
    public static  void main(String[] args) {
        long[] array = new long[2];
        int count = 0;
        long l = 202420242024L;
        while(true){
            if((++count)%2==1){
                array[0]+=20;
                if(count==l) System.out.println(array[0]);
            }else{
                array[1]+=24;
                if(count==l) System.out.println(array[1]);
            }
        }
    }
}
