package src;

import org.junit.Test;

import java.util.*;

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
    
    @Test
    public void testPalindrome(){
        String str = "race a car";
        System.out.println( isPalindrome( str ) );
    }
    
    public boolean isPalindrome(String s) {
        String reg = "[0-9]|[a-z]|[A-Z]";
        List<String> strs = new ArrayList<>();
        for ( int i=0; i<s.length(); i++ ) {
            if ( String.valueOf(s.charAt(i)).matches( reg ) ) {
                strs.add( String.valueOf(s.charAt(i)) );
            }
        }
        
        for (int i=0;i<strs.size()/2;i++) {
            if ( strs.get( i ).equalsIgnoreCase(  strs.get( strs.size()-1-i ) ) ) {
                
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(String s) {
        //Character.isLetterOrDigit()
                return false;
    }
    
    @Test
    public void testIsAnagram(){
        String s = "ab", t = "a";
        System.out.println( isAnagram( s, t ) );
    }

    public boolean isAnagram(String s, String t) {
        if( s.length() < t.length() ){
            String temp = s;
            s = t;
            t = temp;
        }
        
        boolean[] lettersFlag = new boolean[26];
        for ( int i=0;i<s.length();i++ ) {
            //System.out.println( Integer.valueOf( s.charAt(i) ) -97 );
            lettersFlag[Integer.valueOf( s.charAt(i) ) -97 ] = true;
        }
        for ( int i=0;i<t.length();i++ ) {
            if (!lettersFlag[Integer.valueOf( t.charAt(i) )-97]){
                return false;
            } else {
                //System.out.println("Y");
            }
        } 
        
        return true;
    }
    
    @Test
    public void testReg(){
        String reg = "[0-9]|[a-z]|[A-Z]";
        System.out.println( "a".matches(reg) );
        System.out.println( "1".matches(reg) );
        System.out.println( "Z".matches(reg) );
        System.out.println( "A".equalsIgnoreCase( "a" ) );
    }
}
