import java.io.StringWriter;

public class demo2 {
    public  static String convert(String s, int numRows) {
        StringBuilder stringBuilder =new StringBuilder();
        if(s.length()==1) return s;

        int d = 2*numRows-2;
        for(int i=0;i<s.length();i+=d){
            stringBuilder.append(s.charAt(i));
        }
        int floor = numRows-2;
        for(int k=1;k<numRows-1;k++){
            for(int i=k,j = d-k;i<s.length() || j<s.length();i+=d,j+=d){
                if(i<s.length()) stringBuilder.append(s.charAt(i));
                if(j<s.length()) stringBuilder.append(s.charAt(j));
            }
        }
        for(int i=numRows-1;i<s.length();i+=d){
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
    public String convert1(String s, int numRows) {
        StringBuilder stringBuilder =new StringBuilder();
        if(s.length()==1) return s;
        int d = 2*numRows-2;
        int count1 = 0;
        while(count1<s.length()){
            stringBuilder.append(s.charAt(count1));
            count1+=d;
        }
        int floor = numRows-2;
        for(int k=1;k<s.length()-1;k++){
              for(int i=k,j = d-k;i<s.length() || j<s.length();i+=d,j+=d){
                  if(i<s.length()) stringBuilder.append(s.charAt(i));
                  if(j<s.length()) stringBuilder.append(s.charAt(j));
              }
        }
        int count2 = 0;
        while(count2<s.length()){
            stringBuilder.append(s.charAt(count2));
            count2+=d;
        }
        return stringBuilder.toString();
    }
    public static  String modifyString(String s) {
        char[] array = s.toCharArray();

        for(int i=0;i<array.length;i++){

                if(array[i]=='?'){
                for(char ch = 'a';ch<='z';ch++){
                    if((i==0 || ch!=array[i-1]) && (i==array.length-1 || ch!=array[i+1]))
                        array[i] = ch;
                    break;
                }
            }
        }

        return String.valueOf(array);
    }
    public int[] missingTwo(int[] nums){
        int xou = 0;
        for(int cur : nums) xou^=cur;
        for(int i=1;i<=nums.length+2;i++) xou^=i;
        int chill = 0;

        while(true){
            if(((xou>>chill)&1)==1) break;
            else chill++;
        }
        //进行两次操作
        int ans1 = 0,ans2 = 0;
        for(int cur:nums){
            if(((cur>>chill)&1)==0){
                ans1^=cur;
            }else {
                ans2^=cur;
            }
        }
        for(int i=1;i<=nums.length+2;i++){
            if(((i>>chill)&1)==0){
                ans1^=i;
            }else {
                ans2^=i;
            }
        }
        return new int[]{ans1,ans2};
    }
    public int[] missingTwo2(int[] nums) {
        int xou = 0;
        for(int i=0;i<nums.length;i++) xou^=nums[i];
        for(int i=1;i<=nums.length+1;i++) xou^=i;

        int diff  = 0 ;

        while(true){
            if(((xou>>diff)&1)==1) break;
            else diff++;
        }
        int ans1 = 0, ans2 = 0;
        for(int cur:nums){
            if(((cur>>diff)&1)==1) ans1^=cur;
            else ans2^=cur;
        }
        for(int i=1;i<=nums.length+2;i++){
            if(((i>>diff)&1)==1) ans1^=i;
            else ans2^=i;
        }
        return new int[] { ans1, ans2 };
    }
    public  static int[] singleNumber1(int[] nums) {

        int xou = 0;
        for (int cur : nums) {
            xou ^= cur;
        }
        int bit = xou & (-xou);
        int ans1 = 0, ans2 = 0;
        for (int cur : nums) {
            if ((xou & bit) != 0) {
                ans1 ^= cur;
            } else {
                ans2 ^= cur;
            }
        }
        return new int[] { ans1, ans2 };
    }
    //按位异或是无进位相加    通过  按位与 向右移动一位  进行进位
    public  static int getSum(int a, int b) {
        
        while(b!=0){
            int x = a^b;
            int y = (a&b)<<1;
            a = x;
            b =y;
        }
        return a;
    }
    public int missingNumber(int[] nums) {
        int n  = nums.length;
        int ret = 0;

        for(int i=0;i<=nums.length;i++){
            ret^=i;
        }
        for(int i=0;i<nums.length;i++){
            ret^=nums[i];
        }
        return ret;
    }
    public  static boolean isUnique(String astr){
        //利用位图
        if(astr.length()>26) return false;

        int ret = 0;

        for(int i=0;i<astr.length();i++){
            int x = astr.charAt(i)-'a';
          if(((ret>>x)&1)==1) return false;
          //接入到位图中
            ret|=1<<x;
        }

        return true;
    }
    public  static boolean isUnique1(String astr) {
        for(int i=0;i<astr.length();i++){
            for(int j =i+1;j<astr.length();j++){
                if(astr.charAt(i)==astr.charAt(j)) return false;
            }
        }
        return true;
    }
    public  static int myAtoi(String s) {
        char[] array = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int index = -1,temp = 1;
        for(int i=0;i<array.length;i++){
            if(Character.isDigit(array[i])){
                index = i;
                break;
            }
        }
        if(index==-1) return 0;

        if(index-1>=0){
            if(array[index-1]=='-') temp = -1;
        }
        for(int i=index;i< array.length;i++){
            if(Character.isDigit(array[i])) stringBuilder.append(array[i]);
            else break;
        }
        //需要解决开头为零的情况
        for(int i=0;i<stringBuilder.length();i++){
        if(stringBuilder.length()==1) break;
            if(stringBuilder.charAt(i)=='0') stringBuilder.deleteCharAt(i);
            else break;
        }
        return Integer.valueOf(stringBuilder.toString())*temp;
    }
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
        ret = ret/10;

        if(ret<=Integer.MAX_VALUE && ret>=Integer.MIN_VALUE)  return (int)ret*flag;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(convert("AB",1));
        //"PAHNAPLSIIGYIR"

    }
    public static void main3(String[] args) {
        int[] array = {1,2,1,3,2,5};
        //singleNumber(array);
    }
    public static void main2(String[] args) {
        System.out.println(getSum(2, 3));
    }
    public static void main1(String[] args) {
        System.out.println(-1&1);
        System.out.println(1|1);;
        //        System.out.println(112*('-'-'0'));
//        System.out.println(reverse(0));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(320));
//        System.out.println(reverse(123));
    }
}
