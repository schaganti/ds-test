package chags.io.ds.hackerrank;

import java.util.Arrays;
import java.util.List;

public class GemStone {
    public static int gemstones(List<String> arr) {

        if(arr == null || arr.size() == 0) {
            return 0;
        }

        int[]  chars = new int[26];

        for(int i=0; i<arr.size(); i++) {
            int[]  tempCharsCounts = new int[26];
            char[] tempChars = arr.get(i).toCharArray();
            for(int j=0; j<tempChars.length; j++) {
                if(tempChars[j]-97 <=25)
                    tempCharsCounts[tempChars[j]-97] = 1;
            }
            for(int j=0; j<tempCharsCounts.length; j++) {
                chars[j] += tempCharsCounts[j];
            }
        }

        int count=0;
        for(int i=0; i<chars.length; i++) {
            if(chars[i] == arr.size()) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(gemstones(Arrays.asList("abcdde", "baccd", "eeabg")));
    }
}
