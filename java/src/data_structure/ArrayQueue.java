package data_structure;

public class ArrayQueue<E> implements Queue<E> {
    private final Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeLast();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getLength();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return array.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(2);
        System.out.println("queue = " + queue);
        queue.enqueue(1);
        System.out.println("queue = " + queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.getSize() = " + queue.getSize());
        System.out.println("queue.getFront() = " + queue.getFront());
        System.out.println("queue.getSize() = " + queue.getSize());
        queue.dequeue();
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }
}
