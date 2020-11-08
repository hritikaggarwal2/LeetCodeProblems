class Solution {
    private Map<Character, String> map;
    private List<String> list = new LinkedList<String>();

    private void combos(char[] digits, int index, StringBuilder formed) {
        if (index > digits.length) {
            return;
        }

        if (digits.length == index) {
            list.add(formed.toString());
            return;
        }

        for (char c : map.get(digits[index]).toCharArray()) {
            formed.append(c);
            combos(digits, index + 1, formed);
            formed.deleteCharAt(index);
        }
    }

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.length() == 0) {
            return list;
        }

        combos(digits.toCharArray(), 0, new StringBuilder());

        return list;
    }
}