import java.util.ArrayList;
class FuelTank {
    private double fuelAmount; // 油量

    public FuelTank(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void consumeFuel(double amount) {
        if (amount <= fuelAmount) {
            fuelAmount -= amount;
        } else {
            System.out.println("油箱里的油量不足，无法完成此次操作");
        }
    }
}

// 汽车类
class Car {
    private static final double FUEL_CONSUMPTION = 5.0; // 每次运行消耗的油量

    public void run(FuelTank fuelTank) {
        System.out.printf("汽车开始运行，消耗油量：%.2f升%n", FUEL_CONSUMPTION);
        fuelTank.consumeFuel(FUEL_CONSUMPTION);
    }
}
public class Main {

    public static void main(String[] args) {
            FuelTank fuelTank = new FuelTank(20.0); // 油箱初始油量为20升
            Car car = new Car();

            // 输出初始油量
            System.out.printf("油箱初始油量：%.2f升%n", fuelTank.getFuelAmount());

            // 汽车运行
            car.run(fuelTank);

            // 输出汽车运行后的油量
            System.out.printf("汽车运行一次后的油量：%.2f升%n", fuelTank.getFuelAmount());
    }
    //五星填数
//    static int count=0;
//    public static void main(String[] args) {
//        int[] arr=new int[13];
//        ArrayList<Integer> t=new ArrayList<Integer>();
//        dfs(arr,t);
//        System.out.println(count/5/2);
//    }
//    public static void dfs(int[] arr, ArrayList<Integer> t){
//        if(t.size()==10){
//            if(ff(t)){
//                count++;
//            }
//            return;
//        }
//        for (int i=1; i<=12; i++){
//            if(arr[i]==1){
//                continue;
//            }
//            if(i==7||i==11){
//                continue;
//            }
//            arr[i]=1;
//            t.add(i);
//            dfs(arr, t);
//            t.remove(t.size()-1);
//            arr[i]=0;
//        }
//    }
//    public static boolean ff(ArrayList<Integer> t){
//        int sum1=t.get(0)+t.get(2)+t.get(5)+t.get(8);
//        int sum2=t.get(0)+t.get(3)+t.get(6)+t.get(9);
//        int sum3=t.get(1)+t.get(2)+t.get(3)+t.get(4);
//        int sum4=t.get(1)+t.get(5)+t.get(7)+t.get(9);
//        int sum5=t.get(4)+t.get(6)+t.get(7)+t.get(8);
//        if(sum1==sum2&&sum2==sum3&&sum3==sum4&&sum4==sum5){
//            return true;
//        }
//        return false;
//    }
}