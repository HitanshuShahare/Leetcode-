class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair first = pq.poll();

            if (result.length() >= 2 &&
                result.charAt(result.length() - 1) == first.ch &&
                result.charAt(result.length() - 2) == first.ch) {
                
                if (pq.isEmpty()) break;

                Pair second = pq.poll();
                result.append(second.ch);
                second.count--;

                if (second.count > 0) pq.offer(second);

                pq.offer(first);
            } else {
                result.append(first.ch);
                first.count--;
                
                if (first.count > 0) pq.offer(first);
            }
        }
        return result.toString();
    }
    private static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}