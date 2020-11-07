class Solution {
    class TrieNode {
        char letter;
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode(char letter) {
            this.letter = letter;
            children = new HashMap<>();
        }
    }

    public void isInBoard(char[][] board, TrieNode parent, int i, int j, Set<String> found, String formed) {
        if (parent == null || i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return;
        }

        char letter = board[i][j];
        TrieNode child = parent.children.get(letter);

        if (child == null) {
            return;
        }

        if (child.isEnd) {
            found.add(formed + letter);
            child.isEnd = false;
        }

        board[i][j] = '$';

        isInBoard(board, child, i + 1, j, found, formed + letter);
        isInBoard(board, child, i - 1, j, found, formed + letter);
        isInBoard(board, child, i, j + 1, found, formed + letter);
        isInBoard(board, child, i, j - 1, found, formed + letter);

        board[i][j] = letter;

        if (!child.isEnd && child.children.isEmpty()) {
            parent.children.remove(child);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode parent = new TrieNode('*');
        for (String w : words) {
            TrieNode curr = parent;

            for (char letter : w.toCharArray()) {
                if (!curr.children.containsKey(letter)) {
                    curr.children.put(letter, new TrieNode(letter));
                }

                curr = curr.children.get(letter);
            }

            curr.isEnd = true;
        }

        Set<String> found = new TreeSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                isInBoard(board, parent, i, j, found, "");
            }
        }

        return new ArrayList<>(found);
    }
}