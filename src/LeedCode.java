import org.w3c.dom.ls.LSOutput;

import javax.xml.stream.events.Characters;
import java.util.*;
public class LeedCode {
    private int ret;

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> vis = new HashSet<>();
        HashSet<String> hash = new HashSet<>();
        for (String cur : bank)
            hash.add(cur);
        Deque<String> deque = new LinkedList<>();
        char[] arr = { 'A', 'C', 'G', 'T' };
        if (startGene.equals(endGene))
            return ret;
        if (!hash.contains(endGene))
            return -1;

        deque.offer(startGene);
        vis.add(startGene);

        while (!deque.isEmpty()) {
            ret++;
            int sz = deque.size();
            while (sz-- != 0) {
                String t = deque.poll();
                for (int i = 0; i < 8; i++) {
                    char[] cur = t.toCharArray();
                    for (int j = 0; j < 4; j++) {
                        cur[i] = arr[j];
                        String next = new String (cur);
                        if (hash.contains(next) && !vis.contains(next)) {
                            if (next.equals(endGene)) return ret;
                            deque.add(next);
                            vis.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
//    private  int ret;
//    public int minMutation(String startGene, String endGene, String[] bank) {
//     HashMap<String,Integer> hashMap = new HashMap <> ();
//
//     Deque<String> deque = new LinkedList <> ();
//     hashMap.put ( startGene,hashMap.getOrDefault ( startGene,0 ) +1 );
//     HashMap<String,Integer> Bank = new HashMap<>();
//
//        for(String cur:bank) Bank.put ( cur,Bank.getOrDefault ( cur ,0) + 1);
//
//        deque.offer ( startGene );
//        while(!deque.isEmpty ()) {
//            //进入一次变换一次
//            ret++;
//            for (int i=0; i < startGene.length (); i++) {
//                StringBuilder stringBuilder = new StringBuilder ( Arrays.toString ( deque.poll ().toCharArray () ) );
//                stringBuilder.deleteCharAt ( i );
//                stringBuilder.insert ( i,'A' );
//                if(hashMap.getOrDefault ( stringBuilder.toString (),0 )==0){
//                    hashMap.getOrDefault ( stringBuilder.toString (),1 );
//                     //判断是否是最终结果
//                    if(stringBuilder.toString ().equals ( endGene )) return ret;
//                    if(Bank.containsKey ( stringBuilder.toString () )) deque.offer ( stringBuilder.toString () );
//
//                }
//
//
//            }
//
//        }
//     return ret;
//    }
//    private boolean[] vision;
//    private int ret;
//
//    public int countArrangement(int n) {
//
//        vision = new boolean[n + 1];
//        dfs(1, n);
//
//        return ret;
//
//    }
//
//    public void dfs(int index, int n) {
//        if (index == n + 1) {
//            ret++;
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (!vision[i] && (i % index == 0 || index % i == 0)) {
//                vision[i] = true;
//                dfs(i + 1, n);
//                vision[i] = false;
//            }
//        }
//    }
//    private boolean vision;
//    private int ret;
//
//    public int countArrangement(int n) {
//        vision = new Boolean ( n );
//        dfs(1, n);
//        return ret;
//    }
//
//    public void dfs(int index, int n) {
//        if (index == n + 1) {
//            ret++;
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (vision[i] == false && (i % index == 0 || index % i == 0)) {
//                vision[i] = true;
//                dfs(i + 1, n);
//                vision[i] = false;
//            }
//        }
//    }
    private List<String> ans = new LinkedList<>();

    public List<String> letterCasePermutation(String s) {
     NoException noException = new NoException ();
        dfs(s.toCharArray(), 0);
        return ans;
    }

    private void dfs(char[] charArray, int index) {
        while (index < charArray.length && Character.isDigit(charArray[index])) {
             index++;
        }
        if (index == charArray.length) {
            ans.add(new String(charArray));
            return;
        }
        charArray[index] ^= 32;
        dfs(charArray, index + 1);
        charArray[index] ^= 32;
        dfs(charArray, index + 1);
    }


//    private List<List<Integer>> ret = new LinkedList<>();
//    private List<Integer> path = new LinkedList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        dfs(candidates, target, 0);
//        return ret;
//    }
//
//    public void dfs(int[] candidates, int target, int index) {
//        if (index == candidates.length)
//            return;
//        if (target == 0) {
//            ret.add(new LinkedList<>(path));
//            return;
//        }
//        // 直接跳过
//        dfs(candidates, target, index + 1);
//        // 选择这个数这个数
//        if (target - candidates[index] >= 0) {
//            path.add(candidates[index]);
//            dfs(candidates, target - candidates[index], index);
//            path.removeLast();
//        }
//
//    }
//    private int ret = 0;
//    private int num = 0;
//    public List<List<Integer>> ret = new LinkedList<>();
//    public List<Integer> path = new LinkedList<>();
//    public int findTargetSumWays(int[] nums, int target) {
//        dfs(nums, 0,target);
//        return ret;
//    }
//
//    public void dfs(int[] nums, int index,int target) {
//        if (index == nums.length && num == target) {
//                ret++;
//        }else{
//            if(index<nums.length){
//                num += nums[index];
//                dfs(nums, index + 1,target);
//
//                num -= nums[index];
//                dfs(nums, index + 1,target);
//            }
//        }
//
//    }

//    public List<List<Integer>> combine(int n, int k) {
//        int[] t = new int[n];
//        dfs(t,k);
//        return ret;
//    }
//    public void dfs(int[] t,int k){
//        //含K个元素的组合
//        path.
//        if(path.size()==k){
//            ret.add(new LinkedList<>(path));
//            return;
//        }
//        for(int i=0;i<t.length;i++){
//            path.add(t[i]);
//            dfs(t,k);
//            path.removeLast();
//        }
//    }
    public  static int findSubstringInWraproundString(String s) {
        int[] dp = new int[s.length()];
        int[] cur = new int[26];
        for (int i = 0; i < s.length(); i++) dp[i] = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1)+1 == s.charAt(i) || s.charAt(i-1)=='z' && s.charAt(i)=='a' )  dp[i]+= dp[i-1];
            cur[s.charAt(i)-'a'] = Math.max(cur[s.charAt(i)-'a'],dp[i]);
        }
        cur[s.charAt(0)-'a'] = cur[s.charAt(0)-'a']>=1?cur[s.charAt(0)-'a']:1;
        int ans = 0;
        for(int i=0;i<cur.length;i++){
            ans+=cur[i];
        }
        return ans;
    }
    public String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];
        for(int i=0;i<nums.length;i++) temp[i] = ""+ nums[i];

        Arrays.sort(temp,(a,b)->{

            return (b+a).compareTo(a+b);
        });
        //统计结果
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            stringBuilder.append(temp[i]);
        }
        if(temp[0].charAt(0)=='0') return "0";
        return stringBuilder.toString();
    }
    public  static void mergeSort2(int[] nums, int left, int right) {
       if(left>=right) return;
       int mid = (right+left)/2;
       mergeSort2(nums,left,mid);
       mergeSort2(nums,mid+1,right);

       int[] temp = new int[right-left+1];
       int cur1 = left,cur2 = mid+1,i = 0;
       while(cur1<=mid && cur2<=right){
           temp[i++] = nums[cur1]<=nums[cur2]?nums[cur1++]:nums[cur2++];
       }
       //解决剩余的一些问题
        while(cur1<=mid) temp[i++] = nums[cur1++];
        while(cur2<=right) temp[i++] = nums[cur2++];

        //将临时数组中的数添加到原数组
        for(int k = left;k<=right;k++){
            nums[k] = temp[k-left];
        }
    }
    public  static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        int cur1 = left, cur2 = mid + 1, i = 0;

        while (cur1 <= mid && cur2 <= right) {
            tmp[i++] = nums[cur1] <= nums[cur2] ? nums[cur1++] : nums[cur2++];
        }
        while (cur1 <= mid)
            tmp[i++] = nums[cur1++];

        while (cur2 <= right)
            tmp[i++] = nums[cur2++];

        for (int k = left; k <= right; k++) {
            nums[k] = tmp[k - left];
        }
    }

    public static void main(String[] args) {
         LeedCode leedCode = new LeedCode();
         String str = "a1b2";
    }
}
