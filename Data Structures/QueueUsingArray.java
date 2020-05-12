/**
 * Array implementation of Queue
 */
 
class Main{
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);   //Queue is full
        queue.dequeue();   //1
        queue.dequeue();   //2
        queue.dequeue();   //3
        queue.dequeue();   //Queue is empty
    }
}

class Queue{
    int[] queue;
    int front;
    int rear;
    int capacity;

    Queue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(int x){
        if (isFull())
            System.out.println("Queue is full");
        else{
            if (front == -1)
                front++;
            queue[++rear] = x;
        }
    }

    public void dequeue(){
        if (isEmpty())
            System.out.println("Queue is empty");
        else if (front == rear){
            System.out.println(queue[front]);
            front = -1;
            rear = -1;
        }else{
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
