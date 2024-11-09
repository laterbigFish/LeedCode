package Sort;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.tree.TreeNode;
import java.util.*;

public class FactorialSum {

    private List<List<Integer>> ret = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();
    private boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        check = new boolean[nums.length];
        dfs(nums);
      return ret;
    }
    private void dfs(int[] nums) {
         if(path.size()==nums.length) {
             ret.add(new LinkedList<>(path));
             return;
         }
         for(int i=0;i< nums.length;i++){
             if(check[i]==false){
                 path.add(nums[i]);
                 check[i] = true;
                 dfs(nums);
                 check[i] = false;
                 path.removeLast();
             }
         }
    }
//    List<Integer> list = new LinkedList<>();
//    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//    public int kthSmallest(TreeNode root, int k) {
//        selectTreeNode(root,k);
//        int size = priorityQueue.size();
//        selectTreeNode(root,k);
//        return priorityQueue.poll();
//    }

    private void selectTreeNode(TreeNode root,int k) {
        if(root==null) return;
    }

    private List<Integer> list = new LinkedList<>();
    private Long a = Long.MIN_VALUE;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(String cur:wordDict){
            hashMap.put(cur,hashMap.getOrDefault(cur,0)+1);
        }
        for(int i=0;i<s.length();i++){
            stringBuilder.append(s.charAt(i));
            if(hashMap.getOrDefault(stringBuilder.toString(),0)!=0){
                stringBuilder.delete(0,stringBuilder.length()-1);
            }
        }
        if(stringBuilder.isEmpty()) return true;
        return false;
    }
    //三角回文数
    public  static boolean circle(int n){
          int number = 0;
        for(int  k=0;k<=n;k++){
            int tmp = k*((k+1)/2);
            number+=k;
            if(number==tmp){
                return true;
            }
        }
        return false;
    }
    public  static int maxSubarraySumCircular(int[] nums) {
        int[] f = new int[nums.length + 1], g = new int[nums.length + 1];    
//        g[0] = Integer.MAX_VALUE%10;
        int maxRet = Integer.MIN_VALUE;
        int minRet = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum+=nums[i-1];
            f[i] = Math.max(nums[i - 1], f[i - 1] + nums[i - 1]);
            g[i] = Math.min(nums[i - 1], g[i - 1] + nums[i - 1]);
             maxRet = Math.max(maxRet, f[i]);
            minRet = Math.min(minRet, g[i]);
        }
        return sum==minRet?maxRet:Math.max(maxRet,sum-minRet);
    }
    public  static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i-1], dp[i - 1] + nums[i-1]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
//    public double myPow(double x,int n) {
//        int ret  = n>0?1:-1;
//        if (n == 0)
//            return 1;
//        double tmp = myPow(x, n / 2);
//        if (n % 2 == 1)
//            return tmp * tmp * x*ret;
//        return tmp * tmp*ret;
//    }
//    public static int a;
//    {
//        System.out.println("实例代码块");
//    }
//    static{
//        System.out.println("静态代码块");
//        a = 10;
//    }
public static void main(String[] args) {
    System.out.println(0^3);

    }
    public static void main4(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
         StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.append(3);
        stringBuilder.append(4);
        stringBuilder.append(5);
        for(int i=0;i<stringBuilder.length();i++){
            stringBuilder1.append(stringBuilder.charAt(i));
            if(i<stringBuilder.length()-1)  stringBuilder1.append("->");
        }
        System.out.println(stringBuilder1);

        String s = new String();

    }
    public static void main2(String[] args) {
       PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            int input = scanner.nextInt();
            if(priorityQueue.size()<4){
                priorityQueue.offer(input);
            }else{
                if(input<priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(input);
                }
            }
        }
    }
    public static void main1(String[] args) {

        //        System.out.println(circle(66066));
//        int firstNumber = 1;
//        while(true){
//             int temp = firstNumber,cur = 0;
//             while(temp!=0){
//                 cur = cur*10+temp%10;
//                 temp/=10;
//             }
//             boolean f1 = circle(firstNumber++);
//             boolean f2 = circle(cur);
//             if(f1 && f2 && firstNumber>20220514){
//                 System.out.println(firstNumber);
//                 break;
//             }
//        }
//        int k = 20220514;
//        int tmp = k*((k+1)/2);

        //        int[] array = {5,-3,5};
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()){
//            int input = scanner.nextInt();
//        }
//        System.out.println(maxSubarraySumCircular(array));
//        FactorialSum factorialSum = new FactorialSum();
//        System.out.println(factorialSum);
////            局部代码块
//        {
//
//        }
    }
//    public static void main(String[] args) {
//        int x,y=10;
//        if(((x=0)==0)||((y=20)==20))
//        {   System.out.println("现在y的值是:"+y);
//        }
//        int a,b=10;
//        if(((a=0)==0)|((b=20)==20))
//        {   System.out.println("现在b的值是:"+b);
//        }
//        System.out.println((11+3*8)/4%3);
//
//
////        double sum = 0.0;
////
////        // 计算从0到5的阶乘和对应项的和
////        for (int i = 0; i <= 5; i++) {
////            sum += 1.0 / factorial(i);
////        }
////
////        System.out.printf("Sum: %.5f%n", sum);
//    }
//
//    // 计算n!的阶乘
//    private static long factorial(int n) {
//        long result = 1;
//        for (int i = 2; i <= n; i++) {
//            result *= i;
//        }
//        return result;
//    }
}
