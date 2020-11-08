class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (String word : strs) {
            int[] count = new int[26];
            for (char letter : word.toCharArray()) {
                count[letter - 'a']++;
            }

            String key = Arrays.toString(count);

            if (!container.containsKey(key)) {
                container.put(key, new ArrayList<>());
            }

            container.get(key).add(word);
        }

        return new ArrayList<>(container.values());
    }
}