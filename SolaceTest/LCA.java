package SolaceTest;

public class LCA {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;
        public static Node lca(Node root, int n1 , int n2){
            // lowest common ancestor
            // approach 2 [RECURSIVE]
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node lcaLeft = lca(root.left, n1, n2 );
            Node lcaRight = lca(root.right, n1 , n2);

            if (lcaRight == null ){ // means n1 & n2 not found on the right side of the root
                return lcaLeft;
            }
            if (lcaLeft == null ){ //Not found on the left side of the root
                return lcaRight;
            }
            return root;
        }

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            // System.out.println("Creating node -> " + nodes[idx]);
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 7, -1, -1, 6, 8, -1 ,-1 , -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
    }

}
