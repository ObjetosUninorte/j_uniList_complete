package com.uninorte;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class ProfeImplementedList<E> extends AbstractList<E>{

    private Node head;

    @Override
    public int size() {
        int size = 0;
        Node current = head;
        while(current != null){
            size++;
            current = current.getNextNode();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while(current != null){
            if(current.getData().equals(o)){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean add(Object e) {
        Node newNode = new Node(0,e);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.getNextNode() != null){
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        return true;
    }

    @Override
    public E remove(int index) {
        Node current = head;
        Node prev = null;
        int i = 0;
        while(current != null){
            if(i == index){
                if(prev == null){
                    head = current.getNextNode();
                }else{
                    prev.setNextNode(current.getNextNode());
                }
            }
            prev = current;
            current = current.getNextNode();
            i++;
        }
    
        return null;

    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        Node prev = null;
        while(current != null){
            if(current.getData().equals(o)){
                if(prev == null){
                    head = current.getNextNode();
                }else{
                    prev.setNextNode(current.getNextNode());
                }
                return true;
            }
            prev = current;
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Node current = head;
        while(current != null){
            if(!c.contains(current.getData())){
                return false;
            }
            current = current.getNextNode();
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Node current = head;
        if (current != null) {
            while(current.getNextNode() != null){
                current = current.getNextNode();
            }
        }   
        for(Object o : c){
            Node newNode = new Node(0,o);
            if (current == null) {
                head = newNode;
                current = newNode;
            } else {
            current.setNextNode(newNode);
            current = newNode;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Node current = head;
        Node prev = null;
        int i = 0;
        while(current != null){
            if(i == index){
                break;
            }
            prev = current;
            current = current.getNextNode();
            i++;
        }
        for(Object o : c){
            Node newNode = new Node(0,o);
            if(prev == null){
                newNode.setNextNode(head);
                head = newNode;
            }else{
                prev.setNextNode(newNode);
                newNode.setNextNode(current);
            }
            prev = newNode;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removed = false;
        Node current = head;
        Node prev = null;
        while(current != null){
            if(c.contains(current.getData())){
                if(prev == null){
                    head = current.getNextNode();
                }else{
                    prev.setNextNode(current.getNextNode());
                }
                removed = true;
            }else{
                prev = current;
            }
            current = current.getNextNode();
        }
        return removed;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean removed = false;
        Node current = head;
        Node prev = null;
        while(current != null){
            if(!c.contains(current.getData())){
                if(prev == null){
                    head = current.getNextNode();
                }else{
                    prev.setNextNode(current.getNextNode());
                }
                removed = true;
            }else{
                prev = current;
            }
            current = current.getNextNode();
        }
        return removed;
    }

    @Override
    public void clear() {
        head = null;
    }



    @Override
    public Object set(int index, Object element) {
        Node current = head;
        int i = 0;
        while(current != null){
            if(i == index){
                Object oldData = current.getData();
                current.setData(element);
                return oldData;
            }
            current = current.getNextNode();
            i++;
        }
        return null;
    }

    @Override
    public void add(int index, Object element) {
        Node current = head;
        Node prev = null;
        int i = 0;
        while(current != null){
            if(i == index){
                Node newNode = new Node(0,element);
                if(prev == null){
                    newNode.setNextNode(head);
                    head = newNode;
                }else{
                    prev.setNextNode(newNode);
                    newNode.setNextNode(current);
                }
                return;
            }
            prev = current;
            current = current.getNextNode();
            i++;
        }
    }


    @Override
    public int indexOf(Object o) {
        Node current = head;
        int i = 0;
        while(current != null){
            if(current.getData().equals(o)){
                return i;
            }
            current = current.getNextNode();
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current = head;
        int i = 0;
        int lastIndex = -1;
        while(current != null){
            if(current.getData().equals(o)){
                lastIndex = i;
            }
            current = current.getNextNode();
            i++;
        }
        return lastIndex;
    }


    @Override
    public List subList(int fromIndex, int toIndex) {
        Node current = head;
        ProfeImplementedList<E> list = new ProfeImplementedList<>();
        int i = 0;
        while(current != null){
            if(i >= fromIndex && i < toIndex){
                list.add((E) current.getData());
            }
            current = current.getNextNode();
            i++;
        }
        return list;
    }

    @Override
    public E get(int index) {
        Node current = head;
        int i = 0;
        while(current != null){
            if(i == index){
                return (E) current.getData();
            }
            current = current.getNextNode();
            i++;
        }
        return null;
    }
    
}
