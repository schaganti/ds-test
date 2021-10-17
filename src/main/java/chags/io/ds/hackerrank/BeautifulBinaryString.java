package chags.io.ds.hackerrank;

public class BeautifulBinaryString {

    public static int beautifulBinaryString(String b) {

        char[] chars = b.toCharArray();
        int start =0;
        int end =2;
        int count = 0;
        while(end<b.length() && start<end) {
            String str ="";
            str+=""+chars[start]+chars[start+1]+chars[end];
            if("010".equals(str)) {
                chars[start+2] = chars[start+2] == '0' ? '1' : '0';
                count++;
            }
            start=start+1;
            end = end+1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(beautifulBinaryString("0100101010"));
    }
}
