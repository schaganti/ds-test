package chags.io.ds.hackerrank;

public class AnagramRemoveString {
    public static int makeAnagram(String a, String b) {

        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int[] aChars = new int[128];
        int[] bChars = new int[128];
        for(int i=0; i<aArr.length; i++) {
            aChars[aArr[i]]++;
        }
        for(int i=0; i<bArr.length; i++) {
            bChars[bArr[i]]++;
        }

        int removeCount = 0;
        for(int i=0; i<aChars.length; i++) {
            if(aChars[i] != bChars[i]) {
                removeCount += aChars[i] > bChars[i] ? aChars[i] - bChars[i] : bChars[i] - aChars[i];
            }
        }
        return removeCount;
    }

    public static void main(String[] args) {
        System.out.println(AnagramRemoveString.makeAnagram("cdse", "dcee"));
    }


}
