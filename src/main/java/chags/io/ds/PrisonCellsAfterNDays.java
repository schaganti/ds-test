package chags.io.ds;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {

        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
        prisonCellsAfterNDays.prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7);
    }

    private int[] prisonAfterNDays(int[] cells, int days) {

        for (int i = 0; i < days; i++) {

            int[] temp = Arrays.copyOf(cells, cells.length);

            for (int index = 0; index < temp.length; index++) {

                Integer left = index != 0 ? index - 1 : null;
                Integer right = index != temp.length - 1 ? index + 1 : null;

                if ((left != null && right != null)) {
                    if ((cells[left] + cells[right] == 2 || cells[left] + cells[right] == 0)) {
                        temp[index] = 1;
                    } else {
                        temp[index] = 0;
                    }
                }
                if (left == null) {
                    temp[index] = 0;
                }
                if (right == null) {
                    temp[index] = 0;
                }
            }
            cells = temp;

        }
        return cells;
    }


}
