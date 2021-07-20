package chags.io.ds;

import java.util.List;

public class ZombieInMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };

        ZombieInMatrix zombieInMatrix = new ZombieInMatrix();
        System.out.println(zombieInMatrix.minHours(matrix));

    }

    int minHours(int[][] matrix) {

        int nonZombieCount = 0;
        int iteration = 0;
        do {
            nonZombieCount = 0;
            int[][] copy = copy(matrix);
            for(int i=0; i<copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {

                    int top = i==0 ? 0  : matrix[i-1][j];
                    int bottom = i==matrix.length-1 ? 0 : matrix[i+1][j];
                    int left = j == 0 ? 0 : matrix[i][j-1];
                    int right = j == matrix[0].length-1 ? 0 : matrix[i][j+1];
                    if(top == 1 || bottom == 1 || left == 1 || right == 1) {
                        copy[i][j] = 1;
                    }
                    if(copy[i][j] == 0) {
                        nonZombieCount++;
                    }
                }
            }
            matrix = copy;
            iteration++;
        } while (nonZombieCount != 0);
        return iteration;
    }

    public int[][] copy(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }
}
