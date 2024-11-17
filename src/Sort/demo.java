package Sort;

import java.util.*;

class Spir<K,V>{
     private K key;
     private V value;

     public void setKey(K key) {
         this.key = key;
     }

     public void setValue(V value) {
         this.value = value;
     }

     public V getValue() {
         return value;
     }

     public K getKey() {
         return key;
     }
 }
public class demo {
    private int[] dx = { 0, 0, 1, -1 };
    private int[] dy = { 1, -1, 0, 0 };
    private boolean[][] vision;
    private int ret;

    public  int nearestExit(char[][] maze, int[] entrance) {
        vision = new boolean[maze.length+1][maze[0].length+1];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] { entrance[0], entrance[1] });
        vision[entrance[0]][entrance[1]] = true;

        while (!deque.isEmpty()) {
            ret++;
            int sz = deque.size();
            for (int i = 0; i < sz; i++) {
                int[] t = deque.pop();
                int a = t[0], b = t[1];
                for (int k = 0; k < 4; k++) {
                    int x = a + dx[k], y = b + dy[k];
                    if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.'
                            && !vision[x][y]) {
                        // 是否已经走到出口
                        if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1)  return ret;
                        deque.add(new int[] { x, y });
                        vision[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        s = " " + s;
        for (int i = 1; i <= s.length(); i++) {

            for (int j = i; j >= 1; j--) {
                if (dp[j - 1] && set.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++){

            int j = i;
            while(j>=0){

            }
        }

        return dp[s.length()-1];
    }
//    private int[] dx = { 0, 0, 1, -1 };
//    private int[] dy = { 1, -1, 0, 0 };
//    private boolean[][] vis = new boolean[301][301];
//    private int m;
//    private int n;
//
//    public int numIslands(char[][] grid) {
//        int ret = 0;
//        m = grid.length;
//        n = grid[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == '1' && !vis[i][i]) {
//                    ret++;
//                    bfs(grid, i, j);
//                }
//            }
//        }
//        return ret;
//    }
//
//    public void bfs(char[][] grid, int i, int j) {
//        Deque<int[]> deque = new LinkedList<>();
//        deque.add(new int[] { i, j });
//        while (!deque.isEmpty()) {
//
//            int[] t = deque.poll();
//            int a = t[0], b = t[1];
//            vis[a][b] = true;
//            for (int k = 0; k < 4; k++) {
//                int x = a + dx[k], y = b + dy[k];
//                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1' && !vis[x][y]) {
//                    deque.add(new int[] { x, y });
//                    vis[x][y] = true;
//                }
//            }
//        }
//    }
//    private int[] dx = { 1, -1, 0, 0 };
//    private int[] dy = { 0, 0, 1, -1 };
//
//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        int prev = image[sr][sc];
//        if(prev==color)  return image;
//        Deque<int[]> deque = new LinkedList<>();
//        deque.offer(new int[]{sr,sc});
//
//        while(!deque.isEmpty()){
//            int[] cur = deque.poll();
//            int a = cur[0],b = cur[1];//原始坐标
//            image[a][b] = color;
//            for(int i=0;i<4;i++){
//                int x = a +dx[i],y = b+dy[i];
//                if(x>=0 && x<image.length && y>=0 && y< image[0].length && image[x][y]==prev){
//                    deque.add(new int[]{x,y});
//                }
//            }
//        }
//        return image;
//    }
    public  static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(0, -1);
        int ret = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (hashMap.containsKey(sum))
                ret = Math.max(ret, i - hashMap.get(sum));
            else
                hashMap.put(sum, i);
        }
        return ret;
    }
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int cur:bills){
            if(cur==5) hashMap.put(5,hashMap.getOrDefault(5,0)+1);
            else if(cur==10){
                if(hashMap.getOrDefault(5,0)==0) return false;
                else hashMap.put(5,hashMap.getOrDefault(5,0)-1);
                hashMap.put(10,hashMap.getOrDefault(10,0)+1);
            }else{
                hashMap.put(20,hashMap.getOrDefault(20,0)+1);
                //二十元的情况
                if(hashMap.getOrDefault(10,0)!=0 && hashMap.getOrDefault(5,0)>=1){
                    hashMap.put(10,hashMap.getOrDefault(10,0)-1);
                    hashMap.put(5,hashMap.getOrDefault(5,0)-1);
                }else if(hashMap.getOrDefault(5,0)>=3) {
                    hashMap.put(5,hashMap.getOrDefault(5,0)-3);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
     public void func(){
         PriorityQueue<Spir<String,Integer>> priorityQueue1 = new PriorityQueue<>(
                 (v1,v2)->{
                     if(v1.getValue().equals(v2.getValue()))
                     return v2.getKey().compareTo(v1.getKey());
                     else return v1.getValue() - v1.getValue();
                 }
         );
         PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                 new Comparator<Map.Entry<String, Integer>>() {
                     //重写方法
                     @Override
                     public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                         if (o1.getValue().compareTo(o2.getValue()) == 0) {
                             return o2.getKey().compareTo(o1.getKey());// 根据key变成大根堆
                         }
                         return o1.getValue().compareTo(o2.getValue());
                     }
                 });
     }
    //归并
    public static void mergeSort(int[] array,int left,int right){

        if(left>=right) return;
        int mid = (left+right)/2;

        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);

        int[] tmp = new int[right-left+1];

        int cur1 = left,cur2 = mid+1,i = 0;
        while(cur1<=mid && cur2<=right)
            tmp[i++] = array[cur1]<=array[cur2]?array[cur1++]: array[cur2++];

        //将剩余插入进数组
        while(cur1<=mid) tmp[i++] = array[cur1++];
        while(cur2<=right) tmp[i++] = array[cur2++];

        for(int k = left;k<=right;k++){
            array[i] = tmp[k-left];
        }
    }
     public static void  MYquickSort(int[] array,int l,int r){
         if(l>=r) return;
         //使其不断的趋近于有序
         int keyNumber = array[new Random().nextInt(r-l+1)+1];
         int left = l+1,right = r+1,i = l;
         while(i<right){
             if(array[i]<keyNumber){
                 swap(array,++left,i++);
             }else if(array[i]>keyNumber){
                 swap(array,-right,i);
             }else{
                 i++;
             }
         }
         //不断地进行递归
         MYquickSort(array,l,right);
         MYquickSort(array,right,r);
     }
     public static void  swap(int[] array,int index1,int index2){
         int tmp = array[index1];
         array[index1] = array[index2];
         array[index2] = tmp;
     }

    public static void main(String[] args) {
       demo demo1 = new demo();
       char[][] chars = new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}};

        System.out.println(demo1.nearestExit(chars, new int[]{1, 0}));
    }
    public static void main1(String[] args) {
//        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(
//                (v1, v2) -> {
//                    return v1-v1;
//                });
//        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(
//                (v1,v2)->{
//                    return v2-v1;
//                }
//
//        );
    }
}
