package array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class DeleteRepeat {

    public static void main(String[] args) {
        DeleteRepeat s1 = new DeleteRepeat();

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        s1.removeDuplicates(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
    
    /**
     * 认真审题，主要修饰语给出的条件，和最后要求的结果。O(1)额外空间，说明只能在当前数组上进行操作。
     * 
     * 这时可借助一个索引的变量，记录长度，并把不重复的值放入到i点之后（可以保证number<=i）
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }
        number += 1;
        return number;
    }
}