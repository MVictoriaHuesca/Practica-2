package org.mps.deque;

import java.util.Comparator;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        // TODO
    }

    @Override
    public void prepend(T value) {
        // TODO
    }

    @Override
    public void append(T value) {
        // TODO
    }

    @Override
    public void deleteFirst() {
<<<<<<< Updated upstream
        // TODO
=======

        if(first == null){
            throw new DoubleLinkedQueueException("The list is empty");
        }

        first = first.getNext();
        first.setPrevious(null);
        size--;
>>>>>>> Stashed changes
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }

}
