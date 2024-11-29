package Javaguid;

import java.util.*;

public class test {
    private static List<List<String>> list = new LinkedList<>();
    private  static char[][] path;
    private static int N;
    private  static boolean[] col, dig1, dig2;

    public static List<List <String>> solveNQueens( int n) {
        path = new char[n][n];
        N = n;
        col = new boolean[n];
        dig1 = new boolean[n * 2];
        dig2 = new boolean[n * 2];

        // 将所有的path中的值设置为‘.’
        for (char[] cur : path)
            Arrays.fill(cur, '.');
        dfs(0);
        return list;
    }

    public  static void dfs(int row) {
        if (row == N) {
            // 满足条件可以进行插入
            List<String> cur = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                cur.add(new String(path[j]));
            }
            list.add(new LinkedList<>(cur));
            return;
        }

        for (int i = 0; i < N; i++) {
            // 先判断能不能方
            if (dig1[row - i + N] == false && dig2[row + i] == false && col[i] == false) {
                path[row][i] = 'Q';
                dig1[row - i + N] = dig2[row + i] = col[i] = true;
                dfs(row + 1);
                path[row][i] = '.';
                dig1[row - i + N] = dig2[row + i] = col[i] == false;
            }

        }
    }

    public static void main ( String[] args ) {
        System.out.println ( solveNQueens ( 4 ) );
    }
}
