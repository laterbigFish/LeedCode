import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class demo {
    //找到字符串中所有的的异位符
    public List<Integer> findAnagrams(String s, String p) {
        int[] array = new int['z'];

    }
    //水果成篮   两个不同的篮子
   /*
   *
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
