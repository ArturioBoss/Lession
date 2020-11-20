package structure.list;

import structure.list.impl.DoublyLinkedList;
import structure.list.impl.SingleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");

        GBIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("Size before remove " + list.size());

        boolean isToyotaRemoved = list.remove("TOYOTA");
        System.out.println("Is toyota removed? " + isToyotaRemoved);
        System.out.println("Size after remove " + list.size());

        System.out.println("ТУТ: "+list.get(2));

        GBListD list2 = new DoublyLinkedList();
        list2.add("A");
        list2.add("B");
//        list2.add("C");
//        list2.add(3,"D");
        System.out.println(list2.toString());
//        GBIteratorD iteratorD = list2.iterator();
//        while (iteratorD.hasNext()) {
//            String next = iteratorD.next();
//            System.out.println(next);
//        }
//        boolean isLink = list2.remove("B");
//        System.out.println("Del " + isLink);
    }
}
