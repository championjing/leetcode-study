package src.sort;

import java.util.Arrays;

/**
 * @author : championjing
 * @ClassName: QuickSort
 * @Description: 快速排序，选择一个基准点，左侧比基准点小，右侧比基准点大
 * 
 *  平均时间复杂度：O(NlogN)
 * 最佳时间复杂度：O(NlogN)
 * 最差时间复杂度：O(N^2)
 * @Date: 2020-06-06 10:30
 */
public class QuickSort {
    
    public static void main(String[] args) {
        int[] arr = {5,12,6,23,7,1,7,32,8,9,0};
        sort(0,arr.length-1,arr);
        System.out.println(Arrays.toString( arr ) );
    }
    
    public static void sort(int start,int end,int[] arr){
        if ( start>=end ) {
            return;
        }
        int midValue = arr[end];
        int left = start, right = end-1;
        while (left<right) {
            while(arr[left] <= midValue && left <right) {
                left++;
            }
            while(arr[right] >= midValue && left <right) {
                right--;
            }
            swap(left,right,arr);
        }
        if (arr[left] >=arr[end]) {
            swap(left,end,arr);
        } else {
            left++;
        }
        sort(start,left-1,arr);
        sort(left+1,end,arr);
         
    }
    private static void swap(int x,int y,int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
}
