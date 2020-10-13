package sort;

import org.junit.Test;

/**
 * @author : champion
 * @version V1.0
 * @Description:
 * @date Date : 2020年08月20日 16:54
 */
public class IntegerRotate {

    @Test
    public void test() {
//        System.out.println( reverse(123) );
        System.out.println( 1 << 30 );
    }
    private void reverseChars(char[] cc){
        for(int i=0; i< cc.length/2 ; i++) {
            char temp = cc[i];
            cc[i] = cc[cc.length-1-i];
            cc[cc.length-1-i] = temp;
        }
    }
    public int reverse(int x) {
        int temp = x;
        if ( x < 0 ){
            temp = -x;
        }
        if (temp >((1<<32)-1)) {
            return 0;
        }
        String str = String.valueOf(temp);
        char[] cs = str.toCharArray();
        reverseChars(cs);
        String string = String.valueOf( cs );
        if (x>0) {
            return Integer.parseInt(string);
        } else {
            return -Integer.parseInt(string);
        }
    }

    public long tens( long count ) {
        String str = "1";
        while (count>0) {
            str += "0";
            count--;
        }
        return Integer.parseInt( str );
    }
}
