package chags.io.ds.fb;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChars longestLength = new LongestSubStringWithoutRepeatingChars();
        System.out.println(longestLength.lengthOfLongestSubstring("bbbbb"));

    }
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        String  readCharStr = new String("");

        int longestLength = 1;

        for(int i=0;i<chars.length; i++) {
            String ch = "" + chars[i];
            if(!readCharStr.contains(ch)) {
                readCharStr = readCharStr + ch;
            } else {
                longestLength = Math.max(longestLength,readCharStr.length());
                readCharStr = trim(readCharStr, ch);
                readCharStr = readCharStr + ch;
                if(i==chars.length-1) {
                    readCharStr = trim(readCharStr, ch);
                }
            }
        }

        return Math.max(readCharStr.length(), longestLength);
    }
    public String trim(String readCharStr, String ch) {
        while (readCharStr.contains(ch)) {
            readCharStr = readCharStr.substring(1);
        }
        return readCharStr;
    }

}
