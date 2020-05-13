/**
 * Implementation of queue using linked list
 */

public class Main{
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();   //1
        queue.dequeue();   //2
        queue.dequeue();   //3
        queue.dequeue();   //Queue is empty
    }
}

class Queue{
    Node front;
    Node rear;

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void enqueue(int x){
        Node n = new Node(x);

        if (front == null){
            front = n;
        }else{
            rear.next = n;
        }
        rear = n;
    }

    public void dequeue(){
        if (isEmpty())
            System.out.println("Queue is empty");
        else if (front == rear){
            System.out.println(front.data);
            front = null;
            rear = null;
        }else{
            System.out.println(front.data);
            front = front.next;
        }
    }

    public boolean isEmpty(){
        return front == null;
    }
}
