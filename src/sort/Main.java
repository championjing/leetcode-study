package sort;

import java.util.Arrays;

/**
 * @author : championjing
 * @version V1.0
 * @Description: 重要的排序算法
 * @date Date : 2020年10月12日 15:36
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {6,8,2,9,1,22,15,18};
        quick( arr, 0,arr.length-1 );
        System.out.println(Arrays.toString( arr ) );
    }

    /**
     * 快速排序：选中一个基准数，通过一趟排序讲要排序的数据分割成独立的两部分，其中一部分的所有数据都比另一部分的所有数据都要小，
     * 然后再按照此方法对着两个部分数据分别进行快速排序，整个过程可以地柜进行，一次达到整个数据变的有序
     * @param arr
     */
    public static void quick(int[] arr,int r,int l){
        if ( r >= l ) {
            return ;
        } else {
            int povitIndex = r;
            for (int i=r;i<l;i++) {
                if ( arr[i] < arr[povitIndex] ) {
                    for ( int j=i;j>=povitIndex; j-- ) {
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                    povitIndex++;
                }
            }
            quick(arr, r,povitIndex);
            quick(arr, povitIndex+1,l);
        }
    }
}
