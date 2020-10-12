class Solution {

    private static Map<Character, Integer> romanMap = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int number = 0, prev = 0;
        int len = s.length();

        for (int i = len - 1; i >= 0; i--) {
            int curr = romanMap.get(s.charAt(i));
            if (curr < prev) {
                curr = -curr;
            }

            number += curr;
            prev = curr;
        }

        return number;
    }
}