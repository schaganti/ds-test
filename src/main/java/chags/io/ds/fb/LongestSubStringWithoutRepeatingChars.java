package chags.io.ds.fb;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChars longestLength = new LongestSubStringWithoutRepeatingChars();
        System.out.println(longestLength.lengthOfLongestSubstring("pwwkew"));

    }

    public int lengthOfLongestSubstring(String s) {

        char[] charSet = new char[128];
        int left = 0;
        int right = 0;
        int longestLength = 0;

        char[] chars = s.toCharArray();
        //"abcabcbb"
        for (int i = 0; i < chars.length; i++, right++) {
            int ch = chars[i];
            while (charSet[ch] != 0) {
                longestLength = Math.max((right - left), longestLength);
                charSet[chars[left]]--;
                left++;
            }
            charSet[ch]++;
        }
        return Math.max((right - left), longestLength);
    }
}
