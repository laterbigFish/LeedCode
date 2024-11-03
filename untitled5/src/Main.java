import java.util.ArrayList;

public class Main {
    //五星填数
    static int count=0;
    public static void main(String[] args) {
        int[] arr=new int[13];
        ArrayList<Integer> t=new ArrayList<Integer>();
        dfs(arr,t);
        System.out.println(count/5/2);
    }
    public static void dfs(int[] arr, ArrayList<Integer> t){
        if(t.size()==10){
            if(ff(t)){
                count++;
            }
            return;
        }
        for (int i=1; i<=12; i++){
            if(arr[i]==1){
                continue;
            }
            if(i==7||i==11){
                continue;
            }
            arr[i]=1;
            t.add(i);
            dfs(arr, t);
            t.remove(t.size()-1);
            arr[i]=0;
        }
    }
    public static boolean ff(ArrayList<Integer> t){
        int sum1=t.get(0)+t.get(2)+t.get(5)+t.get(8);
        int sum2=t.get(0)+t.get(3)+t.get(6)+t.get(9);
        int sum3=t.get(1)+t.get(2)+t.get(3)+t.get(4);
        int sum4=t.get(1)+t.get(5)+t.get(7)+t.get(9);
        int sum5=t.get(4)+t.get(6)+t.get(7)+t.get(8);
        if(sum1==sum2&&sum2==sum3&&sum3==sum4&&sum4==sum5){
            return true;
        }
        return false;
    }
}