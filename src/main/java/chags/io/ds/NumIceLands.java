package chags.io.ds;


public class NumIceLands {
    public static void main(String[] args) {
        char[][] arr = new char[][]
                {
                        {'1', '1', '1'},
                        {'0', '1', '0'},
                        {'1', '1', '1'}
                };

        char[][] arr1 = new char[][]
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '1', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };


        NumIceLands numIceLands = new NumIceLands();
        System.out.println(numIceLands.numIslands(arr1));
    }

    public  int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int iceLandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] != 1 && grid[i][j] == '1') {
                    iceLandCount++;
                    visit(i, j, grid, visited);
                }
            }
        }
        return iceLandCount;
    }


    public void visit(int i, int j, char[][] arr, int[][] visited) {


        if (arr[i][j] == '1' && visited[i][j] != 1) {

            visited[i][j] = 1;

            int topVal = i != 0 ? arr[i - 1][j] : 0;
            int bottomVal = i != arr.length - 1 ? arr[i + 1][j] : 0;
            int rightVal = j != arr[0].length - 1 ? arr[i][j + 1] : 0;
            int leftVal = j != 0 ? arr[i][j - 1] : 0;

            if (topVal == '1') {
                visit(i - 1, j, arr, visited);
            }
            if (bottomVal == '1') {
                visit(i + 1, j, arr, visited);
            }
            if (rightVal == '1') {
                visit(i, j + 1, arr, visited);
            }
            if (leftVal == '1') {
                visit(i, j - 1, arr, visited);
            }
        }
    }
}

