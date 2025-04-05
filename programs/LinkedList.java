public class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

        public static Node head;
        public static Node tail;

    public void addFirst(int data){
        Node newNode= new Node(data);
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=null;
    }

    public void addMiddle(int data, int index){
        Node newNode=new Node(data);
        Node temp=head;

        if(index==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        int i=0;
        while(temp!=null && i<index-1){
            temp=temp.next;
            i++;
        }
        if(temp==null){
            System.out.println("Index exceeds the last size");
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void print(Node head){
        if(head==null){
            System.out.println("LL is empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + " --> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main (String Args[]){
        LinkedList ll=new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addMiddle(8, 5);
        ll.addLast(9);
        ll.print(head);
    }
}