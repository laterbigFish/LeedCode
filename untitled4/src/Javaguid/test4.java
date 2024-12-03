package Javaguid;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class test4 {
    private final int[] dx = {1,-1,0,0};
    private final int[] dy = {0,0,1,-1};
    private boolean[][] vision;
    public boolean exist(char[][] board, String word) {
        vision = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==word.charAt ( 0 )){
                    boolean flag =  dfs(board,word,i,j,1);
                }
            }
        }
         return false;
    }
    //不断的进行删除
    private boolean dfs ( char[][] board , String word , int a , int b ,int index) {
        vision[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int x = a+dx[i], y = b+dy[i];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !vision[x][y] && board[x][y]==word.charAt ( index )) {
                vision[x][y] = true;
                boolean flag = dfs ( board , word , x , y ,index+1);
                if (flag){
                    return true;
                }
                vision[x][y] = false;
            }
        }
        return false;
    }
//    int m,n;
//    private  final int[] dx = {1,-1,0,0};
//    private  final int[] dy = {0,0,1,-1};
//    List<List <Integer>> ret = new LinkedList <> ();
//
//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         m = heights.length;
//         n = heights[0].length;
//         boolean[][] pac = new boolean[m][n];
//         boolean[][] atl = new boolean[m][n];
//         for(int i=0;i<m;i++) dfs(heights,i,0,pac);
//         for(int i=0;i<n;i++) dfs(heights,0,i,pac);
//
//         for(int i=0;i<m;i++) dfs(heights,i,n-1,atl);
//         for(int i=0;i<n;i++) dfs(heights,m-1,i,atl);
//         //提取结果
//
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(pac[i][j]  && atl[i][j]){
//                     List<Integer> t = new LinkedList <> ();
//                     t.add ( i );
//                     t.add ( j );
//                   ret.add ( t );
//                 }
//             }
//         }
//       return  ret;
//    }
//
//    private void dfs ( int[][] heights , int row , int col , boolean[][] vision) {
//         vision[row][col] = true;
//         for(int i=0;i<4;i++){
//             int x = row+dx[i],y = col+dy[i];
//
//             if(x>=0 &&y>=0 && x<m && y<m && !vision[x][y] && heights[x][y]>=heights[row][col]){
//                 vision[x][y] = true;
//             }
//         }
//    }

//    private boolean[][] row  =  new boolean[9][10]; //行
//    private boolean[][] col  = new boolean[9][10]; //列
//    private boolean[][][] grid = new boolean[3][3][10]; //将九个小方格分别用grid表示
//
//    public void solveSudoku(char[][] board) {
//        //初始化
//        for(int i=0;i<board.length;i++){
//
//            for(int j =0;j<board[0].length;i++){
//
//                if(Character.isDigit ( board[i][j] )){
//                    row[i][board[i][j]-'0']= col[j][board[i][j]-'0'] = grid[i/3][j/3][board[i][j]-'0'] = true;
//                }
//            }
//        }
//        dfs(board);
//    }
//
//    private boolean dfs ( char[][] board ) {
//
//        for(int i=0;i<board.length;i++){
//
//            for(int j = 0;j<board[0].length;j++){
//
//                if(!Character.isDigit ( board[i][j] )){
//                    //一到九此次放入
//                    for(int k = 1;k<=9;k++){
//                        if(!row[i][k] && !col[j][k] && !grid[i/3][j/3][k]){
//                            row[i][k] = col[j][k] = grid[i/3][j/3][k] = true;
//                            board[i][j] = (char)(k+'0');
//                             if(dfs ( board )) return true;
//                            board[i][j] = ' ';
//                            row[i][k] = col[j][k] = grid[i/3][j/3][k] = false;
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    private boolean[][] row  =  new boolean[9][10]; //行
//    private boolean[][] col  = new boolean[9][10]; //列
//    private boolean[][][] grid = new boolean[3][3][10]; //将九个小方格分别用grid表示
//    public boolean isValidSudoku(char[][] board) {
//
//        for(int i=0;i<9;i++){
//            for(int j = 0;j<9;j++){
//                char  t = board[i][j];
//                if(!row[i][t-'0'] || !col[j][t-'0'] || !grid[i/3][j/3][t-'0'] ){
//                    return false;
//                }
//
//                    row[i][t-'0'] = col[j][t-'0'] = grid[i/3][j/3][t-'0'] = true;
//            }
//        }
//        return true;
//    }

    public static void main ( String[] args ) {
        Deque<int[]> deque = new LinkedList <> ();
        deque.offer ( new int[]{1,2} );
        System.out.println ( deque.contains ( new int[]{1 , 2} ) );
    }
}
