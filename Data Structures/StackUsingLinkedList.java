/**
 * Implementation of stack using linked list
 */

public class Main{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.peek();      //5
        stack.pop();       //5
        stack.pop();       //4
        stack.pop();       //3
        stack.pop();       //2
        stack.pop();       //Stack is empty
    }
}

class Stack {
    Node top;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int x) {
        Node n = new Node(x);
        if (top == null)
            top = n;
        else {
            n.next = top;
            top = n;
        }
    }

    public void pop() {
        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            Node p = top;
            System.out.println(p.data);
            top = p.next;
        }
    }

    public void peek() {
        if (isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println(top.data);
    }

    public boolean isEmpty() {
        return top == null;
    }
}
