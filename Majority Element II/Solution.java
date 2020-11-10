class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        } else if (nums.length == 1) {
            return new ArrayList<>() {
                {
                    add(nums[0]);
                }
            };
        }

        int candidate1 = 0;
        int count1 = 0;

        int candidate2 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                candidate1 = nums[i];
            } else if (count2 == 0) {
                count2++;
                candidate2 = nums[i];
            } else {
                count1 = count1 > 0 ? count1 - 1 : 0;
                count2 = count2 > 0 ? count2 - 1 : 0;
            }
        }

        List<Integer> ans = new LinkedList<>();
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            }
        }

        // System.out.println(candidate1 + " - " + count1);
        // System.out.println(candidate2 + " - " + count2);

        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}