package LeedCode;

import java.util.*;

public class demo4 {
    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,1,-1};
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size (),n = forest.get ( 0 ).size ();
        List<int[]> list = new LinkedList <> ();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 //表示它是一颗树
                if(forest.get ( i ).get ( j )>1){
                //放入到list中
                 list.add ( new int[]{i,j} );
                }
            }
        }
        //根据坐标从小到大排序
       Collections.sort ( list,(a,b)->{
           return forest.get (a[0]).get ( a[1] ) - forest.get ( b[0] ).get ( b[1] );
       } );
        //按照顺序砍树
        int bx = 0,by = 0;
        int ret = 0;
        for(int[] tree:list){
            int x  = tree[0],y = tree[1];
            int step = bfs(forest,bx,by,x,y);
            if(step==-1) return -1;
            ret+=step;
            bx = x;
            by = y;
        }
        return ret;
    }

    private int bfs ( List <List <Integer>> forest , int bx , int by , int x , int y ) {
        //宽度优先
        if(bx==x && by==y) return 0;
        int ret = 0;
        Deque<int[]> deque = new LinkedList <> ();
        boolean[][] vision = new boolean[forest.size ()][forest.get ( 0 ).size ()];
        deque.add (new int[]{bx,by});
        vision[bx][by] = true;
        while(!deque.isEmpty()){
            ret++;
            int sz = deque.size ();
            while(sz--!=0){
                int[] t = deque.poll ();
                int a = t[0],b = t[1];
                for(int i=0;i<4;i++){
                    int x1 = a +dx[i],y1 = b + dy[i];
                    if(x1>=0 && x<forest.size () && y>=0 && y<forest.get ( 0 ).size () && !vision[x1][y1] && forest.get ( x1 ).get ( y1 )!=0){

                        if(x1==x && y1==y) return ret;
                        deque.add ( new int[]{x1,y1} );
                        vision[x1][y1] = true;

                    }
                }
            }
        }
        return -1;
    }
//    public int ret = 0;
//
//    public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        HashSet<String> vis = new HashSet<>();
//        HashSet<String> hash = new HashSet<>(wordList);
//        Deque<String> deque = new LinkedList<>();
//        char[] temp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
//                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
//        deque.add(beginWord);
//        vis.add(beginWord);
//
//        if (beginWord.equals(endWord) || !hash.contains(endWord))
//            return 0;
//
//        while (!deque.isEmpty()) {
//            ret++;
//            int sz = deque.size();
//            while (sz-- != 0) {
//                String t = deque.poll();
//                for (int i = 0; i < t.length(); i++) {
//                    char[] charArray = t.toCharArray();
//                    for (int j = 0; j < 26; j++) {
//                        charArray[i] = temp[j];
//                        String next = String.valueOf(charArray);
//                        if (hash.contains(next)
//                                && !vis.contains(next)) {
//                            if (String.valueOf(charArray[i]).equals(endWord))
//                                return ret;
//
//                            deque.add(String.valueOf(charArray[i]));
//
//                            vis.add(String.valueOf(charArray[i]));
//                        }
//                    }
//                }
//            }
//        }
//
//        return -1;
//    }
//    public  static  int findNumberOfLIS(int[] nums) {
//
//        int n = nums.length, maxLen = 0, ans = 0;
//        int[] dp = new int[n];
//        int[] cnt = new int[n];
//        for (int i = 0; i < n; ++i) {
//            dp[i] = cnt[i] = 1;
//            for (int j = 0; j < i; ++j) {
//                if (nums[i] > nums[j]) {
//                    if (dp[j] + 1 > dp[i]) {
//
//                        dp[i] = dp[j] + 1;
//                        cnt[i] = cnt[j]; // 重置计数
//                    } else if (dp[j] + 1 == dp[i]) {
//                        cnt[i] += cnt[j];
//                    }
//                }
//            }
//
//            if (dp[i] > maxLen) {
//                maxLen = dp[i];
//                ans = cnt[i]; // 重置计数
//            } else if (dp[i] == maxLen) {
//                ans += cnt[i];
//            }
//
//        }
//        return ans;
//    }
//    public  static int  lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        // 以i位置为结尾的最长递增子序列
//
//        int[] dp = new int[nums.length],temp = new int[nums.length];
//        dp[0] = temp[0]=1;
//        int ret = 0;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//
//                if (nums[i] > nums[j]) {
//                    temp[dp[j]+1]++;
//                    dp[i]=Math.max ( dp[i] , dp[j]+1 );
//                }
//                else if(nums[i] == nums[j]){
//                    temp[dp[j]]++;
//                }
//            }
//            ret = Math.max(ret, dp[i]);
//        }
//        if(ret==1) return 1;
//        return temp[ret];
//    }
//    public  static int findNumberOfLIS(int[] nums) {
//        return lengthOfLIS(nums);
//    }

    public static void main ( String[] args ) {

    }
    //最长递增子序列的个数
//    public int findNumberOfLIS(int[] nums) {
//        int n = nums.length, maxLen = 0, ans = 0;
//        int[] dp = new int[n];
//        int[] cnt = new int[n];
//        for (int i = 0; i < n; ++i) {
//            dp[i] = 1;
//            cnt[i] = 1;
//            for (int j = 0; j < i; ++j) {
//                if (nums[i] > nums[j]) {
//                    if (dp[j] + 1 > dp[i]) {
//                        dp[i] = dp[j] + 1;
//                        cnt[i] = cnt[j]; // 重置计数
//                    } else if (dp[j] + 1 == dp[i]) {
//                        cnt[i] += cnt[j];
//                    }
//                }
//            }
//            if (dp[i] > maxLen) {
//                maxLen = dp[i];
//                ans = cnt[i]; // 重置计数
//            } else if (dp[i] == maxLen) {
//                ans += cnt[i];
//            }
//        }
//        return ans;
//    }
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        //以i位置为结尾的最长递增子序列
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int ret = 1;
//
//        for(int i = 1;i<nums.length;i++){
//            dp[i] = 1;
//            for(int j = 0;j<i;j++){
//                if(nums[i]<nums[j]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//            ret = Math.max(ret,dp[i]);
//        }
//
//        return ret;
//    }
//    public int findSubstringInWraproundString(String s) {
//        //以i位置为结尾的在base中所有子串的数量
//        int[] dp = new int[s.length()];
//        if(s.length()<2) return 1;
//        //先将所有的dp初始化为1
//        for(int i=0;i<s.length();i++) dp[i] = 1;
//        for(int i=1;i<s.length();i++){
//            //可以省略为1的情况
//            if(s.charAt(i)=='a' && s.charAt(i-1)=='z' || s.charAt(i)==s.charAt(i-1)+1){
//                dp[i] = dp[i-1]+1;
//            }
//        }
//        //结果为dp中所有的值的和
//        int ans = 0;
//        for(int cur:dp) ans+= cur;
//        return ans;
//    }
//    public  static int wiggleMaxLength(int[] nums) {
//        int n = nums.length;
//        if (n < 2) {
//            return n;
//        }
//        //向上摆动和向下摆动
////        1,7,4,1,2,5
//        int[] up = new int[n];
//        int[] down = new int[n];
//        up[0] = down[0] = 1;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//              up[i] = Math.max ( up[i-1] , down[i-1] +1);
//              down[i] = down[i-1];
//            } else if (nums[i] < nums[i - 1]) {
//              down[i] = Math.max ( down[i-1] ,up[i-1] + 1);
//              up[i] = up[i-1];
//            } else {
//                down[i] = down[i-1];
//                up[i] = up[i-1];
//            }
//        }
//        return Math.max(up[n - 1], down[n - 1]);
//    }
//
//    public static void main ( String[] args ) {
//         String s = "afds";
//        System.out.println (s.charAt ( 0 )+1);
//    }
//    public static void main(String[] args) {
//        int[] arr = {38, 27, 43, 3, 9, 82, 10};
//        System.out.println("原数组: " + Arrays.toString(arr));
//        mergeSort(arr);
//        System.out.println("排序后的数组: " + Arrays.toString(arr));
//    }
//
//    public static void mergeSort(int[] arr) {
//        if (arr.length < 2) return; // 如果数组长度小于2，直接返回
//
//        int mid = arr.length / 2; // 找到中间索引
//        int[] left = Arrays.copyOfRange(arr, 0, mid); // 左半部分
//        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // 右半部分
//
//        mergeSort(left); // 递归排序左半部分
//        mergeSort(right); // 递归排序右半部分
//        int[] temp = new int[right-left+1];
//    }
//
//    private static void merge(int[] arr, int[] left, int[] right) {
//        int i = 0, j = 0, k = 0;
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j]) {
//                arr[k++] = left[i++];
//            } else {
//                arr[k++] = right[j++];
//            }
//        }
//        while (i < left.length) {
//            arr[k++] = left[i++];
//        }
//        while (j < right.length) {
//            arr[k++] = right[j++];
//        }
//    }
}
