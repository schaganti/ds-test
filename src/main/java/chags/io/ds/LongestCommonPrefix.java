package chags.io.ds;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.printf(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }

    public String longestCommonPrefix(String[] strs) {
        Map<String,Integer> charCountMap = new HashMap<>();

        Stream.of(strs).forEach(str -> {
            char[] strChars = str.toCharArray();
            String tempStr = "";
            for (int i = 0; i < strChars.length; i++) {
                tempStr = tempStr + strChars[i];
                charCountMap.compute(tempStr, (k,v) -> v == null ? 1 : v+1);
            }
        });

        return charCountMap.entrySet().stream().filter(e -> e.getValue() == strs.length).map(Map.Entry::getKey).max(comparingInt(String::length)).orElse("");


    }


//    public String longestCommonPrefix(String[] strs) {
//
//        if(strs == null || strs.length == 0) return "";
//
//        String longest = strs[0];
//
//        for(int i=1; i< strs.length; i++) {
//            if(strs[i].length() < longest.length()) {
//                longest = strs[i];
//            } else {
//                strs[i] = strs[i].substring(0, longest.length());
//            }
//        }
//
//        for(int i=0; i<longest.length(); i++) {
//
//            boolean matches = true;
//            for(int j=0; j< strs.length; j++) {
//                if(!strs[j].startsWith(longest)) {
//                    matches = false;
//                    break;
//                }
//            }
//            if(matches) return longest;
//            if(longest.length() != 1)
//                longest = longest.substring(0, longest.length()-2);
//        }
//        return "";
//    }

}
