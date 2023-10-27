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

    public void preOrderIter(Node root){
        if(root == null){return;}
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.element);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        System.out.println();

    }

    public void inOrderIter(Node p){
        if(p == null) return;
        Stack<Node> stack = new Stack<Node>();
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
        System.out.println();
    }

    public void postOrderIter(Node root){
        Stack<Node> st1 = new Stack();
        Stack<Node> st2 = new Stack();

    }


//     public boolean remove(){}
    public static void main(String[] args){
    BinaryTree tr = new BinaryTree();
    Node root = new Node(1);
    tr.addRoot(root);

    Node left = tr.addLeft(root, 2);
    Node right = tr.addRight(root, 3);

    tr.addLeft(left, 4);
    tr.addRight(left, 5);
    tr.addLeft(right, 6);
    tr.addRight(right, 7);
    
    tr.inOrderIter(root);
}
}