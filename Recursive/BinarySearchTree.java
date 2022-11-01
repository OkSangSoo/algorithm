package Recursive;

import java.util.*;

public class BinarySearchTree {
    //static Node root = null;
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static void insert(Node root, int data){

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        }

        else if(data <= root.data){
            if (root.left != null) insert(root.left, data);
            else root.left = newNode;
        }
        else{
            if (root.right != null) insert(root.right, data);
            else root.right = newNode;
        }

    }

    static void preOrder(Node root){
        if(root == null) return;
        else{
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static void inOrder(Node root){
        if(root == null) return;
        else{
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    static void postOrder(Node root){
        if(root == null) return;
        else{
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    static int size(Node root){
        if(root == null) return 0;
        else return 1 + size(root.left) + size(root.right);
    }
    static int height(Node root){
        if (root == null) return 0;
        else{
            int leftheight = 1 + height(root.left);
            int rightheight = 1 + height(root.right);
            return leftheight > rightheight ? leftheight : rightheight;
        }

    }
    static int sumOfWeight(Node root){
        if (root == null) return 0;
        else return sumOfWeight(root.left) + sumOfWeight(root.right) + root.data;
    }
    static int maxPathWeight(Node root){
        if(root == null) return 0;
        else{
            int leftWeight = root.data + maxPathWeight(root.left);
            int rightWeight = root.data + maxPathWeight(root.right);
            return leftWeight >= rightWeight ? leftWeight : rightWeight;
        }
    }

    static void mirror(Node root){
        if (root == null) return;
        else {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }
    static Node destruct(Node root){
        if (root == null) return root;
        if (root.left != null) destruct(root.left);
        if (root.right != null) destruct(root.right);
        root = null;
        return root;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestCases = sc.nextInt();
        while(numTestCases > 0){
            Node root = null;

            int num = sc.nextInt();

            for (int i = 0; i < num; i++){
                if (root == null){
                    Node newNode = new Node(sc.nextInt());
                   // roots.add(newNode);
                    root = newNode;
                }
                else insert(root, sc.nextInt());
            }
            System.out.println(size(root));
            System.out.println(height(root) - 1);
            System.out.println(sumOfWeight(root));
            System.out.println(maxPathWeight(root));

            mirror(root);

            preOrder(root); System.out.println();
            inOrder(root); System.out.println();
            postOrder(root); System.out.println();
            root = destruct(root); //root= null;
            //inOrder(root); System.out.println();
            if(root == null) System.out.println(0);
            else System.out.println(1);

            numTestCases -= 1;
        }
    }

}
