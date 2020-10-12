package array;

import java.util.Arrays;

/**
 * @author : champion
 * @version V1.0
 * @Description: 判断数组中是否有重复元素
 * @date Date : 2020年06月01日 17:30
 */
public class CheckRepeat {

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,8,9,2,0};
        int[] result = new int[nums.length];
        mergeSortRecursive(nums,result,0,nums.length-1);
        System.out.println(Arrays.toString( result ) );
    }

    /**
     * 插入排序
     * @param nums
     */
    private static void insertSort(int[] nums) {

    }
    /**
     * 选择排序
     * @param nums
     */
    private static void selectSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int gap = nums.length/2;

    }

    public static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = start+ (len>>1);
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr,result,start1,end1);
        mergeSortRecursive(arr,result,start2,end2);
        int k= start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++]:arr[start2++];
        }
        while (start1<=end1) {
            result[k++] = arr[start1++];
        }
        while (start2<=end2) {
            result[k++] = arr[start2++];
        }
        for (k=start;k<=end;k++) {
            arr[k] = result[k];
        }
    }
}
