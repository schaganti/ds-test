package chags.io.ds;

import java.util.*;

public class OptimalPair {
    public static void main(String[] args) {

        OptimalPair optimalPair = new OptimalPair();

        List<int[]> list1 = Arrays.asList(new int[]{1, 3}, new int[]{2, 5}, new int[]{3, 7}, new int[]{4, 10});
        List<int[]> list2 = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5});
        List<Integer[]> result = optimalPair.find(list1, list2, 10);
        result.forEach(e -> System.out.println(e[0]+","+e[1]));
    }

    private List<Integer[]> find(List<int[]> list1, List<int[]> list2, int target) {

        List<Integer[]> list = new ArrayList<>(); 

        int lastMax = Integer.MIN_VALUE;

        for (int i = 0; i < list1.size(); i++) {
            for(int j = 0; j<list2.size(); j++) {
                int sum = list1.get(i)[1] + list2.get(j)[1];
                if(sum <= target) {
                    if (sum > lastMax) {
                        lastMax = sum;
                        list.clear();
                        list.add(new Integer[]{list1.get(i)[0], list2.get(j)[0]});
                    } else if(sum  == lastMax) {
                        list.add(new Integer[]{list1.get(i)[0], list2.get(j)[0]});
                    }
                }
            }
        }
        return list;
    }
}
