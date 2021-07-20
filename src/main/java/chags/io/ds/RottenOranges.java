package chags.io.ds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RottenOranges {
    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.orangesRotting(grid));
    }

    private int orangesRotting(int[][] grid) {

        HashSet<String> rotten = new HashSet<>();
        HashSet<String> fresh = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int orange = grid[i][j];
                if (orange == 2) {
                    rotten.add(i + "" + j);
                }
                if (orange == 1) {
                    fresh.add(i + "" + j);
                }
            }
        }

        int[][] xy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int days = 0;

        HashSet<String> newRotten = new HashSet<>(rotten);

        LinkedList s = null;
        boolean addedRotten = true;

        while (addedRotten) {
            addedRotten = false;
            for (String r : rotten) {
                for (int i = 0; i < xy.length; i++) {
                    int[] cor = xy[i];
                    int x = (r.charAt(0) - '0') + cor[0];
                    int y = (r.charAt(1) - '0') + cor[1];
                    if (fresh.contains(x + "" + y)) {
                        addedRotten = true;
                        fresh.remove(x + "" + y);
                        newRotten.add(x + "" + y);
                    }
                }
            }
            if (addedRotten) days++;
            rotten.addAll(newRotten);
        }
        if(fresh.size() == 0) {
            return days;
        } else {
            return -1;
        }
    }
}
