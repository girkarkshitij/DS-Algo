/**
 * Deque - Double Ended Queue (Using Circular Array)
 */

public class Main{
    public static void main(String[] args) {
        Deque deque = new Deque(3);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.deleteFront();  //3
        deque.deleteFront();  //2
        deque.deleteFront();  //1
        deque.insertLast(99);
        deque.deleteLast();   //99
        deque.insertLast(98);
        deque.insertLast(97);
        deque.deleteLast();  //97
        deque.deleteLast();  //98
    }
}

class Deque{
    int[] deque;
    int front;
    int rear;
    int capacity;

    Deque(int capacity){
        deque = new int[capacity];
        this.capacity = capacity;
        front = -1;
        rear = -1;
    }

    public void insertFront(int x){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        } else if (front == -1) {
            front++;
            rear++;
        } else if (front == 0) {
            front = capacity-1;
        } else {
            front--;
        }
        deque[front] = x;
    }

    public void insertLast(int x){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        } else if (front == -1) {
            front++;
        } else if (rear == capacity - 1) {
            rear = -1;
        }
        deque[++rear] = x;
    }

    public void deleteFront(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println(deque[front]);
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            System.out.println(deque[front]);
            front = 0;
        } else {
            System.out.println(deque[front++]);
        }
    }

    public void deleteLast(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println(deque[rear]);
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            System.out.println(deque[rear]);
            rear = capacity-1;
        } else {
            System.out.println(deque[rear]);
            rear--;
        }
    }

    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }

    public boolean isEmpty(){
        return front == -1;
    }
}
