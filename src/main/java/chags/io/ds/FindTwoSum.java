package chags.io.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        FindTwoSum findTwoSum = new FindTwoSum();
        System.out.println(Arrays.toString(findTwoSum.twoSum(nums1, target1)));
//        int[] nums2 = {20, 50, 40, 25, 30, 10};
//        int target2 = 90;
//        System.out.println(Arrays.toString(Find2Sum(nums2, target2-30)));
//        int[] nums3 = {50, 20, 10, 40, 25, 30};
//        int target3 = 90;
//        System.out.println(Arrays.toString(Find2Sum(nums3, target3-30)));
//        int[] nums4 = {1, 2};
//        int target4 = 90;
//        System.out.println(Arrays.toString(Find2Sum(nums4, target4-30)));
    }

    //    private static int[] Find2Sum(int[] nums, int target) {
//
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        int[] var = {-1, -1};
//
//        for(int i = 0; i<nums.length; i++) {
//            if(indexMap.get(nums[i]) != null) {
//                 var[0] = i;
//                 var[1] = indexMap.get(nums[i]);
//            }
//            indexMap.put(target-nums[i], i);
//        }
//        return var;
//    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

}
