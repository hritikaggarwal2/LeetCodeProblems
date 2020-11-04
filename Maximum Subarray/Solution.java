public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;

        for (int i : nums) {
            if (curr + i > i) {
                curr += i;
            } else {
                curr = i;
            }

            if (curr > max) {
                max = curr;
            }
        }

        return max;
    }
}