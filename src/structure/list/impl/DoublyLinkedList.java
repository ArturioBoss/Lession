package structure.list.impl;

import structure.list.GBIteratorD;
import structure.list.GBListD;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList implements GBListD {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    @Override
    public void add(String val) {

//        if (first == null){
//            first = new Node(null,val);
//            last = new Node(val,null);
//        }else {
//            add(first,val,last);
//            size++;
//        }
//        last = new Node(val,null);
        Node oldLast = last;
        last = new Node(val,null);
        if (first == null){
            first = last;
        }else {
            oldLast.next = last;
        }


    }

//    public void addFirst(int aValue) {
//        final Node currFirst = first;
//        final Node newNode = new Node(null, currFirst, aValue);
//        first = newNode;
//        if(currFirst == null)  // if empty list
//            last = newNode;
//        else
//            currFirst.prev = newNode;
//    }
//
//    public void addLast(int aValue) {
//        final Node currLast = last;
//        final Node newNode = new Node(currLast, null, aValue);
//        last = newNode;
//        if(currLast == null)  // if empty list
//            first = newNode;
//        else
//            currLast.next = newNode;
//    }

    @Override
    public boolean remove(String val) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public GBIteratorD iterator() {
        return new ForwardIterator(first);
    }

    private static class Node {
        private Object element;
        private String val;
        private Node next;
        private Node prev;

        public Node(Node prev, String val, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node (Node prev, String val) {
            this(prev, val, null);
        }

        public Node (String val, Node next) {
            this(null, val, next);
        }



        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", element=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static class ForwardIterator implements GBIteratorD {
        private Node current;


        public ForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public String prev() {
            String val = current.val;
            current = current.prev;
            return val;
        }
    }

}
