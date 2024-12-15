package Javaguid;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class test5 {
//    public  static  int[][] insert(int[][] intervals, int[] newInterval) {
//        int left = newInterval[0], right = newInterval[1];
//        // 左边第一个大于大的区间 右边第一个小于它的区间
//        int index1 = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            int tempRight = intervals[i][1];
//            if (tempRight >= left) {
//                index1 = i;
//                break;
//            }
//        } //没毛病
//
//        int index2 = 0;
//        for (int i = intervals.length-1; i >= 0; i--) {
//            int tempRight = intervals[i][1];
//            if (tempRight <= right) {
//                index1 = i;
//                break;
//            }
//        }
//        int index = 0;
//        // 判断合并哪个区间
//        int[][] ret = new int[intervals.length - (index2 - index1)][2];
//        for (int i = 0; i < intervals.length; i++) {
//            if (i == index1 && i==index2) {
//                int[] temp = new int[] {intervals[], newInterval[1] };
//                ret[index++] = temp;
//            } else if (i == index2) {
//                // 合并区间
//                int cur1 = intervals[index1][0], cur2 = intervals[index2][1];
//                int[] temp = new int[] { cur1, cur1 };
//                ret[index++] = temp;
//
//            } else {
//                ret[index++] = intervals[i];
//            }
//        }
//
//        return ret;
//    }
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int left = newInterval[0], right = newInterval[1];
//        // 左边第一个大于大的区间 右边第一个小于它的区间
//        int index1 = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            int tempRight = intervals[i][1];
//            if (tempRight >= left) {
//                index1 = i;
//                break;
//            }
//        }
//        int index2 = 0;
//        for (int i = intervals.length-1; i >= 0; i--) {
//            int tempRight = intervals[i][1];
//            if (tempRight <= right) {
//                index1 = i;
//                break;
//            }
//        }
//        // 如果在同一个区间直接返回即可
//        if (index1 == index2)
//            return intervals;
//
//        int index = 0;
//        // 判断合并哪个区间
//        int[][] ret = new int[intervals.length - (index2 - index1)][2];
//        for (int i = 0; i < intervals.length; i++) {
//            if (i == index1) {
//                continue;
//            } else if (i == index2) {
//                // 合并区间
//                int cur1 = intervals[index1][0], cur2 = intervals[index2][1];
//                int[] temp = new int[] { cur1, cur1 };
//                ret[index++] = temp;
//
//            } else {
//                ret[index++] = intervals[i];
//            }
//        }
//
//        return ret;
//    }
    public  static  int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        //初始化反之出现问题
        for(int i=0;i<dp[0].length;i++) dp[0][i] = Integer.MAX_VALUE;
        dp[1][0] = 0;
        if(grid.length>=2) for(int i = 2;i<dp.length;i++) dp[i][0] = Integer.MAX_VALUE;
        for(int i=1;i< dp.length;i++){

            for(int j = 1;j<dp[0].length;j++){
                //只能向下向右走
                dp[i][j] = Math.min ( dp[i][j-1],dp[i-1][j])+grid[i-1][j-1];
            }
        }

        return dp[grid.length][grid[0].length];
    }
     //没必要真的移除只需要记住最值即可

    public static int divide(int a, int b) {
        if(a==0) return 0;
       int cur1 = a/Math.abs ( a ),cur2  = b/Math.abs ( b );
       a = Math.abs ( a );
       b = Math.abs ( b );
       if(a<b) return 0;
       int count = 0;
       while(a>=b){
           a-=b;
           count++;
       }
       return count==0?1:count*cur1*cur2;
    }
    //利用动态数组模拟这个过程
    public  static int lastRemaining1(int n) {
        ArrayList<Integer> list = new ArrayList <> ();

        for(int i=1;i<=n;i++) list.addLast ( i );
        while (list.size() != 1) {
            // 先往右
            int sz = list.size()%2==0?list.size()/2:list.size()/2+1;
            int index = 0, count = 0;
            while (count<sz) {
                list.remove ( index );
                index++;
                count++;
            }
             sz = list.size()%2==0?list.size()/2:list.size()/2+1;
            index = list.size ()-1;
            count = 0;
            if (list.size() == 1)  return list.get(0);
            while (count<sz) {
                list.remove ( index );
                index-=2;
                count++;
            }

        }
        return list.get(0);
    }
//
//    public static   void  deleteZero(List<Integer> list) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) == 0)
//                list.remove(i);
//        }
//    }

//    public static void main ( String[] args ) {
//        int[][] array = {{1,3},{6,9}};
//        insert ( array ,new int[]{2,5} );
//    }
//    public int lengthOfLIS(int[] nums) {
//        ArrayList<Integer> list = new ArrayList <> ();
//        list.add ( nums[0] );
//
//        for(int i = 1;i<nums.length;i++){
//
//            if(nums[i]>list.getLast ()) {
//                //直接加入到最后一个位置
//                list.addLast ( nums[i] );
//            }else{
//                //进行二分
//                int left = 0,right = list.size ()-1;
//                while(left < right){
//                    int mid = (left+right)/2;
//                    if(list.get ( mid )<nums[i]) left = mid+1;
//                    else right = mid;
//                }
//                list.set ( left,nums[i]);
//            }
//        }
//        return list.size();
//    }
//    public static int lengthOfLIS1(int[] nums) {
//
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int ret = 0;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            ret = Math.max(ret, dp[i]);
//        }
//        return ret;
//    }
    public static void main66 ( String[] args ) {
        ArrayList<Integer> arrayList = new ArrayList <> ();
        arrayList.add ( 10 );
        System.out.println (arrayList.size ());
        /*
        *
        *
        *  public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
    }
        * */
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor ( 2,20, );
//
//        BigDecimal bigDecimal = BigDecimal.valueOf(100.1f);
//
//        BigInteger bigInteger = bigDecimal.toBigInteger ();
//        BigDecimal bigDecimal1 = bigDecimal.setScale ( 20 , RoundingMode.HALF_UP);
//        System.out.println (bigDecimal1);
//        Vector<Integer> vector = new Vector<> ();
//        ArrayList<Integer> arrayList =  new ArrayList <> ();
//        LinkedList<Integer> list = new LinkedList <> ();
    }
}
