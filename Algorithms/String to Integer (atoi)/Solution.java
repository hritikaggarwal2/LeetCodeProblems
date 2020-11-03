import java.util.*;

public class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int len = s.length();

        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        if (index < len && !isNum(s.charAt(index)) && !isSign(s.charAt(index))) {
            return 0;
        }

        int num = 0;
        boolean isNeg = false;

        if (index < len && isSign(s.charAt(index))) {
            if (s.charAt(index) == '-') {
                isNeg = true;
            }

            index++;
        }

        while (index < len && isNum(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (outOfRange(num, digit, isNeg)) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num *= 10;
            num += digit;
            index++;
        }

        return isNeg ? -num : num;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean outOfRange(int num, int nextDigit, boolean isNeg) {
        int end = isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int factor = isNeg ? -10 : 10;

        int lastDigit = isNeg ? -1 * (end % factor) : end % factor;

        if (num > end / factor || (num == end / factor && nextDigit > lastDigit)) {
            return true;
        }

        return false;
    }
}