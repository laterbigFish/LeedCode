package Javaguid;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class test {
    HashMap<Character,Integer> hashMap = new HashMap <> ();
    HashMap<Character,Set<Character>> edgs = new HashMap <> ();
    boolean check;
    public String alienOrder(String[] words) {
       //先将入度信息初始化为零
        for(String cur:words){
            for(int i = 0;i<cur.length ();i++) hashMap.put ( cur.charAt ( i ),0 );
        }

        for(int i=0;i<words.length;i++){
            for(int j = i+1;j<words.length;j++){
                add(words[i],words[j]);
                if(check) return "";
            }
        }
        //进行一次拓扑排序 并记录结果
        StringBuilder stringBuilder = new StringBuilder ();

        Deque<Character> deque = new LinkedList <> ();
        for(char cur:hashMap.keySet ()){
            if(hashMap.get ( cur )==0) deque.offer(cur);
        }

        while(!deque.isEmpty ()){

            char t  = deque.poll ();

            stringBuilder.append ( t );
            if(!edgs.containsKey ( t ))  continue;

            for(char ch:edgs.get ( t )){
                hashMap.put ( ch,hashMap.get ( ch )-1 );
                if(hashMap.get ( ch )==0) deque.offer(ch);
            }
        }
        for(char ch:hashMap.keySet ()){
            if(hashMap.get ( ch )!=0) return "";
        }
        return stringBuilder.toString ();
    }

    private void add ( String word , String word1 ) {
        int len = Math.min ( word.length (),word1.length ());
        int i =0;
        for(i=0;i<len;i++){
            char s1 = word.charAt ( i ),s2 = word1.charAt ( i );
            if(s1!=s2){
                if(!edgs.containsKey ( s1 )){
                    edgs.put ( s1,new HashSet <> () );
                }
                if(!edgs.get ( s1 ).contains ( s2 )){
                    edgs.get ( s1 ).add ( s2 );
                    hashMap.put ( s2,hashMap.get ( s2 )+1 );
                }
                break;
            }
        }
        if(i==word1.length () && i<word.length ()) check = true;
    }
//    private static List<List<String>> list = new LinkedList<>();
//    private  static char[][] path;
//    private static int N;
//    private  static boolean[] col, dig1, dig2;
//
//    public static List<List <String>> solveNQueens( int n) {
//        path = new char[n][n];
//        N = n;
//        col = new boolean[n];
//        dig1 = new boolean[n * 2];
//        dig2 = new boolean[n * 2];
//
//        // 将所有的path中的值设置为‘.’
//        for (char[] cur : path)
//            Arrays.fill(cur, '.');
//        dfs(0);
//        return list;
//    }
//
//    public  static void dfs(int row) {
//        if (row == N) {
//            // 满足条件可以进行插入
//            List<String> cur = new LinkedList<>();
//            for (int j = 0; j < N; j++) {
//                cur.add(new String(path[j]));
//            }
//            list.add(new LinkedList<>(cur));
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            // 先判断能不能方
//            if (dig1[row - i + N] == false && dig2[row + i] == false && col[i] == false) {
//                path[row][i] = 'Q';
//                dig1[row - i + N] = dig2[row + i] = col[i] = true;
//                dfs(row + 1);
//                path[row][i] = '.';
//                dig1[row - i + N] = dig2[row + i] = col[i] == false;
//            }
//
//        }
//    }

    public static void main ( String[] args ) {
        HashMap<Character,Integer> hashMap = new HashMap <> ();
//        BigDecimal bigDecimal=BigDecimal.valueOf ( 4.1 );
//        BigDecimal bigDecimal1 = BigDecimal.valueOf ( 3.1 );
//        BigDecimal divide=bigDecimal.divide ( bigDecimal,5, RoundingMode.HALF_UP ); //算出结果后会产生新的数
//        System.out.println ( divide );

    }
}
