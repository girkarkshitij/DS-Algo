import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree
 * Duplicate items are not allowed
 */

public class Main{
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(7);
        bst.insert(15);
        bst.insert(3);
        System.out.println(bst.findHeight(bst.root)); //2
        bst.levelOrder(bst.root); //10 7 15 3
        System.out.println();
        bst.delete(7);
        bst.levelOrder(bst.root); //10 3 15

    }
}

class BinarySearchTree{
    Node root = null;

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(int x){
        Node n = new Node(x);

        if (root == null) {
            //First Insertion
            root = n;
        }else{
            Node p = root;

            while (true) {
                if (x > p.data) {
                    if (p.right == null) {
                        p.right = n;
                        break;
                    }
                    p = p.right;
                } else if (x < p.data) {
                    if (p.left == null) {
                        p.left = n;
                        break;
                    }
                    p = p.left;
                } else {
                    System.out.println("Key exists");
                    break;
                }
            }
        }
    }

    public void delete(int x){
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        //Search the node to be deleted
        Node p = root;
        Node q = root;

        while (p != null) {
            if (x < p.data) {
                q = p;
                p = p.left;
            } else if (x > p.data) {
                q = p;
                p = p.right;
            } else
                break;
        }

        if (p == null) {
            System.out.println("Key not found");
            return;
        }

        //Case 1: Single node in the tree
        if (root == p && p.left == null && p.right == null) {
            root = null;
            return;
        }

        //Case 2: Leaf nodes
        if (p.left == null && p.right == null) {
            if (q.left == p)
                q.left = null;
            else
                q.right = null;
            return;
        }

        //Case 3: Node with one child
        if (p.left == null && p.right != null) {
            if (q.left == p)
                q.left = p.right;
            else
                q.right = p.right;
            return;
        }
        if (p.right == null && p.left != null) {
            if (q.left == p)
                q.left = p.left;
            else
                q.right = p.left;
            return;
        }

        //Case 4: Node with 2 children
        if (p.left != null && p.right != null) {
            Node back = p;
            Node front = p.right;

            while (front.left != null){
                back = front;
                front = front.left;
            }
            if (p.right == front)
                p.right = front.right;
            else
                back.left = front.right;
            p.data = front.data;
        }
    }

    public void search(Node p, int k){
        while (p != null) {
            if (k < p.data)
                p = p.left;
            else if (k > p.data)
                p = p.right;
            else
                break;
        }
        if (p == null)
            System.out.println("Key is not present");
        else
            System.out.println("Key is present");
    }

    public Node minimum(Node p){
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node maximum(Node p){
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public int findHeight(Node p){
        if (p == null)
            return -1;  //height of empty tree is -1
        return Math.max(findHeight(p.left),findHeight(p.right))+1;
    }

    public void inOrder(Node p){
        if (p != null) {
            inOrder(p.left);
            System.out.print(p.data+" ");
            inOrder(p.right);
        }
    }

    public void preOrder(Node p){
        if (p != null){
            System.out.print(p.data+" ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void postOrder(Node p){
        if (p != null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data+" ");
        }
    }

    public void levelOrder(Node p){
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.data+" ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }



}
