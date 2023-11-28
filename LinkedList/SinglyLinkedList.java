
public class SinglyLinkedList{
    private int size;
    private Node head;
    private Node tail;

    public SinglyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void traverse(){
        for(Node cur = this.head; cur != null; cur = cur.next){
            System.out.print(cur.element);
            System.out.print("->");
        }
        System.out.println("null");
    }

    public void insertHead(int element){
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertTail(int element){
        Node newNode = new Node(element);
        if(tail == null){
            head = newNode;
        }else{
        tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    public void insertAfter(int element, Node prevNode){
        if(prevNode == tail){
            insertTail(element);
            return;
        }
        Node newNode = new Node(element);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
    }

    public Integer deleteHead(){
        if(head == null) return null;
        Integer element = Integer.valueOf(head.element);
        if(head == tail){
            tail = null;
        }
        head = head.next;
        size--;
        return element;
    }

    public Integer deleteTail(){
        if(head == null) return null;
        Integer element = Integer.valueOf(tail.element);
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return element;
        }
        Node prevNode = head;
        while(prevNode.next != tail){
            prevNode = prevNode.next;
        }
        prevNode.next = null;
        tail = prevNode;
        size--;
        return element;
    }

    public Integer deleteNode(Node node){
        if(node == head) return deleteHead();
        if(node == tail) return deleteTail();
        Node prevNode = head;
        while(prevNode.next != node){
            prevNode = prevNode.next;
            if(prevNode == null) {return null;}
        }
        prevNode.next = node.next;
        Integer element = Integer.valueOf(node.element);
        return element;
    }
    
    public boolean search(int key){
        for(Node cur = head; cur != null; cur = cur.next){
            if(cur.element == key){
                return true;
            }
        }
        return false;
    }

    public void update(int key, int newValue){
        for(Node cur = head; cur != null; cur = cur.next){
            if(cur.element == key){
                cur.element = newValue;
                return;
            }
        }
    }

    public void merge(SinglyLinkedList ssl2){
        if(this.head == null){
            this.head = ssl2.head;
        }
        else{
        this.tail.next = ssl2.head;
        }
        this.tail = ssl2.tail;
        this.size += ssl2.size;
    }

    public Node getNode(int position){
        if(position < 0 || position >=size){
            return null;
        }
        Node cur = head;
        for(int i = 0; i < position; i++){
            cur = cur.next;
        }
        return cur;
    }

    public void deleteTwoNodes(int position){
        //if del node is null return
        Node delNode = getNode(position);
        
        if(delNode == null){
            return;
        }

        if(head == tail){ // deals for all size == 1
            head = head.next;
            tail = head;
            size --;
            return;
        }

        if(delNode == head){ // deals for all 
            head = head.next.next;
            if(head == null){
                tail = head;
            }
            size -= 2;
            return;
        }

        if(delNode == tail){
            tail = getNode(position - 1);
            tail.next = null;
            size --;
            return;
        }
        Node prevNode = getNode(position - 1);
        delNode = delNode.next;
        //handle for secondlast element
        if(delNode == tail){
            tail = prevNode;
            tail.next = null;
        }
        prevNode.next = delNode.next;
        size -= 2;
        }


        public void deleteMiddleNode(){
            if(head == null || size < 2) return;

            Node cur = head;
            int curPosition = 1;
            int midIndex = size / 2;
            while(curPosition < midIndex){
                cur = cur.next;
                curPosition++;
                size--;
            }
            cur.next = cur.next.next;
            traverse();
            if(size % 2 == 0){
                cur.next = cur.next.next;
                size--;
            }
            
        }

public static void main(String[] args){
   SinglyLinkedList ssl = new SinglyLinkedList(); 
   ssl.insertTail(1);
   ssl.insertTail(2);
//    ssl.insertTail(3);
//    ssl.insertTail(4);
//    ssl.insertTail(5);
   ssl.traverse();
   ssl.deleteMiddleNode();
   ssl.traverse();
}
}
