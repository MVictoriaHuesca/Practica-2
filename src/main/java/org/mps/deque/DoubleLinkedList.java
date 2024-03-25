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

    @Override
    public T get(int index) {
        if(index < 0 || index > this.size()){
            throw new IndexOutOfBoundsException("The index is out of range");
        }

        LinkedNode<T> node = first;

        for(int i = 0; i < index; i++){
            node = node.getNext();
        }

        return node.getItem();
    }

    @Override
    public boolean contains(T value) {
        for(int i = 0; i < this.size(); i++){
            if(value.equals(get(i))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T value) {
        LinkedNode<T> node = first;

        boolean done = false;

        for(int i = 0; i < this.size() && !done; i++){
            if(value.equals(get(i))){

                if(node.isNotATerminalNode()){
                    node.getNext().setPrevious(node.getPrevious());
                    node.getPrevious().setNext(node.getNext());
                }
                else if(first == last){
                    first = null;
                    last = null;
                }
                else if(node.isFirstNode()){
                    node.getNext().setPrevious(null);
                    first = node.getNext();
                }
                else{
                    node.getPrevious().setNext(null);
                    last = node.getPrevious();
                }

                size--;
                done = true;
            }
            node = node.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {

        int ordenado = 0;  
        LinkedNode<T> currentNode;  
        LinkedNode<T> previousNode = null;     
    
        do
        {  
            ordenado = 0;  
            currentNode = first;  
    
            while (currentNode.getNext() != previousNode)  
            {  
                if (comparator.compare(currentNode.getItem(), currentNode.getNext().getItem()) > 0)  
                {  
                    T t = currentNode.getItem(); 
                    currentNode.setItem(currentNode.getNext().getItem()); 
                    currentNode.getNext().setItem(t); 
                    ordenado = 1;  
                }  
                currentNode = currentNode.getNext();  
            }  
            previousNode = currentNode;
             
        }  
        while (ordenado != 0); 
        
    }


}
