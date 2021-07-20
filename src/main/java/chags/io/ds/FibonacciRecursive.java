package chags.io.ds;

import java.util.HashMap;
import java.util.Map;

public class FibonacciRecursive {

    public int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public int fib(int n, Map<Integer, Integer> cache) {
        if(n<=1) {
            return n;
        }
        if(cache.get(n) != null) {
            return cache.get(n);
        } else {
            int result = fib(n-1, cache) + fib(n-2, cache);
            cache.put(n, result);
            System.out.println(result);
            return result;
        }
    }

    public static void main(String[] args) {
        FibonacciRecursive fibRecursive = new FibonacciRecursive();
        System.out.println("----"+fibRecursive.fib(10));
    }
}
