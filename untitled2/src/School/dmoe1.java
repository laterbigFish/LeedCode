package School;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

//class String{ //这样的操作是被允许的
// maxProfit(int[] prices) {

//         int[][] f = new int[prices.length][3],g = new int[prices.length][3];
//         for(int i=0;i<3;i++) f[0][i] = g[0][i] = 0x3f3f3f3f;
//         f[0][0] = prices[0]*(-1);
//         for(int i=1;i<prices.length;i++){
//             for(int j=0;j<3;j++){
//                 f[i][j] = Math.max(f[i-1][j],g[i-1][j]-prices[i]);
//                 g[i][j] = g[i-1][j];
//                 if(j-1>=0)
//                     g[i][j] = Math.max(g[i-1][j],f[i-1][j-1]+prices[i]);
//             }
//         }
//        int ret = 0;
//         for(int i=0;i<3;i++) ret = Math.max(ret,g[prices.length-1][i]);
//         return ret;
//    }
//    public static void LanQ(){
//        long[] array = new long[2];
//        int count = 0;
//        long l = 202420242024L;
//        while(true){
//          if((++count)%2==1){
//              array[0]+=20;
//              if(count==l) System.out.println(array[0]);
//          }else{
//              array[1]+=24;
//              if(count==l) System.out.println(array[1]);
//          }
//        }
//    }
//
//    public static void main(String[] args) {
//        LanQ();
//    }
//    //请找到一个大于2024的最小十进制数，这个数转换成十六进制后，所有的数位（不含前导零）都为字母（A到F）。
//    public static void main2(String[] args) {
//      Scanner scanner   = new Scanner(System.in);
//      int t = scanner.nextInt();
//      while(t--!=0){
//          int[] array = new int[scanner.nextInt()];
//          for(int i=0;i<array.length;i++){
//              array[i] = scanner.nextInt();
//          }
//          //重新排列观察是否有mod不为零的情况
//
//      }
//    }
//    public static void main1(String[] args) {
//        Scanner scanner=  new Scanner(System.in);
//
//        while(scanner.hasNextInt()){
//            HashSet<Integer> hashSet = new HashSet<>();
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            for(int i=0;i<n;i++){
//                hashSet.add(scanner.nextInt());
//            }
//            for(int i=0;i<m;i++){
//                int input = scanner.nextInt();
//                if(hashSet.contains(input)) System.out.print(input+" ");
//            }
//        }
//    }
//}
