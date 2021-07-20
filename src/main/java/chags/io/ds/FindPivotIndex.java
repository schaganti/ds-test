package chags.io.ds;

import java.util.HashMap;
import java.util.Map;

public class FindPivotIndex {

    //[1,7,3,6,5,6]
    //[1,8,11,17,22,28]
    public int pivotIndex(int[] nums) {

        Map<Integer, Integer> forwardSumMap = new HashMap<>();

        if (nums == null || nums.length == 0) return -1;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            forwardSumMap.put(i, sum);
        }

        sum = 0;

        int pivot = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum = sum + nums[i];
            if (forwardSumMap.get(i) == sum) {
                pivot = i;
            }
        }
        return pivot;
    }

    //[1,8,11,17,22,28]
    //[1,7,3,6,5,6]

    //[27,20,17,11,6,0]
//    public int pivotIndex(int[] nums) {
//
//        Map<Integer, Integer> sumMap = new HashMap<>();
//        int sum = 0;
//        for (int i = nums.length-1; i >= 0; i--) {
//            sumMap.put(i, sum);
//            sum = sum + nums[i];
//        }
//
//        sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(sum == sumMap.get(i)) {
//                return i;
//            }
//            sum = sum + nums[i];
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int pivotIndex = findPivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(pivotIndex);
    }
}
