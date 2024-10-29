import java.util.*;

class Solution {
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
public static void main(String[] args) {
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
    int[] array = {1,0,1,1};
    System.out.println(containsNearbyDuplicate(array, 1));
    List<Integer> list = new ArrayList<>();
    String ret = "afds";
    Integer ret1 = 123;
}
}