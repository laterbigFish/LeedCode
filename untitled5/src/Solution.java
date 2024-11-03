import java.math.BigDecimal;
import  java.util.*;
class Solution {
    //无进位相加 最后在进行进位
    public  static  String multiply(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty()) return "";
        int[] ans = new int[num1.length()+num2.length()-1];
        //先将两个字符串进行导致
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
         for(int i=0;i<num1.length();i++){
             for (int j = 0; j < num2.length(); j++) {
                 ans[i+j]+= Integer.valueOf(num1.charAt(i)-'0')*Integer.valueOf(num2.charAt(j)-'0');
             }
         }
        String ret = func(ans);
        return ret;
    }
    private  static String func(int[] ans) {
        //倒置运算
        StringBuilder stringBuilder = new StringBuilder();
          int t =0;
        for(int i=0;i<ans.length;i++){
           t+=ans[i];
           stringBuilder.insert(0,t%10);
           t/=10;
        }

        if(t!=0) stringBuilder.insert(0,t%10);
        if(stringBuilder.length()==1 &&stringBuilder.charAt(0)=='0') return stringBuilder.toString();

        //此时如果t还有剩余
        while(true){
            if(!stringBuilder.isEmpty()&& stringBuilder.charAt(0)=='0'){
                stringBuilder.deleteCharAt(0);
            }else{
                break;
            }
        }
        if(stringBuilder.isEmpty()) return"0";
        return stringBuilder.toString();
    }

    public static  String removeDuplicates(String s) {
     StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(stringBuilder.length()==0){
                stringBuilder.append(s.charAt(i));
            }else{
                if(s.charAt(i)!=stringBuilder.charAt(stringBuilder.length()-1)){
                    stringBuilder.append(s.charAt(i));
                }else{
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            }
        }
     return stringBuilder.toString();
    }
    public  static String multiply3(String num1, String num2){
        BigDecimal bigDecimal = new BigDecimal(num1);
        BigDecimal bigDecimal1 = new BigDecimal(num2);
        BigDecimal ans = bigDecimal1.multiply(bigDecimal);
        return ans.toString();
    }
    public  static String multiply1(String num1, String num2) {
        int length_num1 = num1.length()-1,length_num2 = num2.length()-1;
        StringBuilder stringBuilder  = new StringBuilder();
        int cur = 0;
        while(true){
          if(length_num1<0 && length_num2<0){
              break;
          }else if(length_num1<0){
              cur+=num1.charAt(length_num2--)-'0';
          }else if(length_num2<0){
              cur+=num1.charAt(length_num1--)-'0';
          }else{
              cur+=(num1.charAt(length_num1--)-'0')*(num2.charAt(length_num2--)-'0');
          }
           stringBuilder.insert(0,cur%10);
          cur/=10;
        }
        if(cur!=0) stringBuilder.insert(0,cur);
        return stringBuilder.toString();
    }
    //模拟列数
    public static  String addBinary(String a, String b) {
        int length_a = a.length()-1,length_b = b.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        int cur = 0;
        while(true) {
            if(length_a<0 &&length_b<0){
                break;
            }else if(length_a<0){
                cur+=b.charAt(length_b--)-'0';
            }else if(length_b<0){
                cur+=a.charAt(length_a--)-'0';
            }else{
                cur+=(a.charAt(length_a--)-'0')+(b.charAt(length_b--)-'0');
            }
            stringBuilder.insert(0,cur%2);

            cur/=2;
        }

        if(cur==1)  stringBuilder.insert(0,cur%2);
        return stringBuilder.toString();
    }
    public static  String longestPalindrome(String s) {
      int bgein = 0,len = 0;
      for(int i=0;i<s.length();i++){
         int left = i,right = i;

         while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
             right++;
             left--;
         }
         if(right-left-1>len){
             bgein = left+1;
             len = right-left-1;
         }
         //拓展偶数长度
          left = i;
         right = i+1;
          while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
              right++;
              left--;
          }
          if(right-left-1>len){
              bgein = left+1;
              len = right-left-1;
          }
      }
      return s.substring(bgein,len+bgein);
    }
    public  static String longestPalindrome3(String str) {
         if(str==null || str.length()<1) return "";
         String ans = "";
         for(int i=0;i<str.length();i++){
             int left = i,right = i;
             if(str.charAt(i+1) == str.charAt(i)) right++;
             while(left>=0 && right<=str.length()-1){
                 if(str.charAt(left)==str.charAt(right)){
                     left--;
                     right++;
                 }else {
                     break;
                 }
             }
             if(right-left-1>ans.length()){
                 ans = str.substring(left+1,right-1+1);
             }
         }
         return ans;
    }
     //最长回文子串
    public String longestPalindrome1(String s) {
        if(s.length()==0) return null;
        char[] tmp = s.toCharArray();
        String[] dp = new String[s.length()];
        //以第i个为结尾的最大回文子串
        for(int i=0;i<s.length();i++){

        }
        int index = -1;
        for(String cur: dp){
            index= cur.length()>index?cur.length():index;
        }
        return dp[index];
    }
    //查找回文子串
//    public String  func(String str){
//        if(str==null ||str.length()<1) return"";
//
//
//    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for(String cur:strs){
            min = min>cur.length()?cur.length():min;
        }
        for(int i=0;i<min;i++){
            Boolean flag = true;
            char tmp = strs[0].charAt(i);
            for(String  cur:strs){
                if(cur.charAt(i)!=tmp) flag = false;
            }
            if(flag){
                stringBuilder.append(tmp);
            }else{
                break;
            }
        }
        String ans = stringBuilder.toString();
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();
      for(String cur:strs){
          char[] tmp = cur.toCharArray();
          Arrays.sort(tmp);
          String key = new String(tmp);
          if(!hashMap.containsKey(key)){
              hashMap.put(key,new ArrayList<>());
          }
          hashMap.get(key).add(cur);
      }
      //将哈希表中的元素放入ans
        return  new ArrayList(hashMap.values());
    }
    public  static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                if(Math.abs(i-hashMap.get(nums[i]))<=k) return true;
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }
    public  static  boolean CheckPermutation(String str1, String str2) {
        if(str1.length()!=str2.length()) return false;

        char[] cur1 =str1.toCharArray();
        char[] cur2  = str2.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char cur:cur1){
            hashMap.put(cur,hashMap.getOrDefault(cur,0)+1);
        }
        for(char cur:cur2){
            if(hashMap.getOrDefault(cur,0)<=0) return false;
            hashMap.put(cur,hashMap.getOrDefault(cur,0)-1);
        }
        return true;
    }

    public static void main(String[] args) {

        //        System.out.println(multiply("9133", "0"));
    }
    public static void main11(String[] args) {
        BigDecimal bd1 = new BigDecimal("123");
        BigDecimal bd2 = new BigDecimal("456");

        // 乘
        BigDecimal product = bd1.multiply(bd2);
        System.out.println(product.toString());
    }
    public static void main7(String[] args) {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        BigDecimal bigDecimal = new BigDecimal("123");
//        System.out.println(bigDecimal);
//        System.out.println(multiply("123", "2"));
//        String str1 = "11",str2="1";
//        System.out.println(multiply(str1, str2));
//        System.out.println(addBinary(str1, str2));
//      String str = "32131";
//        System.out.println(Integer.valueOf(str.charAt(0)-'0'));
    }
    public static void main5(String[] args) {
        String ret = "123";
        System.out.println(Integer.valueOf(ret));
//        Integer.valueOf()
//        String cur = "aabbccc";
//        System.out.println(longestPalindrome(cur));
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.insert(0,"1");
//        stringBuilder.insert(0,"0");
//        System.out.println(stringBuilder.toString());
    }
//    public int[] tmp;
//    public int sortArray(int[] nums) {
//        tmp = new int[nums.length];
//        int ret = mergeSort(nums, 0, nums.length - 1);
//        return ret;
//    }
//
//    public int mergeSort(int[] nums, int left, int right) {
//        if (left >= right)
//            return 0;
//        int ret = 0;
//        int mid = (left + right) / 2;
//        ret += mergeSort(nums, left, mid);
//        ret += mergeSort(nums, mid + 1, right);
//
//        int cur1 = left, cur2 = mid + 1, i = left;
//
//        while (cur1 <= mid) {
//
//            while (cur2 <= right && nums[cur2]*2L >= nums[cur1]*1L) cur2++;
//            if (cur2 > right)
//                break;
//            ret += right - cur2 + 1;
//            cur1++;
//        }
//        cur1 = left;
//        cur2 = mid + 1;
//        while (cur1 <= mid && cur2 <= right) {
//            if (nums[cur1] >= nums[cur2]) {
//                tmp[i++] = nums[cur1++];
//            } else {
//                tmp[i++] = nums[cur2++];
//            }
//        }
//        while (cur1 <= mid)
//            tmp[i++] = nums[cur1++];
//        while (cur2 <= right)
//            tmp[i++] = nums[cur2++];
//        for (int k = left; k <= right; k++) {
//            nums[k] = tmp[k];
//        }
//        return ret;
//    }
//
//    public int  mergeSort(int[] nums,int left,int right){
//        int ret = 0;
//        if(left>=right) return ret;
//        int mid = (left+right)/2;
//        ret+=mergeSort(nums,left,mid);
//        ret+=mergeSort(nums,mid+1,right);
//        int cur1 = left,cur2 = mid+1,i = 0;
//        int[] tmp = new int[right-left+1];
//
//        while(cur1<=mid && cur2<=right){
//            //此时是逐渐递增的
//            if(nums[cur1]>=nums[cur2]){
//                tmp[i++] = nums[cur1++];
//                if(nums[cur1]>2*nums[cur2]) ret+=right-cur2+1;
//            }else{
//                tmp[i++] = nums[cur2++];
//            }
//        }
//        while(cur1<=mid)
//            tmp[i++] = nums[cur1++];
//        while(cur2<=right)
//            tmp[i++] = nums[cur2++];
//        for(int k =left;k<=right;k++){
//            nums[k] = tmp[k-left];
//        }
//        return ret;
//    }
//    int[] ret;
//    int[] index;
//    int[] tempindex;
//    int[] temp;
//
//    public   List<Integer> countSmaller(int[] nums) {
//        int n = nums.length;
//        ret = new int[n];
//        index = new int[n];
//        tempindex = new int[n];
//        temp = new int[n];
//        for (int i = 0; i < nums.length; i++)
//            index[i] = i;
//        mergeSort(nums, 0, n - 1);
//        List<Integer> ans = new ArrayList<>();
//        for (int cur : ret) {
//            ans.add(cur);
//        }
//        return ans;
//    }
//    private   void mergeSort(int[] nums, int left, int right) {
//        if (left >= right) return;
//
//        int mid = (right + left) / 2;
//
//        mergeSort(nums, left, mid);
//        mergeSort(nums, mid + 1, right);
//
//        int cur1 = left, cur2 = right, i = 0;
//
//        while (cur1 <= mid && cur2 <= right) {
//            if (nums[cur1] <= nums[cur2]) {
//                temp[i] = nums[cur2];
//                tempindex[i++] = index[cur2++];
//            } else {
//                ret[index[cur1]] += right - cur2 + 1;
//                temp[i] = nums[cur1];
//                tempindex[i++] = index[cur1++];
//            }
//        }
//
//        while (cur1 <= mid) {
//            temp[i] = nums[cur1];
//            tempindex[i++] = index[cur1++];
//        }
//        while (cur2 <= right) {
//            temp[i] = nums[cur2];
//            tempindex[i++] = index[cur2++];
//        }
//        for (int k = left; k <= right; k++) {
//            nums[k] = temp[k - left];
//            index[k] = tempindex[k - left];
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] array = {1,9,7,8,5};
//        Solution solution = new Solution();
//        System.out.println(solution.countSmaller(array));
//
//    }
//    int[] ret;
//    int[] index;
//    int[] tempindex;
//    int[] temp;
//    public List<Integer> countSmaller(int[] nums) {
//          int n =nums.length;
//          ret = new int[n];
//          index = new int[n];
//          tempindex = new int[n];
//          temp = new int[n];
//          for(int i=0;i<nums.length;i++) index[i] = i;
//          mergeSort(nums,0,n-1);
//          List<Integer> ans = new ArrayList<>();
//          for(int cur:ret){
//              ans.add(cur);
//          }
//        return ans;
//    }
//    private void mergeSort(int[] nums, int left, int right) {
//        if(left>=right) return;
//
//        int mid = (right+left)/2;
//
//         mergeSort(nums,left,mid);
//         mergeSort(nums,mid+1,right);
//         int cur1 = left,cur2 = right,i =0;
//
//         while(cur1<=mid && cur2<=right){
//             if(nums[cur1]<=nums[cur2]){
//                 temp[i] = nums[cur2];
//                 tempindex[i++] = index[cur2++];
//             }else {
//                 //此时将所需要的值进行插入
//               ret[index[cur2]]+=right-left+1;
//               temp[i] = nums[cur1];
//               tempindex[i++] = index[cur1++];
//             }
//         }
//        while (cur1 <= mid){
//            temp[i] = nums[cur2];
//            tempindex[i++] = index[cur2++];
//        }
//        while (cur2 <= right) {
//            temp[i] = nums[cur1];
//            tempindex[i++] = index[cur1++];
//        }
//        for (int k = left; k <= right; k++) {
//            nums[k] = temp[k - left];
//            index[k] = tempindex[k-left];
//        }
//    }
//
//    private int  mergeSort(int[] nums, int left, int right,int[] curNums) {
//        if(left>=right) return 0 ;
//
//        int mid = (left+right)/2;
//
//        mergeSort(nums,left,mid,curNums);
//
//        mergeSort(nums,mid+1,right,curNums);
//        int[] temp = new int[right-left+1];
//        int[] cur = new int[temp.length-1];
//        int cur1 = left,cur2 = right,i =0;
//        //如果进行了操作那么就需要将下标一一对应
//        while(cur1<=mid && cur2<=right){
//            if(nums[cur1]<=nums[cur2]){
//             temp[i++] = nums[cur2++];
//            }else if(nums[cur1]>=nums[cur2]){
//             //此时进行加的操作
//                ans.add()
//            }
//        }
//        while(cur1<=mid) temp[i++] = nums[cur1++];
//        while(cur2<=right) temp[i++] = nums[cur2++];
//
//    }
public static void main2(String[] args) {
//    String[] array = {"dog","racecar","car"};
    String cur = "aabbccc";
    System.out.println(longestPalindrome(cur));
//    String cur = "asfsda";
//    System.out.println(cur.substring(0,1));
//    System.out.println(longestCommonPrefix(array));
}
public static void main1(String[] args) {
//    int[] array = {1,3,2,3,1};
//    Solution solution = new Solution();
//    System.out.println(solution.sortArray(array));
//    List<Integer> list = new ArrayList<>();
//        String.toCharArray();
//        String s = "afdsa";
//        s.toCharArray()
//    System.out.println(CheckPermutation("abc", "bc"));
//    HashMap<Integer,Integer> hashMap = new HashMap<>();
//    hashMap.get()
//    int[] array = {1,0,1,1};
//    System.out.println(containsNearbyDuplicate(array, 1));
//    List<Integer> list = new ArrayList<>();
//    String ret = "afds";
//    Integer ret1 = 123;
}
}