import java.util.*;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//
//        // 解析输入的日期
//        int year = Integer.parseInt(input.substring(0, 4));
//        int month = Integer.parseInt(input.substring(4, 6));
//        int day = Integer.parseInt(input.substring(6, 8));
//
//        LocalDate date = LocalDate.of(year, month, day);
//
//        int count = 0;
//        String firstPalindrome = "";
//        String secondPalindrome = "";
//
//        // 查找下一个和下下个回文日期
//        while (count < 2) {
//            date = date.plusDays(1); // 增加一天
//            String dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//
//            if (isPalindrome(dateString)) {
//                count++;
//                if (count == 1) {
//                    firstPalindrome = dateString;
//                } else {
//                    secondPalindrome = dateString;
//                }
//            }
//        }
//
//        // 输出结果
//        System.out.println(firstPalindrome);
//        System.out.println(secondPalindrome);
//    }
//
//    // 检查字符串是否为回文
//    private static boolean isPalindrome(String str) {
//        int left = 0;
//        int right = str.length() - 1;
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//}
//public class Main {

//    public static void main(String[] args) {
//        double v = 1e5;
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNextInt()) {
//            int start = scanner.nextInt();
//            int[] ans = new int[2];
//
//            // 从输入的数字开始查找
//            int cur = start + 1;
//            while (true) {
//                // 判断是否是有效的回文日期
//                if (isPalindrome(cur)) {
//                    if (ans[1] == 0 && isABABBABA(cur)) {
//                        ans[1] = cur; // 找到第二个
//                    } else if (ans[0] == 0) {
//                        ans[0] = cur; // 找到第一个
//                    }
//
//                    // 如果找到了两个回文数，输出结果
//                    if (ans[0] != 0 && ans[1] != 0) {
//                        System.out.println(ans[0]);
//                        System.out.println(ans[1]);
//                        break;
//                    }
//                }
//                cur++;
//            }
//        }
//        scanner.close();
//    }
//
//    private static boolean isABABBABA(int cur) {
//        String str = String.valueOf(cur);
//        // 确保格式是 8 位
//        if (str.length() != 8) return false;
//
//        return str.charAt(1) != str.charAt(0) &&
//                str.charAt(0) == str.charAt(2) &&
//                str.charAt(3) == str.charAt(1);
//    }
//
//    private static boolean isPalindrome(int cur) {
//        String str = String.valueOf(cur);
//        String reversed = new StringBuilder(str).reverse().toString();
//        return str.equals(reversed);
//    }
//}
import java.util.*;
public class Main {
    //还跌判断月份是否合法
     private final  static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        Scanner scanner = new Scanner ( System.in );

        while(scanner.hasNextInt ()){
            int start = scanner.nextInt ();
            //下一个回文日期和回文格式   都是回文数 观察是否满足格式 ABABBABA
            int[] ans = new int[2];

            while(true){
                int cur = ++start;
                //判断是否是回文数
                if( func(cur) &&  check_valid ( cur )){
                    String str = String.valueOf(cur);
                    if(ans[1]==0 && func2(cur)) ans[1] = cur;
                    else if(ans[0]==0) ans[0] = cur;

                    if(ans[0]!=0 && ans[1]!=0){
                        System.out.println (ans[0]);
                        System.out.println (ans[1]);
                        break;
                    }
                }
            }
           Arrays.fill ( ans,0 );
        }
    }
   private static boolean func2(int cur){
        if(func ( cur )){
            String s = String.valueOf ( cur );
            if(s.charAt ( 0 )!=s.charAt ( 2 )||s.charAt ( 1 )!=s.charAt ( 3 )||s.charAt ( 0 )==s.charAt ( 1 ))return false;
            //结合ABABBABA思考
            return true;
        }
       return false;
    }
     private static boolean check_valid(int date){
        if(func(date)){
            int year=date/10000;
            int month=date%10000/100;
            int day=date%100;//分离年月日
            if(day==0||month<=0||month>12)return false;//显然的不合法情况
            if(month!=2&&day>months[month])return false;//月份不是2，day不合法就不合法
            if(month==2){//月份是2
                if((year%4==0&&year%100!=0)||(year%400==0))if(day>29)return false;//是闰月， day必须<=29
                else if(day>28)return false;//是平月，day必须<=28
            }
            return true;
        }
        return false;
    }
    private static boolean func ( int cur ) {
        //判断是否是回文数
        String str = String.valueOf ( cur );
        int left = 0,right = str.length ()-1;
        while(left<=right){
            if(str.charAt (left)==str.charAt ( right )){
                left++;
                right--;
            }else{
                return false;
            }
        }
            return true;
    }

}
