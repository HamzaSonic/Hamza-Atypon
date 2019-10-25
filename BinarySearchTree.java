import java.util.ArrayList;
import java.util.Scanner;



public class BinarySearchTree {
    class Node {
        int key;
        int depth;


        Node left, right;

        public Node(int item,int d) {
            key = item;
            depth=d;
            left = right = null;

        }
    }


    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key,1);
    }

    Node insertRec(Node root, int key,int d) {

        if (root == null) {
            root = new Node(key,d);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key <= root.key)
            root.left = insertRec(root.left, key,d+1);
        else
            root.right = insertRec(root.right, key,d+1);

        /* return the (unchanged) node pointer */
        return root;
    }
    public void depth1 (int n,Node a,int k){
        if (a.key==k) {System.out.println(n);return;}
        if (a.key>k) depth1(n+1,a.right,k);else depth1(n+1,a.left,k);


    }







    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int n;
        Scanner in =new Scanner(System.in);
        n=in.nextInt();
        ArrayList<Integer>a1=new ArrayList<>();
        Node nodes[]=new Node[n];
        for(int i=0;i<n;i++) {
            int a = in.nextInt();

            tree.insert(a);
            a1.add(a);
        }



    }
} 