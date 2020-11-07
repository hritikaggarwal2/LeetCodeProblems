class Solution {
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int start = 0;
        while (start < s.length) {
            if (s[start] == ' ') {
                start++;
                continue;
            }

            int end = start + 1;
            while (end < s.length && s[end] != ' ') {
                end++;
            }

            reverse(s, start, end - 1);
            start = end + 1;
        }
    }
}