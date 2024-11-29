package LeedCode;

import java.util.*;

public class demo4 {

//
//        [0,0,0,1,1,1,0,0,0,0],
//        [1,1,0,0,0,1,0,0],
//        [0,0,0,1,1,1,0,0,0,0],
//        [0,1,1,0,0,0,1,0,1,0],
//        [0,1,1,1,1,1,0,0,1,0],
//        [0,0,1,0,0,0,0,0,0,0],
//        [0,1,1,0,0,0,0,0,0,0],
//        [0,0,1,0,0,0,0,0,0,0],
//        [1,0,1,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,0,0,0,1]
    public static   int[] dx = { 1, -1, 0, 0 };
    public  static int[] dy = { 0, 0, 1, -1 };

    public  static int numEnclaves(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        int ret = 0;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1) ret++;
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1){
                deque.add(new int[] { i, 0 });
                ret--;
                grid[i][0] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1){
                ret--;
                deque.add(new int[] { 0, i });
                grid[0][i] = 0;
            }
        }

        while (!deque.isEmpty()) {
            int[] t = deque.poll();

            int a = t[0], b = t[1];
            for(int i=0;i<4;i++){
                int x = a + dx[i],y = b + dy[i];
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                    deque.add(new int[]{x,y});
                    ret--;
                    grid[x][y] = 0;
                }

            }
        }
        return ret;
    }

    public static void main ( String[] args ) {
        int[][] array = {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},
                {0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0}};
        System.out.println ( numEnclaves ( array ) );
    }
//    private final int[] dx = { 1, -1, 0, 0 };
//    private final int[] dy = { 0, 0, 1, -1 };
//    private int[][] dist;
//
//    public int[][] updateMatrix(int[][] mat) {
//        dist = new int[mat.length][mat[0].length];
//        Deque<int[]> deque = new LinkedList <> ();
//        for(int[] cur:dist) Arrays.fill(cur,-1);  //统一初始化为-1 可以观察到是否是最先遍历到的
//
//        for(int i=0;i<mat.length;i++){
//            for(int j = 0;j<mat[0].length;j++){
//                if(mat[i][j]==0){
//                    deque.offer(new int[]{i,j});
//                    dist[i][j] = 0;
//                }
//            }
//        }
//        while(!deque.isEmpty()){
//
//            int sz = deque.size();
//            while(sz--!=0){
//                int[] cur = deque.poll();
//                int a = cur[0],b = cur[1];
//
//                for(int i=0;i<4;i++){
//                    int x = a + dx[i],y = b+dy[i];
//                    if(dist[x][y]==-1 && x>=0 && y>=0 && x <mat.length && y<mat[0].length){
//                        dist[x][y] = dist[a][b]+1;
//                        deque.offer(new int[]{x,y});
//                    }
//                }
//            }
//        }
//        return dist;
//    }
//    public  static  int numberOfArithmeticSlices(int[] nums) {
//        //非常恶心 计算中途可能会溢出
//        if (nums.length < 3)
//            return 0;
//
//        HashMap<Long, int[]> hashMap = new HashMap<>();
//        int[][] dp = new int[nums.length][nums.length];
//        int ret = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.getOrDefault((long)nums[i], null) == null) {
//                hashMap.put( (long) nums[i] , new int[] { i });
//            } else {
//                int[] cur = Arrays.copyOf(hashMap.get((long)nums[i]), hashMap.get((long)nums[i]).length + 1);
//
//                cur[cur.length - 1] = i;
//                hashMap.put((long)nums[i], cur);
//            }
//        }
//
//        for (int j = 2; j < nums.length; j++) {
//            for (int i = 1; i < j; i++) {
//                long a = (long) (2L * nums[i] - nums[j]);
//                if (hashMap.containsKey(a)) {
//                    for (int index : hashMap.get(a)) {
//                        if (index < i) {
//                            dp[i][j] += (dp[index][i] + 1);
//                        } else {
//                            break;
//                        }
//                    }
//                    ret += dp[i][j];
//                }
//            }
//        }
//        return ret;
//    }
//    public  static int longestArithSeqLength(int[] nums) {
//        // 也行就是时间复杂度有点高 超时了
//        int[][] dp = new int[nums.length][nums.length];
//        int ret = 2;
//        HashMap<Integer,int[]> hashMap = new HashMap <> ();
//        for (int k = 0; k < nums.length; k++) {
//            if(hashMap.get(nums[k])==null){
//                hashMap.put ( nums[k],new int[]{k} );
//            }else{
//                //取出数组中的元素
//                int[] cur = hashMap.get ( nums[k] );
//                //将新的hash值放进去
//                int[] t = new int[cur.length+1];
//                for(int i=0;i<cur.length;i++){
//                    t[i] = cur[i];
//                }
//                //从小到呀依次排列
//                t[t.length-1] = k;
//                hashMap.put ( nums[k],t );
//            }
//            for (int i = k-1; i >=0; i--) {
//                dp[i][k] = 2;
//               //观察是够有满足条件的等差元素
//                int n = nums[k] - nums[i];
//                if(hashMap.containsKey ( nums[i]-n )){
//                    int[] cur = hashMap.get ( nums[i]-n );
//
//                    for(int j = 0;j<cur.length;j++){
//                        if(cur[j]<i){
//                            dp[i][k] +=  dp[cur[j]][i]+1;
//                            ret+=dp[i][j];
//                        }
//                    }
//                }
//
//            }
//        }
//        return ret;
//    }
//    public int lenLongestFibSubseq(int[] arr) {
//        int[][] dp = new int[arr.length][arr.length];
//        HashMap<Integer,Integer>hashMap = new HashMap <> ();
//        Arrays.fill(dp,2);
//        for(int i=0;i<arr.length;i++){
//            hashMap.put ( arr[i],i );
//        }
//        int ret = 0;
//        for(int j = 2;j<arr.length;j++){
//            for(int i = 0;i<j;i++){
//                if(arr[j]-arr[i]<arr[i] && hashMap.containsKey ( arr[j]-arr[i] )){
//                    dp[i][j] = dp[hashMap.get ( arr[j]-arr[i] )][i]+1;
//                }
//                ret = Math.max ( ret,dp[i][j] );
//            }
//        }
//        return ret<3?0:ret;
//    }
//    public int lenLongestFibSubseq(int[] arr) {
//        int[][] dp = new int[arr.length][arr.length];
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            hashMap.put(arr[i], i);
//        }
//
//        int ret = 0;
//
//        for (int j = 0; j < arr.length; j++) {
//            for (int i = 0; i < arr.length; i++) {
//                dp[i][j] = 2;
//                if (i < j && hashMap.get(arr[i] - arr[j]) != null && hashMap.get(arr[i] - arr[j]) < j) {
//                    // 找到了之后进行赋值
//                    dp[i][j] = dp[hashMap.get ( arr[j] - arr[i] )][j]+1;
//                    ret = Math.max(ret, dp[i][j]);
//                }
//            }
//        }
//        if (ret <= 2)
//            return 0;
//
//        return ret;
//    }
    public int longestSubsequence(int[] arr, int difference) {
        int[][] dp = new int[arr.length][arr.length];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hashMap.put ( arr[i],i );
        }
        int ret = 0;
         Arrays.fill ( dp ,2);
        for(int j = 0;j<arr.length;j++){
            for(int i = 0;i<arr.length;i++){
                if(i<j && hashMap.get ( arr[i] - arr[j] )<i){
                     //找到了之后进行赋值
                    dp[i][j] = dp[arr[i] - arr[j]][j]+1;
                    ret = Math.max(ret,dp[i][j]);
                }
            }
        }
        if(ret<=2) return 0;

        return ret;
    }
    public int findLongestChain2(int[][] pairs) {
        // 以i位置为结尾的最长数对链
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        //以任意顺序进行排列因此可以改变数组

        Arrays.sort(pairs, (v1, v2) -> {
            return v1[0] - v2[0];
        });
        for (int i = 0; i < pairs.length; i++) {

            for (int k = 0; k < i; k++) {
                if (pairs[i][0] > pairs[k][1]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }

            }
        }
        return dp[pairs.length - 1];
    }
    public int findLongestChain(int[][] pairs) {
        //以i位置为结尾的最长数对链
        int[] dp = new int[pairs.length+1];
        int ans = 1;

        for(int i = 0;i<pairs.length;i++){
            dp[i] = 1;
            //从前面找到那个最长的数对链表
            int max = 0;
            for(int k=0;k<i;k++){

            }
            dp[i]+=max;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public  static boolean canJump(int[] nums) {

        int left = 0, right = 0, maxpos = 0;

        while (left <= right) {
            if (maxpos >= nums.length - 1)
                return true;

            for (int i = left; i <= right; i++) {
                maxpos = Math.max(maxpos, i + nums[i]);
            }
            left = right+1;
            right = maxpos;

        }

        return false;
    }
    public int jump(int[] nums) {
        int ans = 1;
        int left = 0,right = 0;
        while(true){
             if(right>= nums.length) break;
          int max = 0;
          for(int i=left;i<=right;i++){
              max  =  Math.max(max,nums[i]+i);
          }
          left = right+1;
          right = max;
        }
        return ans;
    }
    public int jump1(int[] nums) {
       //从零开始到达i的最小跳跃次数
        int[] dp = new int[nums.length];

      for(int i=0;i<nums.length;i++){

           for(int k = 0;k<i;k++){
               if(nums[k]+k>=i){
                   dp[i] = dp[k]+1;
                   break;
               }
           }
      }

      return  dp[nums.length-1];
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2) return intervals;
           Arrays.sort ( intervals,(v1,v2)->{
               return v1[0] - v2[0];
           } );
           List<int[]> list = new LinkedList <> ();
           for(int i = 0;i<intervals.length;i++){
                int left = intervals[i][0],right = intervals[i][1];
                if(list.size ()==0 ||  left>list.get ( list.size ()-1 )[1]){

                    list.add ( new int[]{left,right});
                }else{
                   //进行合并
                    list.get ( list.size ()-1 )[1] = Math.max ( list.get ( list.size ()-1 )[1],right );
                }
           }

           return list.toArray (new int[list.size ()][]);
    }

//    public static void main ( String[] args ) {
//        HashMap<Integer,Integer> hashMap = new HashMap <> ();
//
//        hashMap.put ( 3,1 );
//        System.out.println (hashMap.get ( 3 ));
//        hashMap.put ( 3,2 );
//        System.out.println (hashMap.get ( 3 ));
//
//    }
public static void main2 ( String[] args ) {
        int[] array = {7,7,7,7,7};
//    System.out.println ( numberOfArithmeticSlices ( array ) );
//        int[] cur= Arrays.copyOf ( array,array.length+1 );
//        cur[cur.length-1] =  10000;
//    System.out.println (Arrays.toString ( cur ));
//    HashMap<Integer,Integer> hashMap = new HashMap <> ();

//       int[] array = {1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,100,103,106,109,112,115,118,121,124,127,130,133,136,139,142,145,1,6,11,16,21,26,31,36,41,46,51,56,61,66,71,76,81,86,91,96,101,106,111,116,121,126,131,136,141,146,151,156,161,166,171,176,181,186,191,196,201,206,211,216,221,226,231,236,241,246,251,256,261,266,271,276,281,286,291,296,301,306,311,316,321,326,331,336,341,346,351,356,361,366,1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,100,103,106,109,112,115,118,121,124,127,130,133,136,139,142,145,148,151,154,157,160,163,166,169,172,175,178,181,184,187,190,193,196,199,202,205,208,211,214,217,220,223,226,229,232,235,238,241,244,247,250,253,256,259,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,1,6,11,16,21,26,31,36,41,46,51,56,61,66,71,76,81,86,91,96,101,106,111,116,121,126,131,136,141,146,151,1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,100,103,106,109,112,115,118,121,1,5,9,13,17,21,25,29,33,37,41,45,49,53,57,61,65,69,73,77,81,85,89,93,97,101,105,109,113,117,121,125,129,133,137,141,145,149,153,157,161,165,169,173,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,1,5,1,6,11,16,21,26,31,36,41,46,51,56,61,66,71,76,81,86,91,96,101,106,111,116,121,126,131,136,141,146,151,156,161,166,171,176,181,186,191,196,201,206,211,216,221,226,231,236,241,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,1,6,11,16,21,26,31,36,41,46,51,56,61,66,71,76,81,86,91,96,101,106,111,116,121,126,131,136,141,146,151,156,161,166,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,100,103,106,109,112,115,118,121,124,127,130,133,136,139,142,145,148,151,154,157,160,163,166,169,172,175,178,181,184,187,190,193,196,199,202,205,208,211,214,217,220,223,226,229,232,235,238,241,244,247,1,2,3,4,5,6,1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,100,103,106,109,112,115,118,121,124,127,130,133,136,139,142,145,148,151,154,157,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,1,5,9,13,17,21,25,29,33,37,41,45,49,53,57,61,65,69,73,77,81,85,89,93,97,101,105,109,113,117,121,1,5,9,13,17,21,25,29,33,37,41,45,49,53,57,61,65,69,73,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,6};
    //         int[] array = {2,3,1,1,4};
//    System.out.println ( canJump ( array ) );
//      List<Integer> list = new LinkedList <> ();
//      list.add ( 1 );
//    System.out.println (list.get ( 0 ));
//    System.out.println ( list.remove ( 0 ) );
}
//    public int[][] merge(int[][] intervals) {
//
//        mergesort(intervals,0,intervals.length-1);
//        //进行真实的合并
//
//        return intervals;
//    }
//
//    private void mergesort ( int[][] intervals , int left , int right ) {
//
//        if(left>=right) return;
//        int mid = (left+right)/2;
//
//        mergesort ( intervals,left,mid);
//        mergesort ( intervals,mid+1,right );
//        //进行合并
//         while(left<=mid && mid+1<right){
//
//         }
//
//    }
//    private final int[] dx = {1,-1,0,0};
//    private final int[] dy = {0,0,1,-1};
//    public int cutOffTree(List<List<Integer>> forest) {
//        int m = forest.size (),n = forest.get ( 0 ).size ();
//        List<int[]> list = new LinkedList <> ();
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                 //表示它是一颗树
//                if(forest.get ( i ).get ( j )>1){
//                //放入到list中
//                 list.add ( new int[]{i,j} );
//                }
//            }
//        }
//        //根据坐标从小到大排序
//       Collections.sort ( list,(a,b)->{
//           return forest.get (a[0]).get ( a[1] ) - forest.get ( b[0] ).get ( b[1] );
//       } );
//        //按照顺序砍树
//        int bx = 0,by = 0;
//        int ret = 0;
//        for(int[] tree:list){
//            int x  = tree[0],y = tree[1];
//            int step = bfs(forest,bx,by,x,y);
//            if(step==-1) return -1;
//            ret+=step;
//            bx = x;
//            by = y;
//        }
//        return ret;
//    }
//
//    private int bfs ( List <List <Integer>> forest , int bx , int by , int x , int y ) {
//        //宽度优先
//        if(bx==x && by==y) return 0;
//        int ret = 0;
//        Deque<int[]> deque = new LinkedList <> ();
//        boolean[][] vision = new boolean[forest.size ()][forest.get ( 0 ).size ()];
//        deque.add (new int[]{bx,by});
//        vision[bx][by] = true;
//        while(!deque.isEmpty()){
//            ret++;
//            int sz = deque.size ();
//            while(sz--!=0){
//                int[] t = deque.poll ();
//                int a = t[0],b = t[1];
//                for(int i=0;i<4;i++){
//                    int x1 = a +dx[i],y1 = b + dy[i];
//                    if(x1>=0 && x<forest.size () && y>=0 && y<forest.get ( 0 ).size () && !vision[x1][y1] && forest.get ( x1 ).get ( y1 )!=0){
//
//                        if(x1==x && y1==y) return ret;
//                        deque.add ( new int[]{x1,y1} );
//                        vision[x1][y1] = true;
//
//                    }
//                }
//            }
//        }
//        return -1;
//    }
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

//    public static void main ( String[] args ) {
//
//    }
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
