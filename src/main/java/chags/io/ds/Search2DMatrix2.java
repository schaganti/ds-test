package chags.io.ds;

public class Search2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        for(int i = 0; i< maxRow; i++) {
            for(int j = 0; j< maxCol; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
                if(matrix[i][j] > target) {
                    maxCol = j-1;
                    break;
                }
            }
        }
        return false;
    }
}
