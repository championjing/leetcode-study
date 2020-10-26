package src.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : championjing
 * @version V1.0
 * @Description: ��Ҫ�������㷨
 * @date Date : 2020��10��12�� 15:36
 */
public class Main {

    public static void main(String[] args) {
//        int[] arr = {6,8,2,9,1,22,15,18};
        int[] arr = {110,100,90,40,80,20,60,10,30,50,70};
        initHeap( arr );
//        bubble(arr);
        //quick( arr, 0,arr.length-1 );
        //insert( arr );
        System.out.println(Arrays.toString( arr ) );
    }

    /**
     * ð������, ��i���������ϵ�����Ƚϣ�
     * @param arr
     */
    public static void bubble(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {   // ����˵��Ϊʲô��Ҫ-1
                if( arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    /**
     * ѡ������������δ������������ҵ���С(or���)Ԫ�أ�Ȼ�����ŵ����е���ʼλ�ã����ţ��ٴ�ʣ��δ�����Ԫ����
     * ����Ѱ����С(or���)Ԫ�أ�Ȼ��ŵ����������е�ĩβ��
     * @param arr
     */
    public static void select(int[] arr){
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1;j<arr.length; j++) {
                if (arr[i]>arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * ��������ѡ��һ����׼����ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�����һ���ֵ��������ݶ�ҪС��
     * Ȼ���ٰ��մ˷������������������ݷֱ���п��������������̿��Եع���У�һ�δﵽ�������ݱ������
     * @param arr
     */
    public static void quick(int[] arr,int r,int l){
        if ( r >= l ) {
            return ;
        } else {
            int povitIndex = r;
            for (int i=r;i<l;i++) {
                if ( arr[i] < arr[povitIndex] ) {
                    for ( int j=i;j>povitIndex; j-- ) {
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

    /**
     *
     * ��n���������Ԫ�ؿ���Ϊһ��������һ���������ʼʱ�������ֻ����1��Ԫ�أ�������а�����n-1��Ԫ�أ�
     * ���������ÿ�δ��������ȡ����һ��Ԫ�أ��������뵽������е��ʵ�λ�ã�ʹ֮��Ϊ�µ�������ظ�n-1�ο�����������
     * @param arr
     */
    public static void insert(int[] arr){
        for (int i=1; i<arr.length; i++) {
            for ( int j=i ;j>0; j-- ) {
                if ( arr[j] < arr[j-1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * һ�ַ���Ĳ�������
     * @param arr
     */
    public static void shell(int[] arr){
        int length = arr.length;

        //gapΪ������ÿ�μ�Ϊԭ����һ��
        for ( int gap=length/2; gap>0 ; gap/=2) {
            //��gap���飬��ÿ�鶼ִ��ֱ�Ӳ�������
            for (int i=0; i<gap; i++) {
                for (int j=i+gap; j<length; j+=gap) {
                    //��ǰ�������һλ�����ֵ�����Բ���Ҫһֱ��ǰ�Ƚ�
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

    public static void heap(int[] arr){
        int i = arr.length/2 - 1;
//        if ()
    }
    public static void initHeap(int[] arr){
        for ( int i = arr.length/2 - 1; i>=0; i-- ) {
            int pIndex = (i-1)/2;
            int lIndex = 2*i + 1;
            int rIndex = 2*i + 2;
            if ( arr[lIndex] > arr[pIndex] ) {
                int temp = arr[lIndex];
                arr[lIndex] = arr[pIndex];
                arr[pIndex] = temp;
            }
            if ( arr[rIndex] > arr[pIndex] ) {
                int temp = arr[rIndex];
                arr[rIndex] = arr[pIndex];
                arr[pIndex] = temp;
            }
            System.out.println(Arrays.toString( arr ));
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
            System.out.println("��������:"+num.getN());
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
