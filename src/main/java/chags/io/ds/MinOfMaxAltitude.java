package chags.io.ds;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinOfMaxAltitude {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 1}
        };

        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> o2-o1);
        //minOfMaxAltitude(matrix, 0, 0, integers);
        System.out.println("Result-"+minMaxScore(matrix));
        //System.out.println("Result-"+integers.poll());
    }


    public static int minMaxScore(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        dp[0] = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (j == 0 && i != 0) {
                    dp[j] = Math.min(matrix[i][j], dp[j]);
                } else if (j != 0 && i == 0) {
                    dp[j] = Math.min(matrix[i][j], dp[j - 1]);
                } else {
                    dp[j] = Math.min(Math.max(dp[j], dp[j - 1]), matrix[i][j]);
                }
            }
        }
        return dp[n - 1];
    }

//    public static int minOfMaxAltitude(int[][] arr, int i, int j, PriorityQueue<Integer> integers) {
//
//        if (arr.length - 1 == i && j == arr[0].length - 1) {
//            System.out.println(integers);
//            return Integer.MAX_VALUE;
//        }
//
//        System.out.println(i + "," + j + "=" + arr[i][j]);
//
//        int val1 = Integer.MAX_VALUE;
//        int val2 = Integer.MAX_VALUE;
//        int currentVal = Integer.MAX_VALUE;
//
//        if (i < arr.length - 1) {
//            val1 = minOfMaxAltitude(arr, i + 1, j, integers);
//        }
//        if (j < arr[0].length - 1) {
//            val2 = minOfMaxAltitude(arr, i, j + 1, integers);
//        }
//        currentVal = i==0 && j==0 ? currentVal : arr[i][j];
//        int min = Integer.min(Integer.min(val1, val2), currentVal);
//        System.out.println(min);
//        integers.offer(min);
//        return min;
//    }
}
