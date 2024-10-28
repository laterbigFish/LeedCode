package LeedCode;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        List<Integer>[] lists = new List[100];
       PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
       for(List<Integer> cur:lists){
           if(cur!=null){
               priorityQueue.offer(cur.getFirst());

           }
       }
    }
    public static void main2(String[] args) {
        List<Integer> list1 = new ArrayList<>(2);
        List<Integer> list2 = new ArrayList<>(6);
        List<Integer> list3 = new ArrayList<>(1);
        List<Integer> list4 = new ArrayList<>(0);
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(list1);
        priorityQueue.offer(list2);
        priorityQueue.offer(list3);
        priorityQueue.offer(list4);
        for(List<Integer> cur: priorityQueue){
        }
    }
    public static void main1(String[] args) {
         List<Integer> list = new ArrayList<>();
        List<Integer>[] lists = new List[100];
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>();
        for(int i=0;i< lists.length;i++){
            while(lists[i].getFirst()!=null){
                priorityQueue.offer(lists[i]);
            }
        }
    }
}
