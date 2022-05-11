package data_structure;

public class ArrayStack<E> implements Stack<E> {
    private final Array<E> mData;

    public ArrayStack(int capacity) {
        mData = new Array<>(capacity);
    }

    public ArrayStack() {
        mData = new Array<>();
    }

    @Override
    public void push(E e) {
        mData.addLast(e);
    }

    @Override
    public E pop() {
        return mData.removeLast();
    }

    @Override
    public E peek() {
        return mData.get(mData.getLength() - 1);
    }

    @Override
    public int getSize() {
        return mData.getLength();
    }

    @Override
    public boolean isEmpty() {
        return mData.isEmpty();
    }

    @Override
    public String toString() {
        return mData.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        System.out.println("stack = " + stack);
        stack.push(2);
        System.out.println("stack = " + stack);
        stack.push(3);
        System.out.println("stack = " + stack);
        stack.pop();
        System.out.println("stack = " + stack);
        stack.peek();
        System.out.println("stack = " + stack);
        System.out.println("stack.getSize() = " + stack.getSize());
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
    }
}
