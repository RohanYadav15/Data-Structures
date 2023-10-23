public class CircularlyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void traverse(){
        for(Node cur = head; cur != head; cur = cur.next){
            System.out.println(cur.element);
        }
    }
 
    public void insertHead(int element){
      Node newNode = new Node(element);
      newNode.next = head;
      head = newNode;
      if(tail == null){
        tail = head;
      }
      tail.next = head;
      size++;
    }

    public void insertTail(int element){
        Node newNode = new Node(element);
        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        newNode.next = head;
        tail = newNode;
        size++;
    }

    public void insertAfter(Node prevNode, int element){
        
    }


}
