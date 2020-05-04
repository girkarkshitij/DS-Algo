class Main{
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtStart(0);
        list.traversal(); //0 1 2
        list.insertAt(3,3);
        list.traversal(); //0 1 2 3
        list.deleteAt(2);
        list.traversal(); //0 1 3
    }
}

class SinglyLinkedList {
    Node head;
    static int size = 0;

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
        }else{
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtStart(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int index, int data){
        Node newNode = new Node(data);

        if (index == 0){
            insertAtStart(data);
        }else{
            Node temp = head;
            int counter = 0;
            while (counter != index - 1) {
                temp = temp.next;
                counter++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteAt(int index){
        if (index >= size){
            System.out.println("Index does not exist");
        }
        if (index == 0) {
            head = head.next;
        }else{
            Node temp = head;
            int counter = 0;
            while (counter != index - 1){
                temp = temp.next;
                counter++;
            }
            Node temp1 = temp.next;
            temp.next = temp1.next;
            temp1 = null;
        }
        size--;
    }

    public void traversal(){
        if (head == null) {
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
