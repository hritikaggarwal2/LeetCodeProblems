/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                sb.append(",null");
                continue;
            }
            
            sb.append("," + node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        
        sb.deleteCharAt(0);
            
        return sb.toString();
    }
    
    private TreeNode makeTree(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        
        String item = list.remove(0);
        
        if (item.equals("null")) {
            return null;
        }
        
        TreeNode curr = new TreeNode(Integer.parseInt(item));
        curr.left = makeTree(list);
        curr.right = makeTree(list);
        
        return curr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        System.out.println(list);
        
        TreeNode root = makeTree(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));