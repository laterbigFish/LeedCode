import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Solution {
    public HashMap<Character,String> GET(){
         HashMap<Character,String> ret = new HashMap<>();
        ret.put('2',"abc");
        ret.put('3',"def");
        ret.put('4',"ghi");
        ret.put('5',"jkl");
        ret.put('6',"mno");
        ret.put('7',"pqrs");
        ret.put('8',"tuv");
        ret.put('9',"wxyz");
         return ret;
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> hashMap = GET();
        if(digits.isEmpty()) return null;
        List<String> list = new ArrayList<>();
        return ANS(list,digits,hashMap);
    }

    private List<String> ANS(List<String> list, String digits,HashMap<Character,String> hashMap) {
        char[] array = digits.toCharArray();


        return list;
    }
}
public class demo1 {
    public int[] sortArray(int[] nums) {
        qsort(nums,0,nums.length-1);
        return nums;
    }
    public void qsort(int[] nums,int left,int right){
        if(left>=right) return;
        Random random = new Random();
        int randomIntKey = nums[random.nextInt(right-left+1)+left];
        int left1 = left-1,right1 = right+1,i = 1;

        while(i<right1){
            if(nums[i]<randomIntKey)  swap2(nums,++left1,i++);
            else if(nums[i]==randomIntKey) i++;
            else swap2(nums,--right,i);
        }
        qsort(nums,1,left1);
        qsort(nums,right1,right);
    }
    public  void swap2(int[] array, int MaxIndex, int i) {
        int temp = array[MaxIndex];
        array[MaxIndex] = array[i];
        array[i] = temp;
    }
    //哈希排序
    public static void shellSort(int[] array){
        int gap = array.length;

        while(gap>0){
            gap/=2;
            shell(array,gap);
        }
    }
    public static void shell(int[] array,int gap){
        for(int i=gap;i<array.length;i++){
            int temp = array[i];
            int j = i-gap;
            for(;j>=0;j-=gap){
                if(array[j] > temp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }
    public static void swap(int[] array, int MaxIndex, int i) {
        int temp = array[MaxIndex];
        array[MaxIndex] = array[i];
        array[i] = temp;
    }
    public  static int[] sortArray1(int[] nums) {
        shellSort(nums);
        return nums;
    }
    public void swap1(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public void sortColors(int[] nums) {

        int left = -1,right = nums.length;
        int i = 0;
        while(i < right){
            if(nums[i]==0)     swap(nums,++left,i++);
            else if(nums[i]==1)  i++;
            else  swap(nums,--right,i);
        }

    }
    public static int minNumberOfFrogs(String croakOfFrogs) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] array = croakOfFrogs.toCharArray();

        for(int i=0;i<array.length;i++){
            if(array[i]=='c'){
                if(hashMap.getOrDefault('k',0)!=0){
                    hashMap.put('k',hashMap.getOrDefault('k',0)-1);
                    hashMap.put('c',hashMap.getOrDefault('c',0)+1);
                    continue;
                }else{
                    hashMap.put('c',hashMap.getOrDefault('c',0)+1);
                    continue;

                }

            }
            if(array[i]=='r'){
                if(hashMap.getOrDefault('c',0)==0)   return -1;
                else{
                    hashMap.put('r',hashMap.getOrDefault('r',0)+1);
                    hashMap.put('c',hashMap.getOrDefault('c',0)-1);
                    continue;

                }
            }
            if(array[i]=='o'){
                 if(hashMap.getOrDefault('r',0)==0) return -1;
                 else{
                     hashMap.put('o',hashMap.getOrDefault('o',0)+1);
                     hashMap.put('r',hashMap.getOrDefault('r',0)-1);
                     continue;
                 }
            }

            if(array[i]=='a'){
                if(hashMap.getOrDefault('o',0)==0) return -1;
                else{
                    hashMap.put('a',hashMap.getOrDefault('a',0)+1);
                    hashMap.put('o',hashMap.getOrDefault('o',0)-1);
                    continue;
                }
            }
            if(array[i]=='k'){
                if(hashMap.getOrDefault('a',0)==0) return -1;
                else{
                    hashMap.put('k',hashMap.getOrDefault('k',0)+1);
                    hashMap.put('a',hashMap.getOrDefault('a',0)-1);
                    continue;
                }
            }
        }
        if(hashMap.getOrDefault('c',0)!=0 || hashMap.getOrDefault('r',0)!=0 ||
                hashMap.getOrDefault('o',0)!=0 || hashMap.getOrDefault('a',0)!=0){
             return -1;
        }
        return hashMap.get('k');

    }
    public static void main(String[] args) {
    String s = "crocakcroraoakk";
      Random random = new Random();
      random.ints();//生成任意整数
        System.out.println(minNumberOfFrogs(s));
    }
}
