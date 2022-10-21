import java.util.* ;
import java.io.*; 
public class Solution {
    static int mexString(String A) {
        if(A.length()==1&&A.charAt(0)=='0')return 0;
        int i=0;
        for(;i<A.length();i++)
            if(A.charAt(i)=='0')return 2;
        return 1;
    }
}
