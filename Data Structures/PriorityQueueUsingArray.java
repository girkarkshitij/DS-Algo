/**
 * Implementation of Priority Queue using array
 */

public class Main{
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(3);
        queue.enqueue(99);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.dequeue(); //99
        queue.dequeue(); //1
        queue.dequeue(); //0
        queue.dequeue(); //Queue is empty
    }
}

class PriorityQueue{
    int capacity;
    int[] queue;
    int front,rear;

    PriorityQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(int x){
        int i, j;
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front++;
        }
        for(i = front; i<=rear; i++){
            if (x > queue[i]){
                for (j = rear; j>=i; j--) {
                    queue[j+1] = queue[j];
                }
                queue[j+1] = x;
                rear++;
                return;
            }
        }
        queue[++rear] = x;
    }

    public void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println(queue[front]);
            front = -1;
            rear = -1;
        } else {
            System.out.println(queue[front++]);
        }
    }

    public boolean isFull(){
        return rear == capacity-1;
    }

    public boolean isEmpty(){
        return front == -1;
    }
}
