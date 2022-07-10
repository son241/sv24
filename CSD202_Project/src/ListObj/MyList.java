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
        if (p.info.getAge() < 17 || p.info.getName().substring(0, 1).equalsIgnoreCase("B")) {
            return;
        } else {
            if (isEmpty()) {
                head = tail = p;
                return;
            }
            tail.next = p;
            tail = p;
        }
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

    Node getLastNodeByAge(int age) {
        Node p = head;
        Node target = null;
        while (p != null) {
            if (p.info.getAge() == age) {
                target = p;
            }
            p = p.next;
        }
        return target;
    }

    void delByAge(int age) {
        Node p = head;
        while (p != null) {
            if (p.info.getAge() == age) {
                dele(p);
                return;
            }
            p = p.next;
        }
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

    void add(String name, int age, int index) {
        Node p = head;
        Node newNode = new Node(name, age);
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
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

    void sortByAge() {
        if (isEmpty() || count() == 1) {
            return;
        }
        Node p = head;
        Person temp;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.info.getAge() < q.info.getAge()) {
                    temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
                q = q.next;
            }
            p = p.next;
        }
    }

    void sort(int startIndex, int lastIndex) {
        Node start = null, end = null;
        Node p = head;
        Node current;
        Node q;
        Person temp;
        int count = 0;

        while (p != null) {
            if (count == startIndex) {
                start = p;
            }
            if (count == lastIndex) {
                end = p;
            }
            count++;
            p = p.next;
        }
        
        current = start;
        while (current != end) {            
            q = current.next;
            while (q != end) {                
                if (q.info.getName().compareTo(current.info.getName()) < 0) {
                    temp = q.info;
                    q.info = current.info;
                    current.info = temp;
                }
                q = q.next;
            }
            current = current.next;
        }
        
    }

    void displayFirst5ByAge(int age) {
        int count = 0;
        Node p = head;

        while (p != null && count < 5) {
            if (p.info.getAge() > age) {
                count++;
                System.out.println(p.info.toString());
            }
            p = p.next;
        }

    }

    void displayByAge(int age) {
        Node p = head;
        while (p != null) {
            if (p.info.getAge() == age) {
                System.out.println(p.info.toString());
                return;
            }
            p = p.next;
        }
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
