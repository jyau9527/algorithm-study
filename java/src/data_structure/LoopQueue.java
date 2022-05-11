package data_structure;

public class LoopQueue<E> implements Queue<E> {
    private E[] mData;
    private int mFront = 0;
    private int mTail = 0;

    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        mData = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(8);
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize(getCapacity() * 2);
        }

        mData[mTail] = e;
        mTail = (mTail + 1) % mData.length;
    }

    @Override
    public E dequeue() {
        E e = mData[mFront];
        mData[mFront] = null;
        mFront = (mFront + 1) % mData.length;

        if (getSize() <= getCapacity() / 4 && getCapacity() / 2 > 1) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] tmp = (E[]) new Object[newCapacity + 1];
        int newTail = 0;
        for (int i = mFront; i != mTail; i = (i + 1) % mData.length) {
            tmp[newTail++] = mData[i];
        }
        mFront = 0;
        mTail = newTail;
        mData = tmp;
    }

    @Override
    public E getFront() {
        return mData[mFront];
    }

    @Override
    public int getSize() {
        return (mTail + mData.length - mFront) % mData.length;
    }

    public int getCapacity() {
        return mData.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return mFront == mTail;
    }

    private boolean isFull() {
        return (mTail + 1) % mData.length == mFront;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = mFront; i != mTail; i = (i + 1) % mData.length) {
            builder.append(mData[i]);
            if ((i + 1) % mData.length != mTail) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(4);

        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        System.out.println("queue = " + queue);
        System.out.println("queue.getCapacity() = " + queue.getCapacity());
        System.out.println("queue.getSize() = " + queue.getSize());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.getSize() = " + queue.getSize());
        queue.enqueue(5);
        System.out.println("queue = " + queue);
        System.out.println("queue.getSize() = " + queue.getSize());

        queue.enqueue(6);
        System.out.println("queue = " + queue);
        System.out.println("queue.getCapacity() = " + queue.getCapacity());

        System.out.println("queue.isEmpty() = " + queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        System.out.println("queue.getCapacity() = " + queue.getCapacity());
        queue.dequeue();
        System.out.println("queue.getCapacity() = " + queue.getCapacity());
        queue.dequeue();
        queue.dequeue();
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }
}
