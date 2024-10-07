public class Main{
    //最大子数组的和
    public int maxSubArray(int[] nums) {

    }
    public  static  int maxProfit(int k, int[] prices) {
        int[][] f = new int[prices.length][k+1],g = new int[prices.length][k+1];
        k = Math.min(k,prices.length/2);
        for(int i=0;i<prices.length;i++) g[0][i] = f[0][i] = -0x3f3f3f3f;
        f[0][0] = -prices[0];
        g[0][0] = 0;
        for(int i=1;i<prices.length;i++){

            for(int j=0;j<=k;j++){
                //状态转移方程
                f[i][j] = Math.max(f[i-1][j],g[i-1][j]-prices[i]);
                g[i][j] =  g[i-1][j];
                if(j-1>=0) g[i][j] = Math.max(g[i][j],f[i-1][j-1]+prices[i]);
            }
        }
        int ret = 0;
        for(int i=0;i<prices.length;i++) ret = Math.max(ret,g[prices.length-1][i]);
        return ret;
    }
    public static void main(String[] args) {
  int[] prrces = {3,2,6,5,0,3};
        System.out.println(maxProfit(2, prrces));
    }
}