package LeedCode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class demo3 {
    public  static int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);

        int sum = 0,ret = 0;
        for(int cur: nums){
            sum+=cur;

            ret+=hashMap.getOrDefault(sum-k,0);
            hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);
        }
        return ret;
    }
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> priorityQueure = new PriorityQueue<>((v1,v2) ->v1.val-v2.val);
//
//        for(ListNode cur:lists){
//            if(cur!=null) priorityQueure.offer(cur);
//        }
//        ListNode ret = new ListNode(0);
//        ListNode prve = ret;
//
//        while(!priorityQueure.isEmpty()){
//            ListNode t = priorityQueue.poll();
//            prev.next = t;
//            prev = t;
//            if(t.next!=null) priorityQueue.offer(t.next);
//        }
//        return ret;
//    }
    public static void main(String[] args) {
    int[] array = {-1,0,1,1};
        System.out.println(subarraySum(array,2));
    }
}
