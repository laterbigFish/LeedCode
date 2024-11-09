package Sort;

import org.w3c.dom.Node;

import java.util.*;

class Solution {
    private Deque<Integer> path = new ArrayDeque<>();
//    private int left;
//    private int right;
//    private int N;
//    private List<String> ret = new LinkedList<>();
//    private StringBuilder path = new StringBuilder();
//
//    public List<String> generateParenthesis(int n) {
//        N = n;
//        dfs();
//        return ret;
//    }
//
//    public void dfs() {
//        if (right == N) {
//            ret.add(path.toString());
//            return;
//        }
//        if (left < N) {
//            path.append('(');
//            left++;
//            dfs();
//            left--;
//            path.deleteCharAt(path.length()-1);
//        }
//        if (right < N) {
//            path.append(')');
//            right++;
//            dfs();
//            right--;
//            path.deleteCharAt(path.length()-1);
//        }
//    }

    //    StringBuilder stringBuilder = new StringBuilder();
//    List<List<Integer>> ret = new LinkedList<>();
//     HashSet<List<Integer>> hashSet = new HashSet<>();
//     List<Integer> path = new LinkedList<>();
//     boolean[] check;
//    public List<List<Integer>> permuteUnique(int[] nums) {
//         check = new boolean[nums.length];
//        dfs(nums);
//
//      return ret;
//    }
//
//    private void dfs(int[] nums) {
//        if(path.size()==nums.length){
//            if(!hashSet.contains(path)){
//                ret.add(new LinkedList<>(path));
//                hashSet.add(new LinkedList<>(path));
//            }
//           return ;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(check[i]==false){
//                path.add(nums[i]);
//                check[i] = true;
//                dfs(nums);
//                check[i] = false;
//                path.removeLast();
//            }
//        }
//
//    }
//    List<String> ret = new LinkedList<>();
//    StringBuilder path = new StringBuilder();
//    HashMap<Character, String> hashMap = new HashMap<Character, String>() {{
//        put('2', "abc");
//        put('3', "def");
//        put('4', "ghi");
//        put('5', "jkl");
//        put('6', "mno");
//        put('7', "pqrs");
//        put('8', "tuv");
//        put('9', "wxyz");
//    }};
//    public List<String> letterCombinations(String digits) {
//        if(digits.length()==0) return ret;
//        dfs(digits,0);
//        return ret;
//    }
//    private void dfs(String digits, int index) {
//        if(path.length()==digits.length()){
//            ret.add(path.toString());
//            return;
//        }
//        String count = hashMap.get(digits.charAt(index));
//
//        for(int i=0;i<count.length();i++){
//            path.append(count.charAt(i));
//            dfs(digits,index+1);
//            path.deleteCharAt(index);
//        }
//    }


//     List<List<Integer>> ret = new LinkedList<>();
//    List<Integer> path = new LinkedList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//         dfs(nums,0);
//         return ret;
//    }
//    public void dfs(int[] nums,int index){
//         ret.add(new LinkedList<>(path));
//         for(int i=index;i<nums.length;i++){
//            path.add(nums[i]);
//            dfs(nums,i+1);
//            path.removeLast();
//         }
//    }
//    public int subsetXORSum(int[] nums) {
//       List<List<Integer>> ans =  subsets(nums);
//        int Ret = 0;
//        for(List<Integer> cur:ans){
//            int num = 0;
//            int n = cur.size();
//            for(int i=0;i<n;i++){
//                num^=cur.removeLast();
//            }
//            Ret+=num;
//        }
//        return Ret;
//    }


}