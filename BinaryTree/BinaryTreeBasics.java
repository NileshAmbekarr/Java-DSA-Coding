package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBasics {
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
        public static void preorder(Node root){
            // base case
            if(root == null){
                System.out.print(" " + -1);
               return;
            }
            System.out.print(" " + root.data); // print the root
            preorder(root.left); // print the left subtree
            preorder(root.right); // print the right subtree
        }
        public static void postOrder(Node root){
            if (root == null) {
                return ;
            }
            postOrder(root.left);  // print left subtree
            postOrder(root.right);  // print right subtree
            System.out.print(root.data + " "); // print the root
        }
        public static void inOrder(Node root){
            if (root == null ){
                return ;
            }
            inOrder(root.left);          // print the left subtree
            System.out.print(root.data + " "); // print root
            inOrder(root.right);         // print the right subtree
        }
        public static void levelOrder(Node root){
            if(root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount + rightCount + 1;
        }

        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }
        public static int height(Node root){
            if(root == null ){
                return 0;
            }
            int leftH = height(root.left);
            int rightH = height(root.right);

            return Math.max(leftH, rightH) + 1;
        }
        public static int diameter2(Node root){
            if(root == null ){
                return 0;
            }
            int leftD = diameter2(root.left);
            int leftH = height(root.left);
            int rightD = diameter2(root.right);
            int rightH = height(root.right);

            int selfD = leftH + rightH + 1;

            return Math.max(selfD, Math.max(leftD, rightD)) ;
        }

//        public static class Info{
//            int height;
//            int diam;
//
//            Info(int height , int diam){
//                this.height = height;
//                this.diam = diam;
//            }
//        }
//        public static Info diameter(Node root){
//            if(root == null){
//                return new Info(0 , 0);
//            }
//            Info left = diameter(root.left);
//            Info right = diameter(root.right);
//            int selfHeight = Math.max(left.height, right.height) + 1;
//            int selfDiam = Math.max(left.height + right.height + 1 , Math.max(left.diam , right.diam));
//            return new Info(selfHeight, selfDiam);
//        }
//        public static void printDiam(Node root){
//            Info tree = diameter(root);
//            System.out.println("Diameter is " + tree.diam);
//            System.out.println("Height is " + tree.height);
//        }
        public static boolean isSubtree(Node root, Node subRoot){
            if(root == null){
                return false;
            }
          if(root.data == subRoot.data){
             if( isIdentical(root, subRoot)){
                 return true;
             }
          }
         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        public static boolean isIdentical(Node root, Node subRoot){
            if (root == null && subRoot == null ){
                return true;
            } else if(root == null || subRoot == null || root.data != subRoot.data ){
                return false;
            }
            if(!isIdentical(root.left , subRoot.left)){
                return false;
            }
            if (!isIdentical(root.right, subRoot.right)){
                return false;
            }
            return true;
        }
        static class Info{
            Node node ;
            int hd ; // Horizontal distance
            Info(Node node , int hd ){
                this.node = node ;
                this.hd = hd;
            }
        }
        public static void topView(Node root){
            Queue<Info> q = new LinkedList<>(); // for level order traversal
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0 , max = 0;
            q.add(new Info(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null ){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd , curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new Info(curr.node.left , curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if(curr.node.right != null){
                        q.add(new Info(curr.node.right , curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }

            }
            for(int i = min; i <= max; i++){
                System.out.print(map.get(i).data + " ");
            }
        }
        // 27th FEB 2024
        public static void printKthLevel(Node root ,int currLevel, int level){
            if(root == null){ // if the given level is not present in the tree
                return;
            }
            if(currLevel == level ){
                System.out.print(root.data + " ");
                return;
            }
            printKthLevel(root.left , currLevel + 1, level);
            printKthLevel(root.right, currLevel + 1, level);
        }
        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            // base case
            if (root == null ){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }
            boolean foundLeft = getPath(root.left, n , path);
            boolean foundRight = getPath(root.right, n, path);

            if(foundLeft || foundRight){ // if it was found in either one of the childs of the root
                return true ;
            }
            path.remove(path.size() - 1);
            return false;

        }
        public static Node lca(Node root, int n1, int n2){
            // lowest common ancestor
            // Make two arrayLists for storing paths of two Nodes
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1 , path1);
            getPath(root, n2 , path2);

            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            Node lca = path1.get(i-1);
            return lca;
            // TIME COMPLEXITY => O(n)
        }

        public static Node lca2(Node root, int n1 , int n2){
            // lowest common ancestor
            // approach 2 [RECURSIVE]
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node lcaLeft = lca2(root.left, n1, n2 );
            Node lcaRight = lca2(root.right, n1 , n2);

            if (lcaRight == null ){ // means n1 & n2 not found on the right side of the root
                return lcaLeft;
            }
            if (lcaLeft == null ){ //Not found on the left side of the root
                return lcaRight;
            }
            return root;
        }
        public static int getDistance(Node root , int n ){
            if (root == null ){
                return -1;
            }
           if (root.data == n ){
               return 0;
           }
           int leftDist = getDistance(root.left, n);
           int rightDist = getDistance(root.right, n);
           if(leftDist == -1 && rightDist == -1){
               return -1 ; // n does not exist on both the sides
           } else if(leftDist == -1){
               return rightDist + 1; // n not exist on the left side
           } else{
               return leftDist + 1;  // n does not exist on the right side
           }
        }
        public static int minDistance(Node root, int n1 , int n2){
            Node lca = lca2(root, n1, n2);
            int dist1 = getDistance(lca , n1);
            int dist2 = getDistance(lca , n2);
            return dist1 + dist2;
        }

        public static int KthAncestor(Node root , int node , int k){
            if(root == null ) return -1;
            if(root.data == node) return 0;

            int FindLeft = KthAncestor(root.left, node, k);
            int FindRight = KthAncestor(root.right , node , k);
            if(FindLeft == -1 && FindRight == -1){
                return -1;
            }
            int max = Math.max(FindRight, FindLeft);
            if(max + 1 == k){
                System.out.print(root.data);
            }
            return max + 1;
        }

        // 29th FEB 2024
        public static int transformToSumTree(Node root){
            if(root == null ){
                return 0;
            }
            // get sum of left subtree
            int leftSum = transformToSumTree(root.left);
            int rightSum = transformToSumTree(root.right);

            int data = root.data;
            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;
            root.data = leftSum + newLeft + rightSum + newRight;
            return data;
        }


    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 7, -1, -1, 6, 8, -1 ,-1 , -1};  //          1
        BinaryTree tree = new BinaryTree();                            //         /   \
        Node root = tree.buildTree(nodes);                            //         2     3
        System.out.println(root.data);                               //         / \   / \
                                                                    //         4   5 7   6
//        BinaryTree subTree = new BinaryTree();                                        /
//        int[] nodes2 = {2, 4, -1, -1, 5, -1, -1};                                    8
//        Node subRoot = subTree.buildTree(nodes2);
//        subTree.levelOrder(subRoot);

        tree.transformToSumTree(root);
        tree.levelOrder(root);
    }
}
