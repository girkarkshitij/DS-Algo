/**
 * Circular Linked List (Singly)
 */

public class Main{
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtStart(0);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtSpecific(1, 1);
        list.traversal();               //0 1 2 3
        list.deleteAtEnd();             //3
        list.traversal();               //0 1 2
        list.deleteAtStart();           //0
        list.traversal();               //1 2
        list.deleteSpecific(0);         //1
        list.traversal();               //2
    }
}

class CircularLinkedList{
    Node header;
    static int size;

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
            size++;
        }
    }

    public void insertAtStart(int x){
        Node n = new Node(x);

        if (header == null) {
            header = n;
            n.next = header;
        }else{
            Node p = header;
            n.next = header;
            while (p.next != header) {
                p = p.next;
            }
            p.next = n;
            header = n;
        }
    }

    public void insertAtEnd(int x){
        Node n = new Node(x);

        if (header == null) {
            header = n;
            n.next = header;
        }else{
            Node p = header;
            while (p.next != header) {
                p = p.next;
            }
            p.next = n;
            n.next = header;
        }
    }

    public void insertAtSpecific(int index, int x){
        if (index >= size) {
            System.out.println("Index is invalid");
            return;
        }
        Node n = new Node(x);
        if (index == 0){
            insertAtStart(x);
        } else if (index == size - 1) {
            insertAtEnd(x);
        } else{
            Node temp = header;
            int counter = 0;
            while (counter != index - 1) {
                temp = temp.next;
                counter++;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }

    public void deleteAtStart(){
        if (header == null) {
            System.out.println("List is empty");
            return;
        }
        if (header.next == header){
            //Single Node
            System.out.println(header.data);
            header = null;
        }else{
            Node p = header;
            System.out.println(p.data);
            Node q = p.next;

            while (p.next != header){
                p = p.next;
            }
            p.next = q;
            header = q;
        }
        size--;
    }

    public void deleteAtEnd(){
        if (header == null) {
            System.out.println("List is empty");
            return;
        }
        if (header.next == header) {
            //Single Node
            System.out.println(header.data);
            header = null;
        }else{
            Node p = header;
            Node q = header;
            while (p.next != header) {
                q = p;
                p = p.next;
            }
            System.out.println(p.data);
            q.next = header;
        }
        size--;
    }

    public void deleteSpecific(int index){
        if (index >= size) {
            System.out.println("Index is invalid");
            return;
        }
        if (index == 0) {
            deleteAtStart();
        } else if (index == size - 1) {
            deleteAtEnd();
        } else{
            Node temp = header;
            int counter = 0;
            while (counter != index - 1) {
                temp = temp.next;
                counter++;
            }
            System.out.println(temp.next.data);
            temp.next = temp.next.next;
            size--;
        }
    }

    public void traversal(){
        if (header == null){
            System.out.println("List is empty");
            return;
        }
        Node p = header;
        while (p.next != header) {
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.print(p.data);
        System.out.println();
    }
}
