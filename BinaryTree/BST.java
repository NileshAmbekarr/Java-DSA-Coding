package BinaryTree;

import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val ){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else if(root.data < val){
            root.right = insert(root.right, val );
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null ){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root == null ){
            return false;
        }
        if(root.data == key ) return true;
        if(root.data > key ){
            return search(root.left , key);
        }else{
            return search(root.right , key);
        }
    }

    // 5th March 2024
    public static void printInRange(Node root , int k1, int k2){
        // base case
        if (root == null ){
            return ;
        }
        if((root.data >= k1) && (root.data <= k2)){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right , k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }else {
            printInRange(root.left , k1, k2);
        }
    }

    // 6th march 2024
    public static boolean validateBST(Node root, Node min, Node max){
        if (root == null ){
            return true;
        }
        if(min != null && min.data >= root.data){
            return false;
        }else if(max != null && max.data <= root.data){
            return false;
        }
        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }
    public static Node mirror(Node root){
        if(root == null ){
            return root;
        }
        Node leftM = mirror(root.left);
        Node rightM = mirror(root.right);

        root.left = rightM;
        root.right = leftM;
        return root;
    }

    // 9th March 2024

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node buildBST(int[] arr, int stp, int endP){
        if(stp > endP){
            return null;
        }
        int mid = (stp + endP)/ 2 ;
        Node root = new Node(arr[mid]);
        root.left = buildBST( arr, stp, mid-1);
        root.right = buildBST( arr , mid+1 , endP);

        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return ;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node createBST(ArrayList<Integer> inorder, int st, int end){
        if(st > end ){
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node (inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1 , end);
        return root;
    }

    // 9th march 2024
    public static class TreeInfo{
        boolean isBST ;
        int min;
        int max;
        int size;

        TreeInfo(boolean isBST, int size, int min, int max){
            this.isBST= isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBST = 0;
    public static TreeInfo largestBSTSize(Node root){
        if (root == null){
            return new TreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        TreeInfo leftInfo = largestBSTSize(root.left);
        TreeInfo rightInfo = largestBSTSize(root.right);
        // Calculating current NOde's INfo
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(leftInfo.max >= root.data || rightInfo.min <= root.data){
            return new TreeInfo(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){ // both the subtrees are BST
            maxBST = Math.min(maxBST, size);
            return new TreeInfo(true, size, min, max);
        }
        return new TreeInfo(false, size, min, max);
    }
    public static Node mergeBST(Node root1, Node root2){
        // Get the inorder sequence of Both trees
        ArrayList<Integer> seq1 = new ArrayList<>();
        getInorder(root1, seq1);
        ArrayList<Integer> seq2 = new ArrayList<>();
        getInorder(root2, seq2);

        // merge two lists
        ArrayList<Integer> inorder = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < seq1.size() && j < seq2.size()){
            if(seq1.get(i) <= seq2.get(j)){
                inorder.add(seq1.get(i++));
            }else{
                inorder.add(seq2.get(j++));
            }
        }
        while(i < seq1.size() ){
            inorder.add(seq1.get(i++));
        }
        while(j < seq2.size() ){
            inorder.add(seq2.get(j++));
        }
        return createBST(inorder, 0, inorder.size()-1);
    }
    public static Node balanceBST(Node root){
        // Two Steps :-
        // Get inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // build BST
        return createBST(inorder, 0, inorder.size()-1);
    }
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node (3);
        root2.right = new Node (12);

        Node root3 = new Node(34);
        Node root = mergeBST(root1, root2);
        inorder(root);
        preorder(root);
    }
}
