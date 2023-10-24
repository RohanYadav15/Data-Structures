import java.util.Stack;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }

    public Node addRoot(Node root){
        this.root = root;
        return this.root;
    }

    public Node addLeft(Node p, int element){
        if(p.left != null) return p.left;
        
        Node node = new Node(element);
        p.left = node;
        return node;
    }

    public Node addRight(Node p, int element) {
        if(p.right != null) return p.right;

        Node node = new Node(element);
        p.right = node;
        return node;
    }

    public int set(Node p, int element) {
        int temp = p.element;
        p.element = element;
        return temp;
    }

    public void attach(Node p, BinaryTree t1, BinaryTree t2){
        if(p.left == null || p.right == null){
            // Throw some exception
        }
        p.left = t1.root;
        p.right = t2.root;
        t1 = null;
        t2 = null;
    }

    public void remove(Node p) {
        // if(p.left != null && p.right != null){
        //     // Throw some exception
        // }
        // Node cur = root;
        // while(cur.left != null){
        //     Node right = cur.right;
        //     while(right)`
        // }
    }

    public void preOrderRec(Node root){
        if(root == null) return;
        System.out.printf("%s ",root.element);
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void inOrderRec(Node root){
        if(root == null) return;

        inOrderRec(root.left);
        System.out.print(root.element);
        inOrderRec(root.right);
    }

    public void postOrderRec(Node root){
        if(root == null) return;

        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.element);
    }

    public void preOrderIter(){
        Stack<Node> stack = new Stack<Node>();

        Node cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur == null){
                cur = stack.pop();
            }
            System.out.print(cur.element);
            if(cur.right != null){stack.push(cur.right);}
            cur = cur.left;
        }
    }

    public void inOrderIter(Node p){
        if(p == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(p);
        Node cur = p;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.element);
            cur = cur.right;
        }
    }
//     public boolean remove(){}
    public static void main(String[] args){
    BinaryTree tr = new BinaryTree();
    Node root = new Node(2);
    tr.addRoot(root);

    Node left = tr.addLeft(root, 1);
    Node right = tr.addRight(root, 6);
    tr.addLeft(left, 3);
    tr.addRight(left, 4);
    tr.addLeft(right, 5);
    tr.addRight(right, 7);

    tr.inOrderRec(root);
    System.out.println();

    // tr.preOrderIter();
    // System.out.println();

    // tr.postOrderRec(root);
    // System.out.println();



}
}