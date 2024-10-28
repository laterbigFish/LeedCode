package LeedCode;

import java.util.Arrays;

public class demo4 {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("原数组: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return; // 如果数组长度小于2，直接返回

        int mid = arr.length / 2; // 找到中间索引
        int[] left = Arrays.copyOfRange(arr, 0, mid); // 左半部分
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // 右半部分

        mergeSort(left); // 递归排序左半部分
        mergeSort(right); // 递归排序右半部分
        int[] temp = new int[right-left+1];
    }
//
//    private static void merge(int[] arr, int[] left, int[] right) {
//        int i = 0, j = 0, k = 0;
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j]) {
//                arr[k++] = left[i++];
//            } else {
//                arr[k++] = right[j++];
//            }
//        }
//        while (i < left.length) {
//            arr[k++] = left[i++];
//        }
//        while (j < right.length) {
//            arr[k++] = right[j++];
//        }
//    }
}
