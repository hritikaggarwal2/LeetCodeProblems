import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new TreeMap<>();

        int index = 0;
        for (int i : nums) {
            int diff = target - i;
            if (map.containsKey(diff)) {
                return new int[] { index, map.get(diff) };
            }

            map.put(i, index++);
        }

        return new int[] {};
    }
}