package chags.io.ds.fb;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        TreeMap<Integer,Integer> numCounts = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            numCounts.compute(currentNumber, (k,v) -> {
                if(v == null) {
                    return 1;
                } else {
                    return ++v;
                }
            });
        }

        int index = 0;
        for(Map.Entry<Integer,Integer> entry : numCounts.entrySet()) {
            nums[index++] = entry.getKey();
        }
        return numCounts.size();
    }

//    public int removeDuplicates(int[] nums) {
//
//        TreeMap<Integer,Integer> numCounts = new TreeMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int currentNumber = nums[i];
//            numCounts.compute(currentNumber, (k,v) -> {
//               if(v == null) {
//                   return 1;
//               } else {
//                   return ++v;
//               }
//            });
//        }
//
//        int index = 0;
//        for(Map.Entry<Integer,Integer> entry : numCounts.entrySet()) {
//            nums[index++] = entry.getKey();
//        }
//        return numCounts.size();
//    }
}
