import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {

        for(int[] overlap : overlaps) {
            if(Math.max(start, overlap[0]) < Math.min(end, overlap[1])) {
                return false; 
            }
        }

        for(int[] event : calendar) {
            if (Math.max(start, event[0]) < Math.min(end, event[1])){
                overlaps.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }

        calendar.add(new int[] { start, end });
        return true;
    }
}
