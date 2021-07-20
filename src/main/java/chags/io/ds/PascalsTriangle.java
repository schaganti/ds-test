package chags.io.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<Integer> list = pascalsTriangle.getRow(33);
        System.out.println(list);
    }

    public List<Integer> getRow(int rowIndex) {

        ArrayList<Integer> list = new ArrayList<>();

        Map<String, Integer> computedResults = new HashMap<>();

        for (int col = 0; col < rowIndex+1; col++) {
            list.add(computeValue(rowIndex, col, computedResults));
        }
        return list;
    }

    public int computeValue(int row, int col, Map<String, Integer> computedResults) {

        String computedKey = row + "" + col;

        if(computedResults.get(computedKey) != null) {
            return computedResults.get(computedKey);
        }

        if(row == col || col == 0) {
            return 1;
        }

        int val = computeValue(row - 1, col - 1, computedResults) + computeValue(row - 1, col, computedResults);
        computedResults.put(computedKey, val);
        return val;
    }
}
