/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_csd201;

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

    void insert(String id, String name, double rate) {
        if (name.toLowerCase().contains("pa") || rate <= 3) {
            return;
        }

        if (isEmpty()) {
            root = new Node(id, name, rate);
            return;
        }
        Node p = root;
        Node parent = null; //parent là cha của p, p là root ==> không có cha
        while (p != null) {
            if (p.info.getId().equalsIgnoreCase(id)) {
                return;
            }
            parent = p;
            if (p.info.getId().compareToIgnoreCase(id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //p = null, x chưa có trong tree
        //p la nơi chứa x
        //x sẽ là con trái hay phải của parent
        if (parent.info.getId().compareToIgnoreCase(id) > 0) {
            parent.left = new Node(id, name, rate);
        } else {
            parent.right = new Node(id, name, rate);
        }
    }

    public void traverse() {
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (level(p) >= 4) {
                System.out.println("(" + p.info.getId() + " | " + p.info.getName() + " | " + p.info.getRate() + " | " + level(p) + ")");
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        System.out.println("");
    }

    public int getHeight(Node p) {
        if (p == null) {
            return 0;
        }
        //vist(p);
        return Math.max(getHeight(p.left), getHeight(p.right)) + 1;
    }

    public int level(Node p) {
        return getHeight(root) - getHeight(p) + 1;
    }

    private void vist(Node p) {
        System.out.println(p.info.toString());
    }

    public void deleteByCopy(String id) {
        //Tìm node chứa x
        //Phân loại trường hợp xóa node chứa x
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.getId().equalsIgnoreCase(id)) {
                break;
            }
            parent = p;
            if (p.info.getId().compareTo(id) > 0) {
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

    public int sumRate(Node p) {
        if (p == null) {
            return 0;
        }
        int sum = 0;
        sum += p.info.getRate();
        return sum += sumRate(p.left) + sumRate(p.right);
    }

    public double rateAverage() {
        return sumRate(root) / count();
    }

    public void deleByPreOrder(Node p, int countRating) {
        if (p == null) {
            return;
        }
        if (p.info.getRate() >= rateAverage()) {
            countRating++;
        }
        if (countRating == 2) {
            deleteByCopy(p.info.getId());
            return;
        }
        deleByPreOrder(p.left, countRating);
        deleByPreOrder(p.right, countRating);
    }

    public void dele() {
        deleByPreOrder(root, 0);
    }

    public void rotateR(Node par) {
        if (par == null) {
            return;
        }
        if (par.left == null) {
            return;
        }
        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.getId().compareToIgnoreCase(par.info.getId()) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
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

    public void rotateByPre(Node p) {
        if (p == null) {
            return;
        }
        if (p.info.getRate() >= 4 && getParent(p).left == p) {
            rotateR(getParent(p));
            return;
        }else if(p.info.getRate() >= 4 && getParent(p).left != p){
            return;
        }
        rotateByPre(p.left);
        rotateByPre(p.right);

    }

    public void rotateRight() {
        rotateByPre(root);
    }

    public Node getParent(Node par) {
        if (par == null) {
            return null;
        }

        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.getId().compareToIgnoreCase(par.info.getId()) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return gr;
    }
}
