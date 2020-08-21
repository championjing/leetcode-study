package array;

import java.util.Arrays;

/**
 * @author : champion
 * @version V1.0
 * @Description:
 * @date Date : 2020年06月08日 12:57
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString( intersect(nums1,nums2) ) );
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return find( nums2, nums1 );
        } else {
            return find( nums1, nums2 );
        }
    }
    public static int[] find(int[] one, int[] two){
        int[] res = new int[one.length];
        for (int i=0;i<res.length;i++){
            res[i] = -1;
        }
        for( int i=0;i<one.length;i++ ) {
            int k=0;
            for( int j=0;j<two.length && i<one.length; j++ ) {
                if( two[j] == one[i] ) {
                    res[k++] = one[i++];
                } else {
                    if(k != 0) {
                        break;
                    }
                }
            }
            if(k!=0) {
                break;
            }
        }
        int len = 0;
        for (int i=0;i<res.length;i++) {
            if ( res[i] == -1 ) {
                break;
            }
            len+=1;
        }
        int[] result = new int[len];
        for (int i=0;i<len;i++) {
            result[i] = res[i];
        }
        return result;
    }
}
