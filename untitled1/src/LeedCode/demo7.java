package LeedCode;

import java.util.Arrays;

public class demo7 {
//    public ListNode reverseList(ListNode head) {
//        if(head==null || head.next==null){
//            return head;
//        }
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
    //买股票的最佳时机
    public int maxProfit(int[] prices, int fee) {

        int[] f = new int[prices.length];
        int[] g= new int[prices.length];

        f[0] = prices[0]*(-1);
        g[0] = 0;
        for(int i=1;i< prices.length;i++){
            f[i] = Math.max(f[i-1],g[i-1]-prices[i]);
            g[i] = Math.max(g[i-1],f[i-1]+prices[i]-fee);
        }
        return Math.max(f[prices.length-1],g[prices.length-1]);
    }
    public int maxProfit(int[] prices) {
         int[][] dp = new int[prices.length][3];
         //初始化
         dp[0][0] = prices[0]*(-1);
         dp[0][1] = 0;
         dp[0][2] = 0;
         for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]); //买入状态
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2] = dp[i-1][0] + prices[i];
        }
         return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
     public static void main(String[] args) {

    }
}
