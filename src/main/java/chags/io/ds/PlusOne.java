package chags.io.ds;
/*

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.


 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length ==0) return digits;
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
             if(digits[i]+carry == 10) {
                 digits[i] = 0;
                 carry = 1;
             } else {
                 digits[i] = digits[i] + carry;
                 carry = 0;
             }
        }

        if(carry == 1) {
            int[] copy = new int[digits.length+1];
            copy[0] =  carry;
            for (int i = 1; i < digits.length; i++) {
                copy[i] =  digits[i];
            }
            return  copy;
        } else {
            return digits;
        }
    }
}
