package LeedCode;

import java.security.Key;
import java.util.PriorityQueue;
import java.util.Random;

import static java.util.Collections.swap;

public class demo3 {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode ans = new ListNode(0);
//        int t = 0;
//        while(l1!=null || l2!=null || t!=0){
//            int val1 = l1==null? 0:l1.val;
//            int val2 = l2==null? 0:l2.val;
//            int val = val1+val2+t;
//
//            t = (val1+val2)/10;
//
//            ListNode temp = new ListNode(val%10);
//
//            ans.next = temp;
//
//            if(l1!=null) {
//                l1 = l1.next;
//            }
//            if(l2!=null) {
//                l2 = l2.next;
//            }
//
//        }
//        return ans.next;
//    }
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
