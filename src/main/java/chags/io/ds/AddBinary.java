package chags.io.ds;
/*

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.

 */
public class AddBinary
{

    public static void main(String[] args) {

        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;

        String result = "";

        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int length = a.length() > b.length() ? a.length()-1 : b.length()-1;

        int carry = 0;

        while(aIndex >=0 || bIndex >=0) {
            int aVal = aIndex != -1 ? a.charAt(aIndex--) - '0' : 0;
            int bVal = bIndex != -1 ? b.charAt(bIndex--) - '0' : 0;
            result = ((aVal + bVal + carry)  % 2)+result;
            carry = (aVal + bVal + carry)  / 2;
        }

        if(carry != 0) {
            result = carry + result;
        }

        return result;
    }
}
