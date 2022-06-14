/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTreeObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class MyTree {

    Node root;

    public MyTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void insertIfNotStartWithB(String name, int age) {
        if (name.substring(0, 1).equalsIgnoreCase("B")) {
            return;
        }
        if (isEmpty()) {
            root = new Node(name, age);
            return;
        }
        Node p = root;
        Node parent = null; //parent là cha của p, p là root ==> không có cha
        while (p != null) {
            if (p.info.getName().equalsIgnoreCase(name)) {
                return;
            }
            parent = p;
            if (p.info.getName().compareToIgnoreCase(name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //p = null, x chưa có trong tree
        //p la nơi chứa x
        //x sẽ là con trái hay phải của parent
        if (parent.info.getName().compareToIgnoreCase(name) > 0) {
            parent.left = new Node(name, age);
        } else {
            parent.right = new Node(name, age);
        }
    }

    void vist(Node p) {
        System.out.print(p.info.toString() + ", ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        vist(p);
        preOrder(p.left);
        preOrder(p.right);

    }

    void preOrder() {
        preOrder(root);
        System.out.println();
    }

    void breadth() {
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            vist(p);
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        System.out.println("");
    }

    Person min() {

        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.info;
    }

    //2. Clear the tree
    public void clear() {
        root = null;
    }

    //3. Search
    Node search(String name) {
        if (isEmpty()) {
            return null;
        }
        Node p = root;
        while (p != null) {
            if (p.info.getName().equalsIgnoreCase(name)) {
                return p;
            }
            if (p.info.getName().compareToIgnoreCase(name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    //7. Inorder trverse
    public void inorder(Node p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        vist(p);
        inorder(p.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    //8. Postorder
    public void postorder(Node p) {
        if (p == null) {
            return;
        }
        postorder(p.left);
        postorder(p.right);
        vist(p);
    }

    public void postorder() {
        postorder(root);
    }

    //9. Count
    public int count(Node p) {
        if (p == null) {
            return 0;
        }
        int count = 0;
        if (p != null) {
            count++;
        }
        count += count(p.left) + count(p.right);
        return count;
    }

    int count() {
        if (isEmpty()) {
            return 0;
        }
        return count(root);
    }

    //12. Max
    public Person max() {
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.info;
    }

    //15. Height
    public int findMax(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public int getHeight(Node p) {
        if (p == null) {
            return 0;
        }
        //vist(p);
        return findMax(getHeight(p.right), getHeight(p.left)) + 1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);//compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);//use the larger one
            } else {
                return (rDepth + 1);
            }
        }
    }
    
    public void printBalanceFactor(){

        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            System.out.println(p.info.toString() + ": " + getBalanceFactor(p) + "\t");
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        System.out.println("");
    }
    
    public int getBalanceFactor(Node p){
        return getHeight(p.right) - getHeight(p.left);
    }

    //10. Delete
    public void delete(String name) {
        //Tìm node chứa x
        //Phân loại trường hợp xóa node chứa x
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.getName().equalsIgnoreCase(name)) {
                break;
            }
            parent = p;
            if (p.info.getName().compareTo(name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }

        }
        //p == null => không có x trong tree, hoặc p chứa x
        if (p == null) {
            return;
        }
        //p chắc chắn khác null
        //---------Trường hợp 1: p không có con------------
        /*
                parent      parent           p
               p                   p
         */
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //---------Trường hợp 1: p có 1 con------------
        /*
            parent      parent      parent        parent             p        p
           p           p                   p             p          L           R
          L              R               L                  R                                
         */ //p has left child only
        else if (p.left != null && p.right == null) {
            if (parent == null) {
                root = p.left;
            } else if (parent.left == p) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } //p has right child only
        else if (p.left == null && p.right != null) {
            if (parent == null) {
                root = p.right;
            } else if (parent.left == p) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } //---------Trường hợp 1: p có 2 con------------
        /*
                p                   p
          p.L                     rm
          ...                   L
             parentRM
                      rm
                   L 
         */ else if (p.left != null && p.right != null) {
            //Tìm rightmost của p.L
            //Copy giá trị của rightmost vào p
            //xóa rightmost
            Node rm = p.left;
            Node parentRM = null;
            while (rm.right != null) {
                parentRM = rm;
                rm = rm.right;
            }
            //rm không bao giờ bằng null
            //parentRM có thể là null
            p.info = rm.info;
            if (parentRM == null) {
                p.left = rm.left;
            } else {
                parentRM.right = rm.left;
            }
        }

    }

    public void singleBalance(Node data[], int first, int last) {

        if (first <= last) {
            int middle = (first + last) / 2;
            insertIfNotStartWithB(data[middle].info.getName(), data[middle].info.getAge());
            singleBalance(data, first, middle - 1);
            singleBalance(data, middle + 1, last);
        }
    }

    public void singleBalance() {
        Node[] data = new Node[count()];
        MyQueue q = new MyQueue();
        data = new Node[count()];
        int i = 0;
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            data[i++] = p;
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        root = null;
        singleBalance(data, 0, data.length - 1);
    }

    public void rotateLeft(Node par) {
        Node gr = null;
        Node p = root;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.getName().compareToIgnoreCase(par.info.getName()) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p.right == null) {
            return;
        }
        Node ch = p.right;
        p.right = ch.left;
        ch.left = p;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }
    }

    public void rotateRight(Node par) {
        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.getName().compareToIgnoreCase(par.info.getName()) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (par.left == null) {
            return;
        }
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }
    }

    public void delte2ndNodeGreaterAgeAverageByBreath() {
        int count = 0;
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            //vist(p);
            if (p.info.getAge() >= ageAverage()) {
                count += 1;
            }
            if (count == 2) {
                delete(p.info.getName());
                return;
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
    }

    public int sumAge(Node p) {
        if (p == null) {
            return 0;
        }
        int sum = 0;
        sum += p.info.getAge();
        return sum += sumAge(p.left) + sumAge(p.right);
    }

    public double ageAverage() {
        return sumAge(root) / count();
    }

    public String getcontent(Node p) throws IOException {
        String store = "";
        if (p == null) {
            return "";
        }
        if (p.info.getAge() < ageAverage()) {
            store += p.info.toString() + " ";
        }
        store += getcontent(p.left) + getcontent(p.right);
        return store;
    }

    public void writeFile() throws IOException {
        File source = new File("q2.txt");
        FileWriter out = new FileWriter(source);
        out.write(getcontent(root));
        out.close();
    }

    int countRightChild = 0;

    public void rotateByPreOrder(Node p) {
        if (p == null) {
            return;
        }
        if (p.right != null) {
            countRightChild++;
        }
        if (countRightChild == 3) {
            rotateLeft(p);
            return;
        }
        rotateByPreOrder(p.left);
        rotateByPreOrder(p.right);
    }

    public void rotateByPreOrder() {
        rotateByPreOrder(root);
    }

}
