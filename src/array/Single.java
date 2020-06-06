package src.array;

/**
 * @author : championjing
 * @ClassName: Single
 * @Description: 找出不重复的元素
 * @Date: 2020-06-06 11:33
 */
public class Single {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        System.out.println( num );
    }
    
}
