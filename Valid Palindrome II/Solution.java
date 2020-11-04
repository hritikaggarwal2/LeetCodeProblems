class Solution {
    public boolean validPalindrome(String s) {
        int size = s.length();
        int start = 0;
        int end = size - 1;
        boolean skippable = true;

        while (start < end) {
            boolean check = s.charAt(start++) == s.charAt(end--);

            if (!check && skippable) {
                return isPalindrome(s, start - 1, end) || isPalindrome(s, start, end + 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            boolean check = s.charAt(start++) == s.charAt(end--);
            if (!check) {
                return false;
            }
        }

        return true;
    }
}

// aacdabadaa