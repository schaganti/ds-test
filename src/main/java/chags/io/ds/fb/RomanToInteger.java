package chags.io.ds.fb;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
    }

    public int romanToInt(String s) {

        var romanCharToInt = new HashMap<Character, Integer>();
        romanCharToInt.put('I', 1);
        romanCharToInt.put('V', 5);
        romanCharToInt.put('X', 10);
        romanCharToInt.put('L', 50);
        romanCharToInt.put('C', 100);
        romanCharToInt.put('D', 500);
        romanCharToInt.put('M', 1000);

        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((i + 1 < chars.length) && (romanCharToInt.get(chars[i]) - romanCharToInt.get(chars[i + 1])) < 0) {
                result += (romanCharToInt.get(chars[i + 1]) - romanCharToInt.get(chars[i]));
                i = i + 1;
            } else {
                result += romanCharToInt.get(chars[i]);
            }
        }
        return result;

    }
}
