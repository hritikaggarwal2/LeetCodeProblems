class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalSize = m + n;
        int pointer = totalSize - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            int a = nums1[m];
            int b = nums2[n];

            if (a >= b) {
                nums1[pointer--] = a;
                m--;
            } else {
                nums1[pointer--] = b;
                n--;
            }
        }

        if (m >= 0) {
            return;
        }

        while (pointer >= 0) {
            nums1[pointer--] = nums2[n--];
        }
    }
}