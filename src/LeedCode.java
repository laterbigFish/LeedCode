import java.util.Arrays;

public class LeedCode {
    public static void main(String[] args) {
        int[] array ={4,2,1,3,45,1,1};
        array = sortArray(array);
        System.out.println(Arrays.toString(array));

    }

    public  static  int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public  static void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
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
}
