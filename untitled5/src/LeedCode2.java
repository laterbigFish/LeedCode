import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeedCode2 {
    public  static boolean validateStackSequences(int[] pushed, int[] popped) {
       Stack<Integer> stack = new Stack<>();
       int n = 0;
       for(int i=0;i<pushed.length;i++){
           stack.push(pushed[i]);
           if(stack.peek()==popped[n]){
            stack.pop();
            n++;
            //随后观察是否为空
               while(!stack.isEmpty()){
                   if(stack.peek()==popped[n]) {
                     stack.pop();
                     n++;
                   }else{
                       break;
                   }
               }
           }
       }
       if(stack.isEmpty()) return true;

       return false;
    }
    public static  String decodeString(String s) {
     Stack<StringBuilder> dequeStr = new Stack<>();
     Stack<Integer> dequeInteger = new Stack<>();
     int i =0,n = s.length();
     dequeStr.push(new StringBuilder());
     while(i<n){
         if(Character.isDigit(s.charAt(i))){
             int tmp = 0;
             while(i<n && Character.isDigit(s.charAt(i))){
                 tmp = tmp*10+(s.charAt(i++)-'0');
             }
             dequeInteger.push(tmp);
         }else if(s.charAt(i)=='['){
             i++;
             StringBuilder builder = new StringBuilder();
             while(i<n && Character.isLetter(s.charAt(i))){
                     builder.append(s.charAt(i++));
             }
             dequeStr.add(builder);
         }else if(s.charAt(i)==']'){
             int stackFirst = dequeInteger.pop();
             StringBuilder  str = dequeStr.pop();
             while(stackFirst--!=0){
                 dequeStr.peek().append(str);
             }
             i++;
         }else if(Character.isLetter(s.charAt(i))){
             StringBuilder stringBuilder = new StringBuilder();
             while(i<n && Character.isLetter(s.charAt(i))){
                 stringBuilder.append(s.charAt(i++));
             }
             dequeStr.peek().append(stringBuilder);
         }
     }
      return dequeStr.peek().toString();
    }
    public  static String decodeString2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int ret = 0,i = 0,n = s.length();
        while(i<n){
            if(Character.isDigit(s.charAt(i))){
                ret+=s.charAt(i)-'0';
                i+=2;
            }else if(ret!=0 && Character.isLetter(s.charAt(i)) ){
                StringBuilder stringBuilder1 = new StringBuilder();
                while(s.charAt(i)!=']'){
                    stringBuilder1.append(s.charAt(i++));
                }
                while(ret--!=0){
                    stringBuilder.append(stringBuilder1.toString());
                }
                ret=0;
                i++;
            }else if(Character.isLetter(s.charAt(i))){
                stringBuilder.append(s.charAt(i++));
            }else{
                i++;
            }
        }
        return stringBuilder.toString();
    }
    public static int calculate(String s){
        Deque<Integer> deque = new ArrayDeque<>();
        char op = '+';
        int i=0,n = s.length();
        while(i<n){
            if(s.charAt(i)==' ') i++;
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                   int temp = 0;
                   while( i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                       temp = temp*10+(s.charAt(i++)-'0');
                   }
                   if(op=='*'){
                       deque.push(deque.pop()*temp);
                   }else if(op =='/'){
                       deque.push(deque.pop()/temp);
                   }else if(op=='-') deque.push(-temp);
                   else deque.push(temp);

            }else{
                op = s.charAt(i++);
            }
        }
        int ans = 0;
        for(int cur:deque){
            ans+=cur;
        }
        return ans;
    }
    public static int calculate1(String s) {
      char op = '+';
      Stack<Integer> stack = new Stack<>();
      for(int i=0;i<s.length();i++){
          if(op=='*'){
            stack.push(stack.pop()*s.charAt(i));
          }else if(op=='/'){
              stack.push(stack.pop()/s.charAt(i));
          }
          //如果这个数是负
          int cur = 0;
          if(s.charAt(i)=='-'){
              if(i<s.length() && Character.isDigit(s.charAt(i))){
                  cur*=10;
                  cur+=Integer.valueOf(s.charAt(i++));
              }
              cur*=-1;
          }

          if(i<s.length() && Character.isDigit(s.charAt(i))){
              cur*=10;
              cur+=Integer.valueOf(s.charAt(i++));
          }
          if(i<s.length()) op = s.charAt(i);
      }

       int ans = 0;
       for(int cur:stack){
           ans+=stack.pop();
       }
      return ans;
    }
    public static boolean backspaceCompare(String s, String t) {

        return changestr(s).equals(changestr(t));
    }

    private static String changestr(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                stringBuilder.append(s.charAt(i));
            }else{
                if(!stringBuilder.isEmpty())
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
        return stringBuilder.toString();
    }

    public static boolean backspaceCompare1(String s, String t) {
         StringBuilder stringBuilder1 = new StringBuilder();
         StringBuilder stringBuilder2 = new StringBuilder();
         int len1 = s.length()-1,len2 = t.length()-1;
         while(len1-->=0 ||len2-->=0){
             if(stringBuilder1.isEmpty()){
                 stringBuilder1.append(s.charAt(len1));
                 continue;
             }else if(stringBuilder2.isEmpty()){
                   stringBuilder2.append(t.charAt(len2));
                   continue;
             }
             if(s.charAt(len1)=='#'){
                 stringBuilder1.deleteCharAt(stringBuilder1.length()-1);
             }else{
                 stringBuilder1.append(s.charAt(len1));
             }
             if(t.charAt(len2)=='#'){
                 stringBuilder2.deleteCharAt(stringBuilder2.length()-1);
             }else{
                 stringBuilder2.append(t.charAt(len2));
             }
         }
         return stringBuilder1.equals(stringBuilder2);
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        Deque<Integer> deque = new ArrayDeque<>();
//        System.out.println(decodeString("3[a]2[bc]"));
        //        System.out.println(calculate("3+2*2"));
//        System.out.println(backspaceCompare("aaa", "aaa"));
    }
}
