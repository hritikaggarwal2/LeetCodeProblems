class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !checkAlphanum(s.charAt(start))) {
                start++;
            }

            while (start < end && !checkAlphanum(s.charAt(end))) {
                --end;
                continue;
            }

            if (start >= end) {
                return true;
            }

            char left = s.charAt(start);
            char right = s.charAt(end);

            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private boolean checkAlphanum(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

}