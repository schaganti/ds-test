package chags.io.ds;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
//        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairsBruteForce(0, 5));
    }

    public int climbStairs(int n) {

        HashMap<String, Integer> cache = new HashMap<>();
        int result = climbStairs(n, cache);
        System.out.println(cache);
        return result;
    }

    public int climbStairsBruteForce(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        int oneStep = climbStairsBruteForce(i + 1, n);
        int twoSteps = climbStairsBruteForce(i + 2, n);
        return oneStep + twoSteps;
    }

    public int climbStairs(int n, Map<String, Integer> cache) {

        if(n<0 ) {
            return 0;
        }
        if(n==0) {
            return 1;
        }

        String key = (n - 1) + "-" + (n - 2);
        if(cache.get(key) == null) {
            cache.put(key, climbStairs(n - 1, cache) + climbStairs(n - 2, cache));
        }
        return cache.get(key);

    }


}
