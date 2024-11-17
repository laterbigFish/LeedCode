package Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
   public static List<List<Integer>> ret = new LinkedList<>();

    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> temp = new LinkedList<>();
            temp.add(candidates[i]);
            if (candidates[i] == target)
                ret.add(temp);
            int left = i + 1, right = candidates.length - 1;
            while (left < right) {
                int cur =  candidates[left] + candidates[right];
                if (cur > target-candidates[i])
                    right--;
                else if (cur < target-candidates[i])
                    left++;
                else {
                    temp.add(candidates[left]);
                    temp.add(candidates[right]);
                    ret.add(temp);
                    left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {2,3,2,7};
        System.out.println(combinationSum(array, 7));
    }
}