package School;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class dmoe1 {
    public static void LanQ(){
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

    public static void main(String[] args) {
        LanQ();
    }
    //请找到一个大于2024的最小十进制数，这个数转换成十六进制后，所有的数位（不含前导零）都为字母（A到F）。
    public static void main2(String[] args) {
      Scanner scanner   = new Scanner(System.in);
      int t = scanner.nextInt();
      while(t--!=0){
          int[] array = new int[scanner.nextInt()];
          for(int i=0;i<array.length;i++){
              array[i] = scanner.nextInt();
          }
          //重新排列观察是否有mod不为零的情况

      }
    }
    public static void main1(String[] args) {
        Scanner scanner=  new Scanner(System.in);

        while(scanner.hasNextInt()){
            HashSet<Integer> hashSet = new HashSet<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int i=0;i<n;i++){
                hashSet.add(scanner.nextInt());
            }
            for(int i=0;i<m;i++){
                int input = scanner.nextInt();
                if(hashSet.contains(input)) System.out.print(input+" ");
            }
        }
    }
}
