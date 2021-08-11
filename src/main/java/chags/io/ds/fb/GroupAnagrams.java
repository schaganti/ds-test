package chags.io.ds.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagramListMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            int[] tempChars = new int[128];
            char[] chars = strs[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                tempChars[chars[j]] += 1;
            }

            String key = "";

            for (int j = 0; j < tempChars.length; j++) {
                if (tempChars[j] >= 1) {
                    for (int k = 0; k < tempChars[j]; k++) {
                        key = key + "" + Character.valueOf((char) j);
                    }
                }
            }

            int finalI = i;

            anagramListMap.compute(key, (k, v) -> {
                List<String> list = v == null ? new ArrayList<>() : v;
                if (v == null) {
                    list.add(strs[finalI]);
                } else {
                    list.add(strs[finalI]);
                }
                return list;
            });
        }

        List<List<String>> result = anagramListMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());

        return result;
    }
}
