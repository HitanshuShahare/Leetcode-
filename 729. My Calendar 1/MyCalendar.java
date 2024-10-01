import java.util.ArrayList;
import java.util.List;

class MyCalendar {

    // List to hold the booked events as pairs of start and end times
    private List<int[] > bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for overlap with existing bookings
        for(int[] booking : bookings) {
            // if there is an overlap, return false
            if(start < booking[1] && end > booking[0]) {
                return false;
            }
        }
        // No overlaps, add the new bookings
        bookings.add(new int[]{start, end});
        return true;
    }
}