package data_structure;

import java.util.Arrays;

public class Array<E> {
    private E[] mArray;
    private int mSize;
    private int mCapacity;

    public Array(int capacity) {
        mCapacity = capacity;
        mArray = (E[]) new Object[capacity];
    }

    public Array() {
        this(8);
    }

    public void addLast(E e) {
        if (mSize >= mCapacity) {
            resize();
        }
        mArray[mSize] = e;
        mSize++;
    }

    public void insert(int i, E e) {
        if (mSize >= mCapacity) {
            resize();
        }
        System.arraycopy(mArray, i, mArray, i + 1, mSize - i);
        mArray[i] = e;
        mSize++;
    }

    public E removeLast() {
        E last = mArray[mSize - 1];
        mArray[mSize - 1] = null;
        mSize--;
        if (mSize <= mCapacity / 4) {
            resize();
        }
        return last;
    }

    public void removeAt(int i) {
        System.arraycopy(mArray, i + 1, mArray, i, mSize - i);
        mArray[mSize - 1] = null;
        mSize--;
        if (mSize <= mCapacity / 4) {
            resize();
        }
    }

    public void set(int i, E e) {
        if (i >= mSize) {
            throw new IllegalArgumentException("out of range: size = " + mSize + ", i = " + i);
        } else {
            mArray[i] = e;
        }
    }

    public E get(int i) {
        if (i >= mSize) {
            throw new IllegalArgumentException("out of range: size = " + mSize + ", i = " + i);
        } else {
            return mArray[i];
        }
    }

    public int getLength() {
        return mSize;
    }

    public boolean isEmpty() {
        return mSize == 0;
    }

    private void resize() {
        if (mSize >= mCapacity) {
            E[] tmp = mArray;
            mArray = (E[]) new Object[mCapacity * 2];
            System.arraycopy(tmp, 0, mArray, 0, mSize);
            mCapacity *= 2;
        } else if (mSize <= mCapacity / 4 && mCapacity / 2 > 1) {
            E[] tmp = mArray;
            mArray = (E[]) new Object[mCapacity / 2];
            System.arraycopy(tmp, 0, mArray, 0, mSize);
            mCapacity /= 2;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");

        for (int i = 0; i < mSize; i++) {
            s.append(mArray[i]);
            if (i < mSize - 1) {
                s.append(", ");
            }
        }

        s.append("]");
        return s.toString();
    }
}
