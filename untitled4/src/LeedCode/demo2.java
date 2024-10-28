package LeedCode;

import java.util.ArrayList;
import java.util.List;

public class demo2 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
   lists.add(list1);
   lists.add(list2);
   for(List<Integer> cur:lists){
       System.out.println(cur.getFirst());
   }
    }
}
