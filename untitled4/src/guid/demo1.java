package guid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class demo1 {
//    // 判断一下是否是回文串
//    private boolean[][] t;
//
//    public void findHui(String s) {
//        t = new boolean[s.length()][s.length()];
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            for (int j = i; j < s.length(); j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    t[i][j] = i + 1 < j ? t[i + 1][j - 1] : true;
//                }
//            }
//        }
//    }
//    public int minCut(String s) {
//        // 返回最少切割次数
//        int[] dp = new int[s.length()];
//        int ret = s.length ();
//        Arrays.fill ( dp,Integer.MAX_VALUE );
//        for(int i=0;i<s.length ();i++){
//            if(t[0][i]) dp[i] = 0;
//            else
//                for(int j = 1;j<=i;j++){
//                if(t[0][j-1] && t[j][i]) dp[i] = Math.min ( dp[j-1]+1,dp[i] );
//            }
//        }
//        for(int i=0;i<dp.length;i++){
//            ret = Math.min ( ret,dp[i] );
//        }
//        return ret;
//    }
//    public String longestPalindrome(String s) {
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int left = 0,right = 0;
//        //从下往依次查找
//
//        for(int i = s.length()-1;i>=0;i--){
//            for(int j = i;j<s.length();i++){
//                //有两种特殊情况
//                if(s.charAt ( i )==s.charAt ( j )) {
//                    dp[i][j] = i + 1 < j ? dp[i + 1][j - 1] : true;
//                }
//                //记录此时最长的左右下标
//                    if(dp[i][j]){
//                        if(Math.abs ( j-i )>Math.abs ( right-left )?true:false){
//                            right = j;
//                            left = i;
//                        }
//                    }
//            }
//        }
//
//        return s.substring(left,right);
//    }
    //求最大公约数
public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b; // 余数
        a = temp;  // 将b的值赋给a
    }
    return a; // 返回最大公约数
}

    public static void main ( String[] args ) {
         Scanner scanner = new Scanner ( System.in );

         while(scanner.hasNextInt ()){
             int n = scanner.nextInt ();
             int[] cur = new int[n];

             for(int i=0;i<n;i++){
                 cur[i] = scanner.nextInt ();
             }
             int sum = 0;

             for(int i=0;i<cur.length;i++){
                 for(int j = i+1;j<cur.length;j++){
                     sum+=cur[i]*cur[j];
                 }
             }
             System.out.println (sum);
         }
    }
   //任意两个相邻的的元素
    public static void main2 ( String[] args ) {

       Scanner scanner = new Scanner ( System.in );

       while(scanner.hasNextInt ()){
           int t = scanner.nextInt ();
           int[] temp = new int[t];
           for(int i=0;i<t;i++){
               temp[i] = scanner.nextInt ();
           }
           if(t==1 && temp[0]!=1){
               System.out.println (-1);
               break;
           }
           //任意两个相邻的元素

           for(int i=0;i<temp.length-1;i++){
               if(gcd ( temp[i],temp[i+1] )==1){

               }
           }
       }
    }
}
