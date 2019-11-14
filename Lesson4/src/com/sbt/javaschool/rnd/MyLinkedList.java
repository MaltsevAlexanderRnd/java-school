package com.sbt.javaschool.rnd;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    int size;

    public MyLinkedList() {
        this.first = null;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        Node(E element) {
            this.element = element;
        }
    }



    public void add(E e) {
        Node<E> newNode = new Node(e);
        if(first == null){
            newNode.next = null;
            newNode.prev = null;
            first = newNode;
            last = newNode;
            } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void add(int index, E element){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(element);
        if (index == 0) {
            add(element);
        }
        if (index == size) {
            last.next = newNode;
            last = newNode;
        }
        Node oldNode = first;
        for (int i = 0; i < index; i++) {
            oldNode = oldNode.next;
        }
        Node oldPrevious = oldNode.prev;
        oldPrevious.next = newNode;
        oldNode.prev = newNode;

        newNode.prev = oldPrevious;
        newNode.next = oldNode;
        size++;
    }


    public E get(int index)
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

         return (E) result.element;
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> node = findPrevIndexNode(index);
            Node<E> tmp = findIndex(index);
            node.next = tmp.next;
        }
        size--;
        return (E) first;
    }

    private Node<E> findPrevIndexNode(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Node<E> node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }


    public Node<E> findIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        Node<E> node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        private int size;

        public ListItr(int index) {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    public boolean addAll(Collection<?> c)
    {
        Iterator<?> iterator = c.iterator();
        while(iterator.hasNext())
        {
            add((E) iterator.next());
        }
        return true;
    }

    public boolean copy(Collection<?> c)
    {
        Iterator<?> iterator = c.iterator();
        int index=1;
        while(iterator.hasNext())
        {
            add(index, (E) iterator.next());
            index++;
        }
        return true;
    }

    public void OutputList() {
        if(first == null)
            return;

        Node<E> temp = first;
        while( temp != null ) {
            System.out.print(temp.element.toString() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
