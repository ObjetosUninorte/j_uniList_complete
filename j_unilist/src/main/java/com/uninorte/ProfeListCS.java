package com.uninorte;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProfeListCS<E> extends AbstractList<E> {

    private Node startNode;
    private Node lastNode;

    public ProfeListCS() {
        this.startNode = null;
        this.lastNode = null;

    }

    @Override
    public int size() {
        Node node = this.startNode; // el nodo va a ser igual al cabecero de la lista, entonces si el cabecero es
        int c = 0;                            // nulo retonará cero como tamaño.
        while (node != null) {
            node = node.getNextNode();
            c++;
        }
        return c;
    }

    @Override
    public boolean isEmpty() {
        return startNode == null;
    }

    @Override
    public boolean contains(Object o) {
        boolean w = false;
        Node node = this.startNode;
        for (int i = 0; i < size(); i++) {
            if (node == null) {
                return w;
            } else if (node.getData() != o) {
                node = node.getNextNode();
                w = false;
            } else if (node.getData() == o) {
                w = true;
            }
        }
        return w;
    }


    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {
       return null;
    }

    @Override
    public boolean add(Object e) {
        Node node = new Node( e);
        if(startNode == null){
            startNode = node;
        }else{
            Node current = startNode;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(node);
            //nextNode = current.getNextNode();
            //nextNode = node;

        }
        return true;
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean remove(Object o) {
        boolean w = false;
        Node node = this.startNode;
        if (node == null) {
            return w;
        }
        Node puntero1 = node.getNextNode().getPrevNode();
        Node puntero2 = node.getPrevNode().getNextNode();
        while (node.getNextNode() != null && node.getData() != o) {
            node.getNextNode();
        }

        if (node == this.startNode) {
            this.startNode = node.getNextNode();
            if (this.startNode == null) {
                node = this.startNode.getPrevNode();
                node = null;
            }
            w = true;
        }
        if (node.getNextNode() != null) {
            puntero1 = node.getPrevNode();
        }

        if (node.getPrevNode() != null) {
            puntero2 = node.getNextNode();
        }
        return w;
    }

    @Override
    public boolean containsAll(Collection c) {
        Node node = this.startNode;
        int i = 0;
        boolean w = false;
        boolean s = true;
        if (node == null || c.size() == 0) {
            return w;
        }
        while (node.getNextNode() != null && i != c.size() && s == true) {
            if (node.getData() == c) {
                s = true;
                i++;
            } else {
                s = false;
                w = false;
            }
            if (node.getNextNode() == null && i == c.size() && s == true) {
                w = true;
            }
        }
        return w;
    }

    @Override
    public boolean addAll(Collection c) {
        int m = 0;
        Node n = this.startNode;
        Node l;
        if (n == null){
            for (int i = 0; i < c.size(); i++) {
                if (i == 0){
                    Node node = new Node(modCount, c.toArray()[m]);
                    startNode = node;
                    lastNode = node;
                    m++;
                }else{
                    Node node = new Node(modCount, c.toArray()[m]);
                    n = n.getNextNode();
                    l = n.getNextNode();
                    l = node;
                    node = node.getPrevNode();
                    node = n;
                    m++;
                }
            }
        }else{
            while(n.getNextNode() != null){
                n = n.getNextNode();
            }
            for (int i = 0; i < c.size(); i++) {
                Node node = new Node(modCount, c.toArray()[m]);
                l = n.getNextNode();
                node = node.getPrevNode();
                node = n; 
                m++;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
       int m = 0;
        Node n = this.startNode;
        Node l;
        if (n == null && index == 0){
            for (int i = 0; i < c.size(); i++) {
                if (i == 0){
                    Node node = new Node(index, c.toArray()[m]);
                    startNode = node;
                    lastNode = node;
                    m++;
                }else{
                    Node node = new Node(index, c.toArray()[m]);
                    n = n.getNextNode();
                    l = n.getNextNode();
                    l = node;
                    node = node.getPrevNode();
                    node = n;
                    m++;
                }
            }
        }else if(n == null && index > 0){
            System.out.println("No hay elementos que recorrer en la lista para alcanzar el indice.");
        }else{
            for (int i = 0; i < index; i++) {
                while(n.getNextNode() != null){
                    n = n.getNextNode();
                }
                if(i == index){
                    for (int j = 0; j < c.size(); j++) {
                        Node node = new Node(modCount, c.toArray()[m]);
                        l = n.getNextNode();
                        node = node.getPrevNode();
                        node = n; 
                        m++;
                    }
                }
            }

        }

        return true;
    }



    @Override
    public boolean removeAll(Collection c) {
        boolean modified = false;
        Node current = startNode;
        Node previous = null;
    
        while (current != null) {
            Node nextNode = current.getNextNode();
    
            if (c.contains(current.getData())) {
                if (previous == null) {
                    startNode = nextNode;
                } else {
                    previous.setNextNode(nextNode);
                }
    
                if (nextNode == null) {
                    lastNode = previous;
                } else {
                    nextNode.setPrevNode(previous);
                }
    
                modified = true;
      
            } else {
                previous = current;
            }
    
            current = nextNode;
        }
    
        return modified;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean modified = false;
        Node current = startNode;
        Node previous = null;

        while (current != null) {
            Node nextNode = current.getNextNode(); 

            if (!c.contains(current.getData())) {
                if (previous == null) {
                    startNode = nextNode;
                } else {
                    previous.setNextNode(nextNode);
                }

                if (nextNode == null) {
                    lastNode = previous;
                }

                modified = true;
             
            } else {
                previous = current;
            }
            current = nextNode;
        }

        return modified;
    }

    @Override
    public void clear() {
        startNode = null;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }

        Node current = startNode;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }

        Object oldData = current.getData();
        current.setData(element);
        return oldData;
    }

    @Override
    public void add(int index, Object element) {
        Node node = new Node(index, element);
        Node actual = this.startNode;
        Node l;
        if (actual == null && index == 0) {
            actual = node;
        }else if (actual == null && index >0){
            System.out.println("No hay elementos que recorrer para alcanzar ese indice dentro de la lista.");
        }else{
            for (int i = 0; i <= index; i++) {
                actual = actual.getNextNode();
                if (i == index){
                    actual = actual.getNextNode();//El nodo actual va a apuntar al siguiente nodo
                    l = actual.getNextNode();
                    l = node;//Y ese siguiente nodo dirije el puntero al nuevo nodo
                    node = node.getPrevNode();//El nodo nuevo al nodo anterior
                    node = actual;//El nodo que ahora es el anterior va al nodo llamado "actual" original.
                }
            }
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node node = this.startNode;
        for (int i = 0; i < size(); i++) {
            if (node == null){
                System.out.println("La lista está vacía.");
                return index;
            }else if (node.getData() != o){
                node = node.getNextNode();
                index++;
            }else if (node.getData() == o){
                return index;
            }
            
        }
        return index;
    }
    
    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node current = startNode;

        while (current != null) {
            if (current.getData() != null && current.getData().equals(o)) {
                lastIndex = currentIndex;
            }

            current = current.getNextNode();
            currentIndex++;
        }

        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }

        Node current = startNode;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }

        return  (E) current.getData();
    }

}
