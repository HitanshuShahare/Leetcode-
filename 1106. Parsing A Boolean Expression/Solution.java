import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean parseBoolExpr(String expression) {
        if (expression.equals("t")) return true;
        if (expression.equals("f")) return false;

        char operator = expression.charAt(0);
        List<Boolean> results = new ArrayList<>();
        int balance = 0;
        StringBuilder subExpr = new StringBuilder();

        for (int i = 2; i < expression.length() - 1; i++) {
            char c = expression.charAt(i);
            if (c == ',' && balance == 0) {
                results.add(parseBoolExpr(subExpr.toString()));
                subExpr.setLength(0);
            } else {
                if (c == '(') balance++;
                if (c == ')') balance--;
                subExpr.append(c);
            }
        }
        if (subExpr.length() > 0) {
            results.add(parseBoolExpr(subExpr.toString()));
        }

        if (operator == '!') return !results.get(0);
        if (operator == '&') return results.stream().allMatch(x -> x);
        if (operator == '|') return results.stream().anyMatch(x -> x);

        return false;
    }
}