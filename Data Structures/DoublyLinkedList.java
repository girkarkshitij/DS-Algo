class Main{
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtStart(0);
        list.insertAtStart(1);
        list.insertAtStart(2);
        list.insertAtEnd(4);
        list.traversal();                   //2 1 0 4
        list.insertAtEnd(3);
        list.traversal();                   //2 1 0 4 3
        list.deleteAtEnd();
        list.traversal();                   //2 1 0 4
        list.deleteAtStart();
        list.traversal();                   //1 0 4
        list.deleteAt(1);
        list.traversal();                   //1 4
        list.insertAt(1, 99);
        list.traversal();                   //1 99 4
    }
}

class DoublyLinkedList {
    Node header = null;
    static int size = 0;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    public void insertAtStart(int x) {
        Node n = new Node(x);

        if (header == null) {
            header = n;
        } else {
            n.next = header;
            header.prev = n;
            header = n;
        }
    }

    public void insertAtEnd(int x) {
        Node n = new Node(x);
        Node p = header;

        if (header == null) {
            header = n;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
            n.prev = p;
        }
    }

    public void insertAt(int index, int x) {
        if (index >= size) {
            System.out.println("Index is invalid");
            return;
        }
        Node n = new Node(x);
        Node p = header;
        if (index == 0) {
            insertAtStart(x);
        } else if (index == size - 1) {
            insertAtEnd(x);
        } else {
            int counter = 0;
            while (counter != index - 1) {
                p = p.next;
                counter++;
            }
            n.prev = p;
            n.next = p.next;
            p.next = n;
            p = n.next;
            p.prev = n;
        }
    }

    public void deleteAtStart() {
        if (header == null) {
            System.out.println("List is empty");
            return;
        }
        Node p = header;
        if (p.next == null) {
            System.out.println("Deleted Value :"+ p.data);
            header = null;
        }else{
            System.out.println("Deleted Value :"+ p.data);
            header = p.next;
            p = header;
            p.prev = null;
        }
        size--;
    }

    public void deleteAtEnd(){
        if (header == null) {
            System.out.println("List is empty");
            return;
        }
        Node p = header;
        if (p.next == null) {
            System.out.println("Deleted Value :" + p.data);
            header = null;
        }else {
            while (p.next != null) {
                p = p.next;
            }
            System.out.println("Deleted Value :" + p.data);
            p = p.prev;
            p.next = null;
        }
        size--;
    }

    public void deleteAt(int index){
        if (index >= size) {
            System.out.println("Index is invalid");
            return;
        }
        if (index == 0) {
            deleteAtStart();
        }else if (index == size-1){
            deleteAtEnd();
        }else{
            Node p = header;
            Node q = header;
            int counter = 0;
            while (counter != index) {
                p = p.next;
                counter++;
            }
            System.out.println("Deleted Value :" + p.data);
            q = p.prev;
            q.next = p.next;
            q = p.next;
            q.prev = p.prev;
            size--;
        }
    }

    public void traversal(){
        Node p = header;
        if (header == null) {
            System.out.println("List is empty");
            return;
        }
        while (p != null) {
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }
}
