package LeedCode;

import java.util.*;
class Person{
    public static  int age = 100;
}
public class demo1 {
    private List<List<String>> list = new LinkedList<>();
    private char[][] path;
    private int N;
    private boolean[] col, dig1, dig2;

    public List<List<String>> solveNQueens(int n) {
        path = new char[n][n];
        N = n;
        col = new boolean[n];
        dig1 = new boolean[n * 2];
        dig2 = new boolean[n * 2];

        // 将所有的path中的值设置为‘.’
        for (char[] cur : path)
            Arrays.fill(cur, '.');
        dfs(0);
        return list;
    }

    public void dfs(int row) {
        if (row == N) {
            // 满足条件可以进行插入
            List<String> cur = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                cur.add(new String(path[j]));
            }
            list.add(new LinkedList<>(cur));
            return;
        }

        for (int i = 0; i < N; i++) {
            // 先判断能不能方
            if (dig1[row - i + N] == false && dig2[row + i] == false && col[i] == false) {
                path[row][i] = 'Q';
                dig1[row - i + N] = dig2[row + i] = col[i] == true;
                dfs(row + 1);
                path[row][i] = '.';
                dig1[row - i + N] = dig2[row + i] = col[i] == false;
            }

        }
    }
//    private List<List<String>> list = new LinkedList<>();
//    private char[][] path;
//    private int N;
//    private boolean[] col; //列
//    private boolean[] dig1;//斜率 为 1 的对角线
//    private boolean[] dig2;//斜率 为 -1 的对角线
//
//    public List <List <String>> solveNQueens( int n) {
//        path = new char[n][n];
//        N = n;
//        col = new boolean[n];
//        dig1 = new boolean[n*2];
//        dig2 = new boolean[n*2];
//
//        //将所有的path中的值设置为‘.’
//        for(char[] cur:path)  Arrays.fill ( cur,'.' );
//        dfs(0);
//        return list;
//    }
//
//    public void dfs(int index){
//          if(index==N){
//              //满足条件可以进行插入
//              for(int j=0;j<4;j++){
//                  //需要不断地进行头插才能满足条件
//                  List<String> cur = new LinkedList <> ();
//                  cur.add ( Arrays.toString ( path[j] ) );
//                  list.addFirst ( cur );
//              }
//          }
//        for(int i=0;i<N;i++){
//            path[index][i] = 'Q';
//            //将所有不能添加的位置设置好
//            col[i] = true; //该列已经有了皇后
//            dig1[index-i+N] = true;
//            dig2[i+index] = true;
//            dfs ( index+1 );
//            //恢复现场
//            path[index][i] = '.';
//            col[i] = false;
//            dig1[index-i+N] = false;
//            dig2[i+index] = false;
//        }
//    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]  ans = new int[numCourses];
        int index = 0;
        int[] n = new int[numCourses];
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        // 建图
        for (int[] cur : prerequisites) {
            int To = cur[0], start = cur[1];
            if (!edges.containsKey(start)) {
                edges.put(start, new LinkedList<>());
            }
            edges.get(start).add(To);
            n[To]++;
        }
        // 在图中进行拓扑排序
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (n[i] == 0)
                deque.offer(i);
        }
        // 进行BFS

        while (!deque.isEmpty()) {
            Integer poll = deque.poll();
            ans[index++] = poll;
            for (Integer cur : edges.getOrDefault(poll, new LinkedList<>())) {
                n[cur]--;
                if (n[cur] == 0)
                    deque.offer(cur);
            }
        }
        // 判断是否有环
        for (int i = 0; i < numCourses; i++) {
            if (n[i] > 0)
                return null;
        }
      return ans;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] n = new int[numCourses];
        HashMap<Integer,List<Integer>> edges = new HashMap <> ();
        //建图
        for(int[] cur:prerequisites){
            int To = cur[0],start = cur[1];
            if(!edges.containsKey ( start )){
                edges.put ( start,new LinkedList <> () );
            }
           edges.get ( start ).add ( To );
            n[To]++;
        }
        //在图中进行拓扑排序
        Deque<Integer> deque = new LinkedList <> ();

        for(int i=0;i<numCourses;i++){
            if(n[i]==0) deque.offer ( i );
        }
       //进行BFS

       while(!deque.isEmpty ()){
           Integer poll=deque.poll ();
           for(Integer cur:edges.getOrDefault ( poll,new LinkedList <> ())){
               n[cur]--;
               if(n[cur]==0) deque.offer(cur);
           }
       }
        //判断是否有环
        for(int i=0;i<numCourses;i++){
            if(n[i]>0) return false;
        }
        return true;
    }
//    private final int[] dx = { 1, -1, 0, 0 };
//    private final int[] dy = { 0, 0, 1, -1 };
//
//    public int maxDistance(int[][] grid) {
//        int n = grid.length;
//        // 寻找距离 1 最远的 0
//        Deque<int[]> deque = new LinkedList<>();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    deque.offer(new int[] { i, j });
//                    grid[i][j] = -1;
//                }
//            }
//        }
//
//        int ans = -1;
//        while (!deque.isEmpty()) {
//            int[] t = deque.poll();
//            int a = t[0], b = t[1];
//            for (int i = 0; i < 4; i++) {
//                int x = a + dx[i], y = b + dy[i];
//                if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
//                    grid[x][y] = grid[a][b] + 1;
//                    ans = Math.max(grid[x][y], ans);
//                    deque.offer(new int[] { x, y });
//                }
//            }
//        }
//        return ans;
//    }
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int v = 0; v < t; v++) {
            int a = sc.nextInt(), b = sc.nextInt();
            int gcd1 = 0;

            for (int i = 0; i < a; i++) gcd1 = gcd(gcd1, sc.nextInt());

            int gcd2 = 0;
            for (int i = 0; i < b; i++) gcd2 = gcd(gcd2, sc.nextInt());
            System.out.println(gcd2 % gcd1 == 0 ? "YES" : "NO");
        }
    }
   //求最大公约数

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
public static void main5(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
        int n = scan.nextInt();
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++)  list.add(scan.nextInt());
        Collections.sort(list);
        int sum1 = 0,sum2 = 0;
        //每次都取最大的
        boolean flag = true;
        while(!list.isEmpty()) {
            Collections.sort(list);
            if(flag) {
                // 诸葛亮
                sum1+=list.remove(list.size()-1);
                flag = false;
            }else {
                //阿满
                sum2+= list.remove(list.size()-1)*(-1);
                flag = true;
            }
        }
        System.out.print(sum1-sum2);
    }
    scan.close();
}
public static void main4 ( String[] args ) {
    List<Integer> list = new LinkedList <> ();
    Collections.sort ( list );
}
    public static void main3(String[] args) {
        List<Integer>[] lists = new List[100];
       PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
       for(List<Integer> cur:lists){
           if(cur!=null){
               priorityQueue.offer(cur.getFirst());

           }
       }
    }
    public static void main2(String[] args) {
        List<Integer> list1 = new ArrayList<>(2);
        List<Integer> list2 = new ArrayList<>(6);
        List<Integer> list3 = new ArrayList<>(1);
        List<Integer> list4 = new ArrayList<>(0);
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(list1);
        priorityQueue.offer(list2);
        priorityQueue.offer(list3);
        priorityQueue.offer(list4);
        for(List<Integer> cur: priorityQueue){
        }
    }
    public static void main1(String[] args) {
         List<Integer> list = new ArrayList<>();
        List<Integer>[] lists = new List[100];
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>();
        for(int i=0;i< lists.length;i++){
            while(lists[i].getFirst()!=null){
                priorityQueue.offer(lists[i]);
            }
        }
    }
}
