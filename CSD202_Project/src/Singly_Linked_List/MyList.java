/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListObj;

/**
 *
 * @author Admin
 */
public class MyList {

    Node head;
    Node tail;

    MyList() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(String name, int age) {
        Node p = new Node(name, age);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    void addLast(String name, int age) {
        Node p = new Node(name, age);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    Person delFromHead() {
        if (isEmpty()) {
            return null;
        }
        Person x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return x;
    }

    void delete(Person x) {
        Node p = head;
        if (isEmpty()) {
            return;
        }
        while (p != null) {
            if (p.next.info == x) {
                Node nodeToDelete = p;
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }

    public void dele(Node p) {
        if (isEmpty()) {
            return;
        }
        Node a = head;
        if (p == tail) {
            delFromTail();
        }
        if (p == head) {
            delFromHead();
        }
        while (a != null) {
            if (a.next == p) {
                a.next = a.next.next;
            }
            a = a.next;
        }

    }

//    void delete(int i) throws NullPointerException {     
//        Node p = head;  
//        if (isEmpty()) {
//            return;
//        }
//        if (i > 0 && i <= count()) {
//            for (int j = 1; j < i - 1; j++) {
//                p = p.next;
//            }
//            Node nodeToDelete = p.next;
//            p.next = p.next.next;
//            nodeToDelete = null;
//        }else
//            return;
//    }
    Node search(Person x) {
        Node p = head;
        if (isEmpty()) {
            return null;
        }
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    int count() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    void delFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }

        /*
        if(head == taill){
            head = tail = null;
        }else
            head = head.next
         */
    }

    void delFromTail() {
        Node p = head;
        while (p != null) {
            if (p.next == tail) {
                p.next = null;
                tail = p;
            }
            p = p.next;
        }

    }

    int deleteAfter(Node p) {
        Node nodeToDelete;
        Node a = head;
        int x = -1;
        if (isEmpty()) {
            System.out.println("List is empty!");
            return -1;
        }
        if (count() == 1) {
            System.out.println("Fail to delete!");
            return -1;
        }
//        while (a != null) {
//            if (a == p) {
//                nodeToDelete = a.next;
//                nodeToDelete = null;
//                x = nodeToDelete.info;
//                a.next = a.next.next;
//            }
//            a = a.next;
//        }
        //nodeToDelete = p.next;
        p.next = p.next.next;
        if (p.next == tail) {
            tail = p;
        }

        return x;
    }

    void addAfter(Node p, String name, int age) {
        Node new_node = new Node(name, age);
        Node a = head;
        while (a != null) {
//            if (search(p.info) == null) {
//                return;
//            }
            if (a == p) {
                new_node.next = a.next;
                a.next = new_node;
                if (a == tail) {
                    tail = new_node;
                }
                return;
            }
            a = a.next;
        }
    }

//    void sort() {
//        if (isEmpty() || (head.next == null)) {
//            return;
//        }
//        Node p = head;
//        while (p != null) {
//            int temp;
//            Node current = p.next;
//            while (current != null) {
//                if (p.info > current.info) {
//                    temp = p.info;
//                    p.info = current.info;
//                    current.info = temp;
//                }
//                current = current.next;
//            }
//            p = p.next;
//        }
//    }

//    int max() {
//        int max = head.info;
//        Node p = head;
//        if (isEmpty()) {
//            return -1;
//        }
//        if (head.next == null || head == tail) {
//            return head.info;
//        }
//        while (p != null) {
//            if (p.info > max) {
//                max = p.info;
//            }
//            p = p.next;
//        }
//        return max;
//    }

//    int sum() {
//        int sum = 0;
//        Node p = head;
//        while (p != null) {
//            sum += p.info;
//            p = p.next;
//        }
//        return sum;
//    }

//    int min() {
//        int min = head.info;
//        Node p = head;
//        while (p != null) {
//            if (p.info < min) {
//                min = p.info;
//            }
//            p = p.next;
//        }
//        return min;
//    }

//    double average() {
//        return (double) sum() / (double) count();
//    }

//    boolean isAscend() {
//        boolean ascendFlag = true;
//        Node p = head;
//        Node current = p.next;
//
//        while (current != null) {
//            if (p.info <= current.info) {
//                ascendFlag = true;
//            } else {
//                return false;
//            }
//            p = p.next;
//            current = current.next;
//        }
//
//        return ascendFlag;
//    }
//
//    boolean isDescend() {
//        boolean descendFlag = true;
//        Node p = head;
//        Node current = p.next;
//
//        while (current != null) {
//            if (p.info >= current.info) {
//                descendFlag = true;
//            } else {
//                return false;
//            }
//            p = p.next;
//            current = current.next;
//        }
//
//        return descendFlag;
//    }
//
    Person[] toArray() {
        Person[] arr = new Person[count()];
        Node p = head;
        int i = 0;
        if (isEmpty()) {
            return null;
        }
        while (p != null) {
            arr[i] = p.info;
            i++;
            p = p.next;
        }
        return arr;
    }

    public void appendList(MyList list) {

    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
        System.out.println("");
    }
}
