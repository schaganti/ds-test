package chags.io.ds;

import java.util.stream.Stream;

public class ReverseAString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseAString().reverseStringRecursive(s, 0, s.length-1);
        Stream.of(s).forEach(System.out::print);
    }

    public void reverseStringRecursive(char[] s, int start, int end) {
        if(start < s.length/2) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            reverseStringRecursive(s, ++start, --end);
        }

    }

}
