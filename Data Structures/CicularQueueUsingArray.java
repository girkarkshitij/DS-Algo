/**
 * Cicular queue using array
 */

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3); //Queue is full
        queue.dequeue();   //0
        queue.dequeue();   //1
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(Arrays.toString(queue.queue));  //[4, 5, 2]
        queue.enqueue(6); //Queue is full
    }
}

class CircularQueue{
    int[] queue;
    int front;
    int rear;
    int capacity;

    CircularQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(int x){
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }else if (isEmpty())
            front++;
        else if (rear == capacity - 1)
            rear = -1;
        queue[++rear] = x;
    }

    public void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        } else if (front == rear){
            System.out.println(queue[front]);
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            System.out.println(queue[front]);
            front = 0;
        } else {
            System.out.println(queue[front++]);
        }
    }

    public boolean isFull(){
        return (rear+1)%capacity == front;
    }

    public boolean isEmpty(){
        return front == -1;
    }
}
