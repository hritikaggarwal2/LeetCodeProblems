public class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > max) {
                max = height[i - 1];
            }

            left[i] = max;
        }

        max = 0;
        for (int i = height.length - 2; i > 0; i--) {
            if (height[i + 1] > max) {
                max = height[i + 1];
            }

            right[i] = max;
        }

        int count = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int lower = left[i] > right[i] ? right[i] : left[i];
            count += (lower - height[i]) > 0 ? lower - height[i] : 0;
        }

        return count;
    }
}