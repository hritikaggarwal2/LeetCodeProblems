class Solution {
    public String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int kEnd = (start + k) > end ? (end - 1) : (start + k - 1);
            int curr = start;

            while (curr < kEnd) {
                char temp = arr[curr];
                arr[curr++] = arr[kEnd];
                arr[kEnd--] = temp;
            }

            start += 2 * k;
        }

        return new String(arr);
    }
}