package chags.io.ds.hackerrank;

import java.util.*;

public class TwoStrings {
    public static int alternate(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        Set<Character> ignoreChars = new HashSet<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                if (chars[i] == chars[i - 1]) {
                    ignoreChars.add(chars[i]);
                }
            }
            if (!ignoreChars.contains(chars[i])) {
                charCountMap.compute(chars[i], (k, v) -> {
                    return v == null ? 1 : v + 1;
                });
            } else {
                charCountMap.remove(chars[i]);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((e1, e2) -> {
            return e2 - e1;
        });

        charCountMap.entrySet().stream().map(e -> e.getValue()).forEach(e -> priorityQueue.offer(e));

        int lastValueRead = 0;
        while (priorityQueue.size() > 0) {
            Integer newValue = priorityQueue.poll();
            if((newValue == lastValueRead) || (lastValueRead - newValue) == 1) {
                return newValue+lastValueRead;
            }
            if (lastValueRead == 0) {
                lastValueRead = newValue;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(alternate("asvkugfiugsalddlasguifgukvsa"));

    }
}
