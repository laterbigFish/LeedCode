package LeedCode;


import java.util.Random;

public class dmeo5 {
    public static int findKthLargest(int[] nums, int k) {
        return qsort(nums, 0, nums.length-1, k);
    }
      //快速选择算法
    private static int qsort(int[] nums, int l, int r, int k) {
        if(l==r) return nums[l];

        int RandomKey = nums[new Random().nextInt(r-l+1)+l];
        int left = l-1,right = r+1,i = l;

        while(i<right){
            if(nums[i]<RandomKey) swap(nums,++left,i++);
            else if(nums[i]==RandomKey) i++;
            else swap(nums,--right,i);
        }
        //进行此类操作之后观察

        int b = right-left-1;
        int c =  r-right+1;
        if(c>=k) qsort(nums,right,r,k);
        else if(b+c>=k) return RandomKey;

        return qsort(nums,l,left,k-b-c);
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i]  = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
       int[] array = {3,2,1,5,6,4};
        System.out.println(findKthLargest(array, 1));
    }
}
