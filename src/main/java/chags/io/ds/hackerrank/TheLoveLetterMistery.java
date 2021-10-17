package chags.io.ds.hackerrank;

public class TheLoveLetterMistery {

    public static int theLoveLetterMystery(String s) {
        char[] chars = s.toCharArray();
        int totalChanges = 0;
        for (int j = s.length() - 1, i = 0; j >= i; i++, j--) {
            int start = chars[i];
            int end = chars[j];
            int diff = start > end ? start-end : end-start;
            totalChanges = totalChanges+diff;
        }
        return totalChanges;
    }

    public static void main(String[] args) {
        System.out.println(theLoveLetterMystery("abcd"));
    }

}
