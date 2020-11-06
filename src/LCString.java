import org.junit.Test;

/**
 * @author : championjing
 * @version V1.0
 * @Description: 字符串相关的题目(不易分类为哪类算法)
 * @date Date : 2020年11月05日 16:09
 */
public class LCString {

    @Test
    public void testCountSayOut() {
        System.out.println(countSayOut( 4 ));
    }

    public String countSayOut(int n) {
        if (n==1) {
            return "1";
        }
        String str = countSayOut( n-1 );
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        int start = 0;
        for ( int i=1; i<length+1 ; i++ ) {
            if ( i == length ) {
                sb.append( i-start ).append( str.charAt(start) );
            } else if (str.charAt( i ) != str.charAt( start )){
                sb.append( i - start ).append(str.charAt( start ));
                start = i;
            }
        }
        return sb.toString();
    }

    /**
     * 该方法递归调用放在前段，很好的方式
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        //递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int length = str.length();
        int start = 0;
        for (int i=1; i<length+1; i++) {
            if (i == length) {
                res.append( i-start ).append( str.charAt(start) );
                //知道start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start)) {
                res.append(i - start).append( str.charAt( start ) );
                start = i;
            }
        }
        return res.toString();
    }

}
