public class demo2 {
    public static int func(int x){
        int ret  = 1;
        while(x / 10 != 0){
            ret++;
            x/=10;
        }
        return ret;
    }
    public static int reverse(int x) {
        long ret = 0;
        if (x == 0) return 0;
        int flag = x / Math.abs(x);
        x = Math.abs(x);
        int temp = func(x);
        while (temp--!=0) {
            ret+= x % 10;
            ret*= 10;
            x /= 10;
        }
        if (ret > Integer.MIN_VALUE || ret < Integer.MIN_VALUE) return 0;

        return (int)ret*flag;
    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(-123));
        System.out.println(reverse(320));
        System.out.println(reverse(123));
    }
}
