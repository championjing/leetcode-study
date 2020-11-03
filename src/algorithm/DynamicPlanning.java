package algorithm;

import org.junit.Test;

/**
 * @author : championjing
 * @version V1.0
 * @Description: 递归和动态规划都是讲原有问题拆成多个子问题然后求解，他们之间的最本质区别是，
 * 动态规划保存了子问题的姐，避免重复计算。
 * @date Date : 2020年11月02日 17:24
 */
public class DynamicPlanning {

    /**
     * 1. 递归方式
     * desc：有N阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法
     * 思路：上第i个台阶的方式有几种，上i-1台阶的方式加上i-2台阶的方式
     * 这是使用递归的方式
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n==2) {
            return 2;
        } else if (n==1) {
            return 1;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 2. 记忆化递归
     * 使用记忆化递归的方式，因为上面的递归有很多重复的计算，所以记忆递归使用一个数组（或者其他类型）来记录每次计算结果，减少重复计算
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n+1];

        return climbStairsMemory( n, memo );
    }

    public int climbStairsMemory(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            memo[n] = 1;
        } else if ( n == 2) {
            memo[n] = 2;
        } else {
            memo[n] = climbStairsMemory(n-1, memo) + climbStairsMemory(n-2, memo);
        }
        return memo[n];
    }

    /**
     * 3. 动态规划方式
     * @param n
     * @return
     */
    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for ( int i=3; i<=n ; i++ ) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 4. 斐波那锲数列方式  -  滚动数组的方式
     * 其实每次只使用了前两个数就能计算出第三个数，那么让这三个数进行滚动计算就可以了
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i=3;i<=n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 当n=50时，三种算法所耗费的时间已经有巨大差距
     */
    @Test
    public void testClimbStairs() {
        System.out.println("start ---------");
        long start = System.currentTimeMillis();
        int n = 40;
//        System.out.println( climbStairs(n) );
//        System.out.println( climbStairs2(n) );
        System.out.println( climbStairsDP(n) );
        long end = System.currentTimeMillis();
        System.out.println( end-start );
        System.out.println("end ----------");
    }

}
