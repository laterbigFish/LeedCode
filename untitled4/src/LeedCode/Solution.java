package LeedCode;

import java.util.Arrays;
import java.util.Random;


class Solution {


    // 合并两个已排序的子数组
    public static void merge(int[] array, int left, int mid, int right) {
        // 创建临时数组
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // 合并临时数组
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // 复制剩余元素
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
    public  static int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    public static void sort(int[] nums,int left,int right){
        if(left>=right) return;
        int mid = (right+left)/2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);

        int[] temp = new int[right-left+1];
        int cur1 =left,cur2 = mid+1,i = 0;
        while(cur1<=mid && cur2<=right){
            temp[i++] = nums[cur1]<=nums[cur2]?nums[cur1++]:nums[cur2++];
        }
        while(cur1<=mid) temp[i++] = nums[cur1++];
        while(cur2<=right) temp[i++] = nums[cur2++];
        for(int k = left;k<=right;k++){
            nums[i] = temp[k-left];
        }
    }
    public  static int[] sortArray1(int[] nums) {
         
         qsort(nums,0,nums.length-1);
         return nums;
     }
     public  static  void qsort(int[] nums,int l,int r){
        if(l>=r) return;
      
      int key = nums[new Random().nextInt(r-l+1)+l];
       int left = l-1,right = r+1,i = l;
       while(i<right){
          if(nums[i]<key){
           swap(nums,++left,i++);
          }else if(nums[i]==key){
            i++;
          }else{
            swap(nums,--right,i);
          }
          qsort(nums,l,left);
          qsort(nums,right,r);
       }
     }

    private static void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;

    }
}