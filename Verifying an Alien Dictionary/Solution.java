class Solution {

    Map<Character, Integer> dict;

    public boolean isAlienSorted(String[] words, String order) {
        dict = new HashMap<>();
        char[] orderArray = order.toCharArray();

        for (int i = 0; i < 26; i++) {
            dict.put(orderArray[i], i);
        }

        for (int i = 0; i < words.length - 1; i++) {

            if (words[i].equalsIgnoreCase(words[i + 1])) {
                continue;
            }

            if (!isOrdered(words[i].toCharArray(), words[i + 1].toCharArray())) {
                return false;
            }
        }

        return true;
    }

    private boolean isOrdered(char[] s1, char[] s2) {
        int len = s1.length > s2.length ? s2.length : s1.length;

        for (int i = 0; i < len; i++) {
            int diff = dict.get(s1[i]) - dict.get(s2[i]);
            if (diff > 0) {
                return false;
            } else if (diff < 0) {
                return true;
            }
        }

        if (len < s1.length) {
            return false;
        }

        return true;
    }
}