import java.util.Collections;
import java.util.PriorityQueue;

public class LastElemValue {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest
            int x = maxHeap.poll(); // Second heaviest

            if (x != y) {
                maxHeap.add(y - x);
            }
        }
        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.poll();
        }
        
    }
}
