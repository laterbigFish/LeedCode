import java.util.Random;

public class demo2 {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }
    public void qsort(int[] nums, int l, int r) {
        if (l >= r) return;
        int randomIntKey = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1, right = r + 1, i = 1;
        while (i < right) {
            if (nums[i] < randomIntKey)
                swap(nums, ++left, i++);
            else if (nums[i] == randomIntKey)
                i++;
            else
                swap(nums, --right, i);
        }
        qsort(nums, l, left);
        qsort(nums, right, r);
    }

    public void swap(int[] array, int MaxIndex, int i) {
        int temp = array[MaxIndex];
        array[MaxIndex] = array[i];
        array[i] = temp;
    }
    public static void main(String[] args) {

    }
}
