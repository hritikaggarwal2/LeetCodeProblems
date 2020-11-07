class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    char letter;

    TrieNode(char c) {
        letter = c;
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode parent;

    /** Initialize your data structure here. */
    public Trie() {
        parent = new TrieNode('*');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode start = parent;
        for (char c : word.toCharArray()) {
            if (start.children[c - 'a'] == null) {
                start.children[c - 'a'] = new TrieNode(c);
            }

            start = start.children[c - 'a'];
        }

        start.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode start = parent;
        for (char c : word.toCharArray()) {
            if (start.children[c - 'a'] == null) {
                return false;
            }

            start = start.children[c - 'a'];
        }

        return start.isEnd == true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode start = parent;
        for (char c : prefix.toCharArray()) {
            if (start.children[c - 'a'] == null) {
                return false;
            }

            start = start.children[c - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */