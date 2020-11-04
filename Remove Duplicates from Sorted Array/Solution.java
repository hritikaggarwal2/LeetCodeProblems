class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int size = nums.length;
        int pointer = 0;
        int count = 1;

        for (int i = 1; i < size; i++) {
            if (nums[pointer] != nums[i]) {
                nums[++pointer] = nums[i];
                count++;
            }
        }

        return count;
    }
}