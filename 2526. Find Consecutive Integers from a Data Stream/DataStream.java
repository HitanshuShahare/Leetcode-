class DataStream {
    private int targetValue;
    private int consecutiveCount;
    private int currentStreak;

    public DataStream(int value, int k) {
        this.targetValue = value;
        this.consecutiveCount = k;
        this.currentStreak = 0;
    }
    
    public boolean consec(int num) {
        if (num == targetValue) {
            currentStreak++;
        } else {
            currentStreak = 0;
        }
        return currentStreak >= consecutiveCount;
    }
}
