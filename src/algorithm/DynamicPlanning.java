package algorithm;

/**
 * @author : championjing
 * @version V1.0
 * @Description: 递归和动态规划都是讲原有问题拆成多个子问题然后求解，他们之间的最本质区别是，
 * 动态规划保存了子问题的姐，避免重复计算。
 * @date Date : 2020年11月02日 17:24
 */
public class DynamicPlanning {

    /**
     * desc：有N阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法
     * 思路：上第n个台阶的方式有几种，上n-1台阶的方式有几种……
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n>2)
        return 0;
    }

}
