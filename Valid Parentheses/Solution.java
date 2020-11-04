class Solution {
    public boolean isValid(String s) {
        Stack<Character> store = new Stack<>();

        // Initialize checker
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')', '(');
        parentheses.put(']', '[');
        parentheses.put('}', '{');

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (parentheses.containsKey(c)) {
                if (store.isEmpty()) {
                    return false;
                }

                char prev = store.pop();
                if (prev != parentheses.get(c)) {
                    return false;
                }
            } else {
                store.push(c);
            }
        }

        return store.isEmpty();
    }
}