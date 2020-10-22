package src;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : championjing
 * @ClassName: Junior
 * @Description: 初级算法题，字符串篇
 * @Date: 2020-10-22 22:15
 */
public class Junior {
    
    @Test
    public void test(){
        String s = "loveleetcode";
        System.out.println( firstUniqChar( s ) );
    }

    public int firstUniqChar(String s) {
        //HashMap 无需，LinkedHashMap有序
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i),i+1);
            } else if ( count > 0  ){
                map.put(s.charAt(i), -count);
            }
        }
        for ( Integer j: map.values()) {
            if (j >0 ) {
                return j-1;
            }
        }
        
        return -1;
    }
}
