package LeedCode;

import java.security.Key;
import java.util.PriorityQueue;
import java.util.Random;

import static java.util.Collections.swap;

public class demo3 {
    public int[] sortArray1(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int l, int r) {
          if(l>=r) return;
          int RandomKey = nums[new Random().nextInt(r-l+1)+l];
          //需要进行拆分因此需要新的坐标
        int left= l-1,right = r-1,i = 1;
        while(i<right){
            if(nums[i]<RandomKey)  swap(nums,++left,i++);
            else if(nums[i]==RandomKey) i++;
            else swap(nums, --right,i);
        }
          qsort(nums,l,left);
          qsort(nums,right,r);
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  = temp;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        System.out.println();
    }
}
