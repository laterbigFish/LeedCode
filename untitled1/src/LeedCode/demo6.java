package LeedCode;

public class demo6 {
    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length - 1, k);
    }
    private int selectK(int[] nums, int low, int high, int k){

        int pv = part(nums, low, high);
        int pos = pv - low + 1;
        if(pos == k){
            return nums[pv];
        }else if(pos > k){
            return selectK(nums, low, pv -1, k);
        }else {
            return selectK(nums, pv+1, high, k - pos);
        }
    }
    private int part(int[] nums, int left, int right){
        int pv = nums[left];
        int low = left + 1;
        int high = right;
        while(low <= high){
            while(low <= high && nums[low] > pv){
                low++;
            }
            while(low <= high && nums[high] < pv){
                high--;
            }
            if(low <= high){
                swap(nums, low++, high--);
            }
        }
        swap(nums, left, high);
        return high;
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void main(String[] args) {

    }
}
