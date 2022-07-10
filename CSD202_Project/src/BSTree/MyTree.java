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
    public double avg() {
        return (double) sum() / (double) count();
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
        return findMax(getHeight(p.left), getHeight(p.right)) + 1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    //10. Delete
    public void delete(int x) {
        //Tìm node chứa x
        //Phân loại trường hợp xóa node chứa x
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            parent = p;
            if (p.info > x) {
                p = p.left;
            } else {
                p = p.right;
            }

        }
        //p == null => không có x trong trê, hoặc p chứa x
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
          L              R               L                  R    */                            
                  if (p.left != null && p.right == null) {
                    if (parent == null) {
                        root = p.left;
                    } else if (parent.left == p) {
                        parent.left = p.left;
                    } else {
                        parent.right = p.left;
                    }
                } else if (p.left == null && p.right != null) {
                    if (parent == null) {
                        root = p.right;
                    } else if (parent.left == p) {
                        parent.left = p.right;
                    } else {
                        parent.right = p.right;
                    }
                }

        //---------Trường hợp 1: p có 2 con------------
        /*
                p                   p
          p.L                     rm
          ...                   L
             parentRM
                      rm
                   L 
         */
        if (p.left != null && p.right != null) {
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
//            parent.left = p.left;
//            rm.right = p.right;
        }

    }

    public void singleBalance(Node data[], int first, int last) {

        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data[middle].info);
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

    public Node getParent(Node target) {
        Node p = root;
        if (count() == 1) {
            return null;
        }
        Node parent = null;
        while (p != null) {
            if (p == target) {
                break;
            }
            parent = p;
            if (p.info > target.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }

    public void rotateRight(Node par) {
        if (par.left == null) {
            return;
        }
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        getParent(par).left = ch;
    }

    public void rotateLeft(Node par) {
        if (par.right == null) {
            return;
        }
        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        getParent(par).left = ch;
    }
}
