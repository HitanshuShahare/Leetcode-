import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i< nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax,val);
        }

        int rangeStart = -100000, rangeEnd = 100000;

        while (minHeap.size() == nums.size()) {
            int[] minElement = minHeap.poll();
            int minValue = minElement[0];
            int listIndex = minElement[1];
            int elementIndex = minElement[2];

            if (currentMax - minValue < rangeEnd - rangeStart) {
                rangeStart = minValue;
                rangeEnd = currentMax;
            }

            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                currentMax = Math.max(currentMax, nextVal);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}