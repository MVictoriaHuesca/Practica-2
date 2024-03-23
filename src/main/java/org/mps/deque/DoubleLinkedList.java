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

    @Override
    public T get(int index){
        if(index <= 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        LinkedNode<T> current = this.first;
        for (int i=0; i<index; i++) {
            current = current.getNext();
        }
        return current.getItem();
    }

    @Override
    public boolean contains(T value) {
        if(this.first == null){
            return false;
        }
        LinkedNode<T> current = this.first;
        while(current.getItem() != value && current.getNext() != null){
            current = current.getNext();
        }
        return current.getItem() == value;
    }

    @Override
    public void remove(T value) {
        if(!this.contains(value)){
            return;
        } else {
            LinkedNode<T> current = this.first;
            while(current.getItem() != value) {
                current = current.getNext();
            }
            if(current.isNotATerminalNode()) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious()); 
                size--;
            }else if (current.isFirstNode()) {
                deleteFirst();
            } else {
                deleteLast();
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        int swaped;
        LinkedNode<T> ptr1;
        LinkedNode<T> lptr = null;
        if(this.first == null){
            return;
        }
        do {
            swaped = 0;
            ptr1 = this.first;
            while(ptr1.getNext() != lptr) {
                if(comparator.compare(ptr1.getItem(), ptr1.getNext().getItem()) > 0) {
                    T temp = ptr1.getItem();
                    ptr1.setItem(ptr1.getNext().getItem());
                    ptr1.getNext().setItem(temp);
                    swaped = 1;
                }
                ptr1 = ptr1.getNext();
            }
            lptr = ptr1;
        } while(swaped != 0);
    }
}

