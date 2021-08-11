package chags.io.ds.fb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeros().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void moveZeroes(int[] nums) {
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroQueue.offer(i);
            } else if (!zeroQueue.isEmpty()) {
                int firstZeroIndex = zeroQueue.poll();
                nums[firstZeroIndex] = nums[i];
                nums[i] = 0;
                zeroQueue.offer(i);
            }
        }
    }
}
