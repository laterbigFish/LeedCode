package Sort;

import java.util.Map;
import java.util.Random;

public class demo {
    //归并
    public static void mergeSort(int[] array,int left,int right){
        if(left>=right) return;
        int mid = (left+right)/2;

        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);

        int[] tmp = new int[right-left+1];

        int cur1 = left,cur2 = mid+1,i = 0;
        while(cur1<=mid && cur2<=right)
            tmp[i++] = array[cur1]<=array[cur2]?array[cur1++]: array[cur2++];

        //将剩余插入进数组
        while(cur1<=mid) tmp[i++] = array[cur1++];
        while(cur2<=right) tmp[i++] = array[cur2++];

        for(int k = left;k<=right;k++){
            array[i] = tmp[k-left];
        }
    }
     public static void  MYquickSort(int[] array,int l,int r){
         if(l>=r) return;
         //使其不断的趋近于有序
         int keyNumber = array[new Random().nextInt(r-l+1)+1];
         int left = l+1,right = r+1,i = l;
         while(i<right){
             if(array[i]<keyNumber){
                 swap(array,++left,i++);
             }else if(array[i]>keyNumber){
                 swap(array,-right,i);
             }else{
                 i++;
             }
         }
         //不断地进行递归
         MYquickSort(array,l,right);
         MYquickSort(array,right,r);
     }
     public static void  swap(int[] array,int index1,int index2){
         int tmp = array[index1];
         array[index1] = array[index2];
         array[index2] = tmp;
     }
    public static void main(String[] args) {

    }
}
