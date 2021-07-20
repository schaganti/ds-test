package chags.io.ds;

import java.util.PriorityQueue;

public class CostConnectedRope {
    public static void main(String[] args) {
        CostConnectedRope costConnectedRope = new CostConnectedRope();
        int cost = costConnectedRope.getCost(new int[]{8, 4, 6, 12});
        System.out.println(cost);
    }

    private int getCost(int[] ropes) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o1-o2;
        });
        for (int i = 0; i < ropes.length; i++) {
            priorityQueue.offer(ropes[i]);
        }

        int result = 0;
        while(priorityQueue.size() > 1) {
            int v = priorityQueue.poll() + priorityQueue.poll();
            System.out.println(v);
            priorityQueue.offer(v);
            System.out.println(priorityQueue);
            result = result + v;
        }
        return result;
    }
}
