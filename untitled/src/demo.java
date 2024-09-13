import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class demo {
    //先增后减
    public int peakIndexInMountainArray(int[] arr) {

    }
    public  static int searchInsert(int[] nums, int target) {

        int left = 0,right = nums.length;
        while(left<right){
            int mid = left+(right-left+1)/2;

            if(nums[mid]<=target) left = mid;
            else right = mid-1;
        }
        if(nums[left]==target) return left;
        else return left+1;
    }
    public static int mySqrt(int x) {
        if(x<1) return 0;
        long left = 1,right = x;

        while(left<right){
            long  mid = left +(right-left+1)/2;
            if(mid*mid<=x) left = mid;
            else right = mid-1;
        }

        return(int) left;
    }
    //查找元素的第一个和最后一个位置  必须采用nlogN的方式
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        if(nums.length==0) return ret;
        //查找左端点
        //左端点
        int left = 0,right = nums.length-1;
        while (left<right){
            int Mid = left +(right-left)/2;
            if(nums[Mid]<target) left = Mid+1;
            else    right = Mid;
        }
        if(nums[left]==target)  ret[0] = left;
        //右端点
        int left1 = 0,right1 = nums.length-1;

        while(left1<right1){
            //避免陷入死循环
            int mid = left1+(right1-left1+1)/2;
            if(nums[mid]<=target) left1 = mid;
            else right1 = mid-1;
         }
        if(nums[right1]==target) ret[1] = right1;
        return ret;
    }
    //最小覆盖子串
        public String minWindow(String s, String t){
            char[] ss = t.toCharArray();
            char[] tt = s.toCharArray();
            int[] hash1 = new int[128];
            int[] hash2 = new int[128];
            int kinds = 0;
            int minLength = Integer.MAX_VALUE,begin = -1;
            for(char cur: tt)  if(hash1[cur]++==0)
                kinds++;
            for(int left = 0,right=0,count=0;right<s.length();right++){
                if(++hash2[ss[right]]==hash1[ss[right]]) count++; //进窗口和维护count

                while(kinds==count) {
                    if(right-left+1<minLength) {
                        begin = left;
                        minLength = right-left+1;
                    }

                    char out = ss[left++];
                    if(hash2[out]--==hash1[out]) count--;
                }

            }
            if(begin==-1) return "";
            else  return s.substring(begin,begin+minLength);
    }
    public String minWindow2(String s, String t){
        String ret = "";
        HashMap<Character,Integer> hashMap1 = new HashMap<>();
        HashMap<Character,Integer> hashMap2 = new HashMap<>();
        char[] array1 = t.toCharArray();
        char[] array2 = s.toCharArray();
        for(char cur:array1){
            hashMap1.put(cur,hashMap1.getOrDefault(cur,0)+1);
        }

        for(int left = 0,right = 0,count = 0;right<s.length();right++){
            char in = array2[right];
            hashMap2.put(in,hashMap2.getOrDefault(in,0)+1);

            if(hashMap2.get(in)==hashMap1.getOrDefault(in,0)) count++;

                //此时满足条件 更新ret
            char out = array2[left];
                 if(hashMap2.get(out)==hashMap1.getOrDefault(out,0)) count--;

                 hashMap2.put(out,hashMap2.getOrDefault(out,0)-1);
              if(count==hashMap1.size()) ret = s.substring(left,right-left+1);

              left++;
        }
        return ret;
    }
     public String minWindow1(String s, String t)
     {
         String ret = "";
         HashMap<Character,Integer> hashMap1 = new HashMap<>();
         HashMap<Character,Integer> hashMap2 = new HashMap<>();
         char[] array1 = t.toCharArray();
         char[] array2 = s.toCharArray();
         for(char cur:array1){
             hashMap1.put(cur,hashMap1.getOrDefault(cur,0)+1);
         }
         for(int left = 0,right = 0;right<s.length();right++){
              //进入
               hashMap2.put(array2[right],hashMap2.getOrDefault(array2[right],0)+1);
               //合法的时候出窗口  如何判断合法条件
             while(Check(hashMap1,hashMap2,array1)){
                 //先进性更新ret
                 ret = s.substring(left,right);
                 //更新left
                 hashMap2.put(array2[left],hashMap2.get(left)-1);
                 left++;
             }
         }

         return ret;
    }

    private boolean Check(HashMap<Character, Integer> hashMap1, HashMap<Character, Integer> hashMap2, char[] array1) {

        for(int i=0;i<array1.length;i++){
            if(!hashMap2.containsKey(array1[i])) return false;
        }
        return true;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        HashMap<String,Integer> hashMap1 = new HashMap<>();
        for(String cur:words){
            hashMap1.put(cur,hashMap1.getOrDefault(cur,0)+1);
        }
        for(int i=0;i<words[0].length();i++){
            HashMap<String,Integer> hashMap2 = new HashMap<>();
             for(int left = i,right = i,count = 0;right+words[0].length()<=s.length();right+=words[0].length()){
               String in = s.substring(right,right+words[0].length());
               hashMap2.put(in,hashMap2.getOrDefault(in,0)+1);
               //进入
               if(hashMap2.get(in)<=hashMap1.getOrDefault(in,0)) count++;
               //判断
               if(right-left+1>words.length*words[0].length()){
                   //出窗口加维护窗口
                   String out = s.substring(left,left+words[0].length());
                   if(hashMap2.get(out)<=hashMap1.getOrDefault(out,0)) count--;
                   hashMap2.put(out, hashMap2.get(out)-1);
                   left+=words[0].length();
               }
               if(count==words.length) ret.add(left);
           }
        }
        return ret;
    }
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        for(String cur:words){
            List<Integer> list = findAnagrams(s,cur);
            for(Integer cur1:list){
                ret.add(cur1);
            }
        }
        return ret;
    }
    public  static List<Integer> findAnagrams2(String s, String p){
        List<Integer> ret = new ArrayList<>();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(char cur: pp){
            hash1[cur-'a']++;
        }
        for(int left=0,right =0,count = 0;right<s.length();right++){
            if(++hash2[ss[right]-'a']<=pp[ss[right]-'a']) count++;
            if(right-left+1>p.length()) {
                //出窗口
                if(hash2[ss[left]-'a']--<=hash1[ss[left]-'a']) count--;
                left++;
            }
            if(count==p.length()) ret.add(left);
        }
        return ret;
    }
    //找到字符串中所有的的异位符
    public  static List<Integer> findAnagrams(String s, String p){
        List<Integer> ret = new ArrayList<>();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(char cur: pp){
            hash1[cur-'a']++;
        }
        //利用count判断是否满足条件
        for(int left=0,right =0,count = 0;right<s.length();right++){
               if(++hash2[ss[right]-'a']<=pp[ss[right]-'a']) count++;
               if(right-left+1>p.length()) {
                   //出窗口
                   if(hash2[ss[left]-'a']--<=hash1[ss[left]-'a']) count--;
                   left++;
               }
            if(count==p.length()) ret.add(left);
        }
        return ret;
    }
    public  static List<Integer> findAnagrams1(String s, String p) {
        char[] array1 = p.toCharArray();
        char[] array2 = s.toCharArray();
        List<Integer> list = new LinkedList<>();
        int[] hash1 = new int[26],hash2 = new int[26];
        for(int i=0;i<p.length();i++){
            hash1[array1[i]-97]++;
        }
        for(int left = 0,rigth=0;rigth<s.length();rigth++){
              hash2[array2[rigth]-97]++;
             if(rigth-left+1==p.length()){
                //开始进行两个哈希表的比较
                 boolean  flag = FindIndex(hash1,hash2);
                 if(flag)  list.add(left);
                 //更新结果
              hash2[array2[left++]-97]--;
             }
        }
        return list;
    }
    private static boolean FindIndex(int[] hash1, int[] hash2) {
         //比较两种哈希表内是否相同
        for(int i=0;i<hash1.length;i++){
            if(hash1[i]!=hash2[i]) return false;
        }
        return true;
    }


    /*
    * 1 <= fruits.length <= 105
      0 <= fruits[i] < fruits.length
    * */
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ret = 0;
        for(int left = 0,right = 0;right<fruits.length;right++) {
            int in = fruits[right];
            map.put(in, map.getOrDefault(in, 0) + 1); //查找是否有这个值
            while (map.size() > 2) {
                int out = fruits[left];
                map.put(out, map.get(out) - 1);//查找是否有这个值
                if (map.get(out) == 0) {
                    map.remove(out);
                }
                left++;
            }
            //更新数据
            ret = Math.max(ret,right-left+1);
        }
     return ret;
    }
    //将零减到一的最小操作 ,每次移除最左或最右的数
    public int minOperations(int[] nums, int x) {
        //滑动窗口
        int ret = -1,num1 = 0;
        for(int cur:nums){
            num1+=cur;
        }
        int targer = num1-x;
        if(targer<0) return -1;
        for(int left = 0,right = 0,sum = 0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>targer) sum-=nums[left++];
            if(sum==targer){
                ret = Math.max(ret,right-left+1);
            }
        }
        if(ret==-1){
            return -1;
        }else return nums.length-ret;
    }
    public int longestOnes(int[] nums, int k) {
        //可以翻转K个0为1
        int MaxCount = 0;
        for(int left = 0,right = 0, zero = 0;right<nums.length;right++){
              if(nums[right]==0) zero++;
              while(zero>k){
                  if(nums[left++]==0) zero--;
              }
            MaxCount = Math.max(MaxCount,right-left+1);//更新结果
        }
        return MaxCount;
    }
    //最大连续一的个数
    public int findMaxConsecutiveOnes(int[] nums) {
         int count = 0,man = 0;
         for(int i=0;i<nums.length;i++){
             if(nums[i]==1){
                 count++;
             }else{
                 man = Math.max(count,man);
                 count = 0;
             }
         }
         return man;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        System.out.println(searchInsert(array, 7));
    }
    public static void main8(String[] args) {

        String[] words = {"foo","bar"};

        String s = "barfoothefoobarman";
        System.out.println(findSubstring(s, words));
    }
    public static void main7(String[] args) {
      String s = "cbaebabacd";
      String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static void main1(String[] args) {
      HashMap<Integer,Integer> hashMap = new HashMap<>();
      hashMap.put(1,1);
      hashMap.put(1,2);
        System.out.println(hashMap.get(1));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,2); //新的键 值将会替代原有的值

        System.out.println(map.get(1));
    }
}
