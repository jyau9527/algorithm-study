package data_structure;

public class ArrayStack<E> implements Stack<E> {
    private final Array<E> array = new Array<>();

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getLength() - 1);
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
}
