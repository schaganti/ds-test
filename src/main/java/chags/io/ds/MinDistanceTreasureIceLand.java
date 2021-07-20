package chags.io.ds;

import java.util.*;

public class MinDistanceTreasureIceLand {
    public static void main(String[] args) {
        MinDistanceTreasureIceLand minDistanceTreasureIceLand = new MinDistanceTreasureIceLand();
        char[][] iceland = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };

        List<String> steps = minDistanceTreasureIceLand.shortestPath(iceland);
        System.out.println(steps);
    }

    private List<String> shortestPath(char[][] map) {

        Queue<int[]> steps = new LinkedList<>();
        steps.add(new int[]{0,0});
        Map<String, String> indexMap = new HashMap<>();

        Stack<String> path = new Stack<>();

        int[] prev = steps.peek();

        while (!steps.isEmpty()) {

            int[] curr = steps.poll();
            String currStr = curr[0] + "," + curr[1];

            if(map[curr[0]][curr[1]] == 'X') {
                path.push(currStr);
                while(!indexMap.get(currStr).equals("0,0")) {
                    currStr = indexMap.get(currStr);
                    path.push(currStr);
                }
                path.push(indexMap.get(currStr));
                List<String> pathForward = new ArrayList<>();
                while(!path.isEmpty()) {
                    pathForward.add(path.pop());
                }
                return pathForward;
            }

            map[curr[0]][curr[1]] = 'D';

            int[] top = curr[0] !=0 ? new int[]{curr[0]-1, curr[1]} : null;
            int[] bottom = curr[0] != map.length-1 ? new int[]{curr[0]+1, curr[1]} : null;
            int[] left = curr[1] !=0 ? new int[]{curr[0], curr[1]-1} : null;
            int[] right = curr[1] != map[0].length-1 ? new int[]{curr[0], curr[1]+1} : null;

            if(top != null && map[top[0]][top[1]] != 'D') {
                steps.offer(top);
                indexMap.put(top[0]+","+top[1], currStr);
            }
            if(bottom != null && map[bottom[0]][bottom[1]] != 'D') {
                steps.offer(bottom);
                indexMap.put(bottom[0]+","+bottom[1], currStr);
            }
            if(left != null && map[left[0]][left[1]] != 'D' ) {
                steps.offer(left);
                indexMap.put( left[0]+","+left[1], currStr);
            }
            if(right != null && map[right[0]][right[1]] != 'D') {
                steps.offer(right);
                indexMap.put(right[0]+","+right[1], currStr);
            }
        }
        return  null;
    }
}
