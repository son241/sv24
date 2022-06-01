/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTree;

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

    /*
                      50
            30                  90
        15      40          70      100
    10              45
        
     */
    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node p = root;
        Node parent = null; //parent là cha của p, p là root ==> không có cha
        while (p != null) {
            if (p.info == x) {
                return;
            }
            parent = p;
            if (p.info > x) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //p = null, x chưa có trong tree
        //p la nơi chứa x
        //x sẽ là con trái hay phải của parent
        if (parent.info > x) {
            parent.left = new Node(x);
        } else {
            parent.right = new Node(x);
        }
    }

    void vist(Node p) {
        System.out.print(p.info + " ");
    }
    int i = 0;

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

    int min() {

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
    Node search(int x) {
        if (isEmpty()) {
            return null;
        }
        Node p = root;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            if (p.info > x) {
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
    public int max() {
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.info;
    }

    //13. Sum
    public int sum(Node p) {
        if (p == null) {
            return 0;
        }
        int sum = 0;
        sum += p.info;
        return sum += sum(p.left) + sum(p.right);
    }

    public int sum() {
        return sum(root);
    }
    
    //14. Average
    public double avg(){
        return (double)sum() / (double)count();
    }
    
    //15. Height
    public int findMax(int a, int b){
        if (a >= b) {
            return a;
        }
        return b;
    }
    public int getHeight(Node p){
        if (p == null) {
            return 0;
        }
        //vist(p);
        return findMax(getHeight(p.left), getHeight(p.right)) + 1;
    }
    public int getHeight(){
        return getHeight(root);
    }
    
    //16.Cost
    
}
