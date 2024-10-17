class Solution {
    public long minimumPerimeter(long neededApples) {
        long k = 0;
        long apples = 0;

        while (apples < neededApples) {
            k++;
            apples += 12  * k * k;
        }
        return 8 * k;
    }
}