import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        for (int i = 0; i < n; i++) {
            times[i] = new int[]{times[i][0], times[i][1],i};
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeChairs.offer(i);
        }

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for (int[] guest : times) {
            int arrivalTime = guest[0];
            int departureTime = guest[1];
            int guestIndex = guest[2];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrivalTime) {
                freeChairs.offer(occupiedChairs.poll()[1]);
            }

            int assignedChair = freeChairs.poll();

            if (guestIndex == targetFriend) {
                return assignedChair;
            }

            occupiedChairs.offer(new int[]{departureTime, assignedChair});
        }
        return -1;
    }
}