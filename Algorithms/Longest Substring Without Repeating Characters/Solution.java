class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int noRepeatIndex = 0;
        Map<Character, Integer> map = new HashMap<>();

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                counter++;

            } else {
                if (max < counter) {
                    max = counter;
                }

                int newStartIndex = map.get(c) + 1;
                if (noRepeatIndex < newStartIndex) {
                    noRepeatIndex = newStartIndex;
                }
                counter = i - noRepeatIndex + 1;

                map.put(c, i);
            }
        }

        if (max < counter) {
            max = counter;
        }

        return max;
    }
}