package chags.io.ds.hackerrank;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class AlternatingCharacters {

    public static int alternatingCharacters(String s) {

        char[] charArr = s.toCharArray();
        int delCount = 0;
        char prevChar = 'X';
        for(int i=0;i<charArr.length; i++) {
            if(prevChar==charArr[i]) {
                delCount++;
            }
            prevChar=charArr[i];
        }
        return delCount;
    }

}
