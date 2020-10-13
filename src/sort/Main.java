package sort;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : championjing
 * @version V1.0
 * @Description: 重要的排序算法
 * @date Date : 2020年10月12日 15:36
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {6,8,2,9,1,22,15,18};
//        quick( arr, 0,arr.length-1 );
        insert(arr);
//        shell(arr);
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

    public static void insert(int[] arr){
        for (int i=1;i<arr.length; i++) {
            for ( int j=i; j>0; j-- ) {
                if ( arr[j] < arr[j-1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * 一种分组的插入排序
     * @param arr
     */
    public static void shell(int[] arr){
        int length = arr.length;

        //gap为补偿，每次减为原来的一半
        for ( int gap=length/2; gap>0 ; gap/=2) {
            //共gap个组，对每组都执行直接插入排序
            for (int i=0; i<gap; i++) {
                for (int j=i+gap; j<length; j+=gap) {
                    //因前部分最后一位是最大值，所以不需要一直往前比较
                    if ( arr[j] < arr[j-gap] ) {
                        int temp = arr[j];
                        int k = j-gap;
                        while ( k>=0 && arr[k]>temp ) {
                            arr[k+gap] = arr[k];
                            k -= gap;
                        }
                        arr[k+gap] = temp;
                    }
                }
            }
        }
    }

    @Test
    public void test(){
        Num num=new Num(1);
        testNum(num);
        System.out.println( num );
    }

    public void testNum(Num num){
        num.addAndGet(1);
        if (num.getN()>100) {
            System.out.println("方法体内:"+num.getN());
            return;
        }
        testNum( num );
    }
}
class Num{

    private int n;

    public Num(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void addAndGet(int m) {
        this.n = this.n+m;
    }
}
