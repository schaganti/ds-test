package chags.io.ds;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {

        PartitionLabels partitionLabels = new PartitionLabels();
        partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
    }


    public List<Integer> partitionLabels(String S) {
        // get the last seen index for each letter 'a' - 'z'
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int boundary = 0, cnt = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            // update boundary and cnt along the way
            char curChar = S.charAt(i);
            boundary = Math.max(boundary, last[curChar - 'a']);
            cnt++;
            // if we reach the boundary, we collect result and reset count to 0
            if (i == boundary) {
                ans.add(cnt);
                cnt = 0;
            }
        }
        return ans;
    }
//    public List<Integer> partitionLabels(String S) {
//
//        List<Integer> partitions = new ArrayList<>();
//
//        char[] chars = S.toCharArray();
//        Map<Character, Integer[]> characterEntryMap = new HashMap<>();
//
//        for (int i = 0; i < chars.length; i++) {
//            int finalI = i;
//            characterEntryMap.put(chars[i], characterEntryMap.compute(chars[i], (character, integers) -> {
//                if (integers == null) {
//                    return new Integer[]{finalI, finalI};
//                } else {
//                    integers[1] = finalI;
//                }
//                return integers;
//            }));
//        }
//
//        List<Integer[]> entries = characterEntryMap.entrySet().stream().map(e -> e.getValue()).sorted((o1, o2) -> o1[0].compareTo(o2[0])).collect(Collectors.toList());
//        List<Integer[]> ranges = new ArrayList<>();
//
//        entries.forEach( e -> {
//            if (ranges.size() == 0) {
//                ranges.add(e);
//            } else {
//                Integer[] lastRange = ranges.get(ranges.size() - 1);
//                if(e[1] > lastRange[1])  {
//                    if(e[0] > lastRange[1]) {
//                        ranges.add(e);
//                    } else {
//                        lastRange[1] = e[1];
//                    }
//                }
//            }
//        });
//
//        return ranges.stream().map(e -> (e[1]-e[0])+1).collect(Collectors.toList());
//
//    }
}
