// 定义一个抽象类
abstract class Animal {
    public final  static  int age = 10;
    // 抽象方法，没有方法体  方法体可由子类填充
    abstract void makeSound();
//    abstract void func();
    // 具体方法，有方法体
    public  void eat() {
        System.out.println("This animal eats food.");
    }
}

// 继承抽象类的子类
class Dog extends Animal {
    // 实现抽象方法
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

  class Cat extends Dog {

    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}
public class Main {
    private final int[] dx = { 1, -1, 0, 0 };
    private final int[] dy = { 0, 0, 1, -1 };
    private boolean[][] vision;
    private int ret;

    public int uniquePathsIII(int[][] grid) {
        vision = new boolean[grid.length][grid[0].length];

        vision[0][0] = true;

        dfs(grid,0,0);

        return ret;
    }

    public void dfs(int[][] grid, int a, int b) {
        if (grid[a][b] == 2) {
            ret++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i], y = b + dy[i];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !vision[x][y] && grid[x][y] == 0  && grid[x][y] != -1) {
                vision[x][y] = true;
                dfs(grid, x, y);
                vision[x][y] = false;
            }
        }
//    private final int[] dx = { 1, -1, 0, 0 };
//    private final int[] dy = { 0, 0, 1, -1 };
//    private boolean[][] vision;
//    private int ret;
//
//    public int getMaximumGold(int[][] grid) {
//        vision = new boolean[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] != 0)
//                    dfs(grid, i, j, grid[i][j]);
//            }
//        }
//        return ret;
//    }
//
//    public void dfs(int[][] grid, int a, int b, int sum) {
//        for (int i = 0; i < 4; i++) {
//            int x = a = dx[i], y = dy[i];
//            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 0 && !vision[x][y]) {
//                vision[a][b] = true;
//                ret = Math.max(ret, sum + grid[a][b]);
//                dfs(grid, x, y, sum + grid[a][b]);
//                vision[a][b] = false;
//            }
//
//        }
//    }
//    public static void main(String[] args) {
        //        Animal dog = new Dog();
//        dog.age = 10;
//        Animal cat = new Cat();
//
//        dog.makeSound(); // 输出: Bark
//        dog.eat();       // 输出: This animal eats food.
//
//        cat.makeSound(); // 输出: Meow
//        cat.eat();       // 输出: This animal eats food.
    }
}