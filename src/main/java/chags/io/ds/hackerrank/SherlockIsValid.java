package chags.io.ds.hackerrank;

public class SherlockIsValid {

    public static String isValid(String s) {
        char[] arr = s.toCharArray();
        int[] charArr = new int[128];
        for(int i=0;i<arr.length; i++) {
            charArr[arr[i]]++;
        }
        int[][] uniqueCounts = new int[2][2];
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] != 0) {
                if(uniqueCounts[0][0] == 0 || uniqueCounts[0][0] == charArr[i]) {
                    uniqueCounts[0][0] = charArr[i];
                    uniqueCounts[0][1]++;
                } else if(uniqueCounts[1][0] == 0 || uniqueCounts[1][0] == charArr[i]) {
                    uniqueCounts[1][0] = charArr[i];
                    uniqueCounts[1][1]++;
                } else {
                    return "NO";
                }
            }
        }
        return uniqueCounts[0][1] > 1 && uniqueCounts[0][1] > 1 ? "NO" : "YES";
    }

    public static void main(String[] args) {
        System.out.println(SherlockIsValid.isValid("abcdefghhgfedecba"));
    }
}
