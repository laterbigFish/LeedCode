import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class demo2 {
    public  static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        if(nums.length<k) return -1;
        for(int i=0;i<nums.length;i++){
            if(priorityQueue.peek()==null) priorityQueue.offer(nums[i]);
            else{
                if(nums[i]>priorityQueue.peek()){

                }
            }
        }
        return priorityQueue.peek();
    }
    public  static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length<k) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++){
            if(priorityQueue.peek()!=null && nums[i]==priorityQueue.peek() ) continue;
            priorityQueue.offer(nums[i]);
          if(priorityQueue.size()==k) break;
        }

        return priorityQueue.poll();
    }
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
        int[] array = {3,2,1,5,6,4};
        System.out.println(findKthLargest(array, 2));
    }

}
