class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length && i <= end && start <= end; i++) {
            if (nums[i] == 0) {
                swap(nums, start++, i);
            } else if (nums[i] == 2) {
                swap(nums, end--, i);
                i--;
            }
        }
    }
}