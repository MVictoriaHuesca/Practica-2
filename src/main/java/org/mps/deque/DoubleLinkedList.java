package org.mps.deque;

import java.util.Comparator;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> node = new LinkedNode<>(value, null, first);
        if(first == null) {     
            last = node;
        } else {
            first.setPrevious(node);
        }
        first = node;
        this.size++;
    }

    @Override
    public void append(T value) {
        LinkedNode<T> node = new LinkedNode<>(value, last, null);
        if (first == null) {
            first = node;
        } else {
            last.setNext(node);
        }
        this.last = node;
        this.size++;
    }

    @Override
    public void deleteFirst() throws DoubleLinkedQueueException{
        if(this.first == null){
            throw new DoubleLinkedQueueException("The LinkedList is empty");
        }
        if(this.first.getNext() == null){
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
        }
        size--;
        
    }

    @Override
    public void deleteLast() throws DoubleLinkedQueueException{
        if(this.last == null){
            throw new DoubleLinkedQueueException("The LinkedList is empty");
        }
        if(this.last.getPrevious() == null){
            this.first = null;
            this.last = null;
        } else {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
        }
        size--;
    }

    @Override
    public T first() throws DoubleLinkedQueueException{
        if(this.first == null){
            throw new DoubleLinkedQueueException("The LinkedList is empty");
        }
        return this.first.getItem();
    }

    @Override
    public T last() throws DoubleLinkedQueueException{
        if(this.last == null){
            throw new DoubleLinkedQueueException("The LinkedList is empty");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }
}
