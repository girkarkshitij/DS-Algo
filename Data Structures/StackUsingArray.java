/**
 * Array implementation of stack
 */

public class Main{
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);  //stack is full
        stack.peek();      //4
        stack.pop();       //4
        stack.pop();       //3
        stack.pop();       //2
        stack.pop();       //1
    }
}

class Stack{
    static int[] stack;
    static int top;
    static int sizeOfStack;

    Stack(int size){
        sizeOfStack = size;
        stack = new int[sizeOfStack];
        top = -1;
    }

    public void push(int x){
        if (isFull())
            System.out.println("Stack is full");
        else
            stack[++top] = x;
    }

    public void pop(){
        if (isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println(stack[top--]);
    }

    public void peek(){
        if (isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println(stack[top]);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == sizeOfStack-1;
    }
}