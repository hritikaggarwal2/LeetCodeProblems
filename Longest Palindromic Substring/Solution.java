class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < len; i++) {
            int len1 = centerExtend(s, i, i);
            int len2 = centerExtend(s, i, i + 1);
            int maxLen = len1 >= len2 ? len1 : len2;
            if (maxLen > maxEnd - maxStart + 1) {
                maxStart = i - ((maxLen - 1) / 2);
                maxEnd = i + (maxLen / 2);
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }

    private int centerExtend(String s, int start, int end) {
        int len = s.length();
        while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}