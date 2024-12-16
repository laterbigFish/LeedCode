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
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (func(nums, i, j, indexDiff, valueDiff))
                    return true;
            }
        }
        return false;
    }

    public  static boolean func(int[] nums, int i, int j,int indexDiff,int valueDiff) {

        if ((i!=j) && (Math.abs ( i-j ) <= indexDiff) && Math.abs ( nums[i]-nums[j] )<=valueDiff) {
            return true;
        }

        return false;
    }
    private static List<String> list = new LinkedList<>();

    public  static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return list;
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 全部遍历一遍
        for (int i = 0; i < s.length(); i++) {
            if (i + 9 < s.length()) {
                         String cur = s.substring(i, i + 10);
                if (!hashMap.containsKey(cur))
                    hashMap.put(cur, 1);
                else{
                    if(!list.contains ( cur )) list.add ( cur );
                }
            }
        }
        return list;
    }

    public static void main ( String[] args ) {
        int[] nums = {1,2,3,1};
        containsNearbyAlmostDuplicate ( nums,3,0 );
    }
    public static void main6 ( String[] args ) {
         Scanner scanner = new Scanner ( System.in );

         while(scanner.hasNextInt ()){
             int n = scanner.nextInt ();
             HashMap<Integer,String> hashMap = new HashMap <> ();
             int count  = 0;
             for(int i=0;i<n;i++){
                 int salary = scanner.nextInt ();
                 String str = scanner.nextLine ();
                 if(hashMap.containsKey ( salary )){
                     hashMap.put ( salary, str);
                 }else{
                     String s = hashMap.get ( salary );
                     s = s+str;
                     hashMap.put ( salary,s );
                 }
             }
             //遍历HashMap
             for (Map.Entry <Integer, String> entry : hashMap.entrySet()) {
                 char[] temp = entry.getValue ().toCharArray ();
                 Arrays.sort ( temp );
                 if(temp.length>=2){
                     int left = 0,right = temp.length-1;
                     while(left<right){
                         if(temp[left]!=temp[right]){
                             count++;
                             left++;
                             right--;
                         }else{
                             break;
                         }
                     }
                 }
             }
             System.out.println (count);
         }
         scanner.close ();
    }
    public static void main5 ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        while(scanner.hasNextLine ()){
            StringBuilder stringBuilder = new StringBuilder (scanner.nextLine ());
            StringBuilder stringBuilder1 = new StringBuilder (stringBuilder.toString ());
                if(stringBuilder.length ()<=1){
                    System.out.println (1);
                    break;
                }
                int index = 1;
                char cur1 = 'L',cur2 = 'Q';
                while(index<stringBuilder.length ()){
                   if(stringBuilder.charAt ( index )==stringBuilder.charAt ( index-1 ) && stringBuilder.charAt ( index )==cur1){
                       stringBuilder.delete ( index-1,index );
                       continue;
                   }
                   index++;
                }
                int index2 = 1;

                while(index2<stringBuilder1.length ()){
                    if(stringBuilder1.charAt ( index2 )==stringBuilder1.charAt ( index2-1 ) && stringBuilder1.charAt ( index2 )==cur2){
                        stringBuilder1.delete ( index2-1,index2 );
                        continue;
                    }
                    index2++;
                }
            System.out.println (Math.min ( stringBuilder.length (),stringBuilder1.length ()));
        }
        scanner.close ();
    }
    //还跌判断月份是否合法
     private final  static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main3(String[] args){
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
