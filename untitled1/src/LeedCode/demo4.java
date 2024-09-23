package LeedCode;

import java.util.Random;

public class demo4 {
    public static int findKthLargest(int[] nums, int k) {
        return qsort(nums, 0, nums.length-1, k);
    }

    public static int qsort(int[] nums, int l, int r, int k) {
        if (l == r)  return nums[l];
        int RandomKey = nums[new Random().nextInt(r - l + 1) + l];

        int left = l - 1, right = r + 1, i = l;
        while (i < right) {
            if (nums[i] < RandomKey)
                swap(nums, ++left, i++);
            else if (nums[i] == RandomKey)
                i++;
            else
                swap(nums,--right, i);
        }
        int b = right - left - 1;
        int c = r - right + 1;
        if (c >= k)
            qsort(nums, right, r, k);
        else if (b + c >= k)
            return RandomKey;

        return qsort(nums, l, left, k - b - c);

    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums ={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
