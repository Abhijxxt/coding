package DSA;
public class linkedlist
{
    Node head;
    int size;
    linkedlist()
    {
        this.size = 0;
    }
    public void addfirst(int n)
    {
        Node newNode = new Node(n);
        size++;
        if(head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        
    }

    public void addlast(int n)
    {
        Node newNode = new Node(n);
        size++;
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null)
        {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        
    }

    public void deletefirst()
    {
        if (head == null)
        {
            System.out.println("Empty list");
            return;
        }
        head = head.next;
        size--;
    }
    public void deletelast()
    {
        if (head == null)
        {
            System.out.println("Empty list");
            return;
        }

        size--;
        if(head.next == null)
        {
            head = null;
            return;
        }

        Node secondlastnode = head;
        Node lastnode = head.next;

        while(lastnode.next != null)
        {
            lastnode = lastnode.next;
            secondlastnode = secondlastnode.next;
        }
        secondlastnode.next = null;
    }

    public void print()
    {
        if(head == null)
        {
            System.out.println("No node found.");
            return;
        }
        Node currNode = head;
        while(currNode != null)
        {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next; 
        }
        System.out.println("null");
    }

    public int getsize()
    {
        return size;
    }

    public static void main(String args[])
    {
        linkedlist ll = new linkedlist();
        ll.addlast(10);    
        ll.print();   
        ll.addlast(20);       
        ll.print();   
        ll.addlast(30);       
        ll.print();   
        ll.addlast(40);
        ll.print();          
        ll.addlast(50);       
        ll.print();
        ll.deletefirst();
        ll.print();
        ll.deletelast();
        ll.print();
        System.out.println(ll.getsize());
    }
}