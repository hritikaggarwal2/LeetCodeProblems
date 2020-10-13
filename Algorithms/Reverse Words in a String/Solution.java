class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        int len = split.length;

        StringBuilder ret = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            String word = split[i].trim();
            if (word.length() > 0) {
                ret.append(" " + split[i].trim());
            }
        }

        return ret.toString().trim();
    }
}