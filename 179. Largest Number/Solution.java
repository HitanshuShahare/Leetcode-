import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        // convert integers to strings
        String[] strNums = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        // Sort the arrays with a custom comparator 
        Arrays.sort(strNums, (a,b) -> (b+a).compareTo(a + b));
        
        // If the largest number is "0", return "0"
        if(strNums[0].equals("0")){
            return "0";
        }

        // Join the numbers together to form the largest number
        return String.join("",strNums);
    }
}