/**
 * The BinaryHeap is an -generic- implementation of the PriorityQueue interface.
 * This is a binary min-heap implementation of the priority queue ADT.
 *              Average     Worst case
 * Space		O(n)        O(n)
 * Search		O(n)	    O(n)
 * Insert		O(1)	    O(log n)
 * Delete		O(log n)	O(log n)
 * Peek		    O(1)	    O(1)
 */

import java.util.Arrays;

class Heap<T extends Comparable<T>>{
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size;

    public Heap() {
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        // resize array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }

        size++;
        int index = size;
        array[index] = value;

        bubbleUp();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return array[1];
    }

    public T remove() {
        T result = peek();

        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown();

        return result;
    }

    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Performs the "bubble down" operation to place the element that is at the
     * root of the heap in its correct place so that the heap maintains the
     * min-heap order property.
     */
    void bubbleDown() {
        int index = 1;

        while (hasLeftChild(index)) {
            //Check which children is smaller
            int smallerChildIndex = leftIndex(index);

            if (hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChildIndex = rightIndex(index);
            }

            if (array[index].compareTo(array[smallerChildIndex]) > 0)
                swap(index, smallerChildIndex);
            else
                break;

            index = smallerChildIndex;
        }
    }

    /**
     * Performs the "bubble up" operation to place a newly inserted element
     * (i.e. the element that is at the size index) in its correct place so
     * that the heap maintains the min-heap order property.
     */
    void bubbleUp() {
        int index = this.size;

        while (hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {
            //swap parent and child, if they are out of order
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    boolean hasParent(int i) {
        return i > 1;
    }

    int leftIndex(int i) {
        return i * 2;
    }

    int rightIndex(int i) {
        return i * 2 + 1;
    }

    boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }

    boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }

    T parent(int i) {
        return array[parentIndex(i)];
    }

    int parentIndex(int i) {
        return i / 2;
    }

    T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
class Main{
    public static void main(String[] args) {
        Heap heap=new Heap(){{
            add(35);
            add(26);
            add(33);
            add(15);
            add(24);
            add(5);
            add(4);
            add(12);
            add(1);
            add(23);
            add(21);
            add(2);
        }};
//                        1
//                    /      \
//                  4          2
//                /   \       /   \
//               12    21    5     15
//              / \   / \   /
//            35  29 25 23 33

        System.out.println(heap.toString());
        //[null, 1, 4, 2, 12, 21, 5, 15, 35, 24, 26, 23, 33, null, null, null, null, null, null, null]
        
        System.out.println(heap.remove()); //1
        System.out.println(heap.remove()); //2
        System.out.println(heap.remove()); //4

    }
}
