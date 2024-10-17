import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long score = 0;

        for (int num: nums) {
            maxHeap.add(num);
        }

        for (int i = 0; i < k; i++) {
            int maxElement = maxHeap.poll();
            score += maxElement;
            maxHeap.add((maxElement + 2) / 3);
        }
        return score;
    }
}