package org.mps.deque;

import java.util.Comparator;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> node = new LinkedNode<T>(value,null,first);

        if(first== null){
            first = node;
            last = node;
        }
        else{
            first.setPrevious(node);
            first = node;
        }
        size++;
    }

    @Override
    public void append(T value) {
        LinkedNode<T> node = new LinkedNode<T>(value,last,null);

        if(last == null){
            first = node;
            last = node;
        }
        else{
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {

        if(first == null){
            throw new DoubleLinkedQueueException("The list is empty");
        }

        first = first.getNext();
        first.setPrevious(null);
        size--;
    }

    @Override
    public void deleteLast() {
        if(last == null){
            throw new DoubleLinkedQueueException("La lista enlazada esta vacia");
        }

        last = last.getPrevious();
        last.setNext(null);
        size--;
    }

    @Override
    public T first() {
        if(this.first == null){
            throw new DoubleLinkedQueueException("La lista enlazada esta vacia");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        if(this.last == null){
            throw new DoubleLinkedQueueException("La lista enlazada esta vacia");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return size;
    }

}
