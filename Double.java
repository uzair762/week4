package P1;
import java.util.Scanner;

class DNode 
{
    
    int data;
    DNode prev, next;

    DNode(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList
{
    DNode head = null;

    // Insertion at beginning
    void insertAtBeginning(int data)
    {
        DNode newNode = new DNode(data);
        if (head != null)
        {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insertion at end
    void insertAtEnd(int data)
    {
        DNode newNode = new DNode(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insertion at specific position
    void insertAtPosition(int data, int pos)
    {
        DNode newNode = new DNode(data);
        if (pos == 1) 
        {
            insertAtBeginning(data);
            return;
        }
        DNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
        {
            temp = temp.next;
        }
        if (temp == null)
        {
            System.out.println("Invalid position!");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) 
        {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Deletion at beginning
    void deleteAtBeginning()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        if (head.next != null)
        {
            head.next.prev = null;
        }
        head = head.next;
    }

    // Deletion at end
    void deleteAtEnd()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null)
        {
            head = null;
            return;
        }
        DNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // Deletion at specific position
    void deleteAtPosition(int pos)
    {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos == 1)
        {
            deleteAtBeginning();
            return;
        }
        DNode temp = head;
        for (int i = 1; i < pos && temp != null; i++)
        {
            temp = temp.next;
        }
        if (temp == null)
        {
            System.out.println("Invalid position!");
            return;
        }
        if (temp.next != null)
        {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) 
        {
            temp.prev.next = temp.next;
        }
    }

    // Forward Traversal
    void traverse()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = head;
        System.out.print("Forward List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Reverse Traversal
    void reverseTraverse()
    {
        if (head == null) 
        {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        System.out.print("Reverse List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    // Searching
    void search(int key)
    {
        DNode temp = head;
        int pos = 1;
        while (temp != null) 
        {
            if (temp.data == key)
            {
                System.out.println("Element " + key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element " + key + " not found.");
    }
}

public class Double
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.print("Enter total number of nodes: ");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++)
        {
            System.out.print("Enter element " + (i + 1) + ": ");
            list.insertAtEnd(sc.nextInt());
        }

        int choice;
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Traversal (Forward)");
            System.out.println("2. Traversal (Reverse)");
            System.out.println("3. Insertion");
            System.out.println("4. Deletion");
            System.out.println("5. Searching");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    list.traverse();
                    break;

                case 2:
                    list.reverseTraverse();
                    break;

                case 3:
                    System.out.println("\n--- Insertion Menu ---");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At End");
                    System.out.println("3. At Position");
                    System.out.print("Enter your choice: ");
                    int ichoice = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();

                    if (ichoice == 1) list.insertAtBeginning(val);
                    else if (ichoice == 2) list.insertAtEnd(val);
                    else if (ichoice == 3)
                    {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.insertAtPosition(val, pos);
                    } else System.out.println("Invalid choice!");
                    break;

                case 4:
                    System.out.println("\n--- Deletion Menu ---");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At End");
                    System.out.println("3. At Position");
                    System.out.print("Enter your choice: ");
                    int dchoice = sc.nextInt();

                    if (dchoice == 1) list.deleteAtBeginning();
                    else if (dchoice == 2) list.deleteAtEnd();
                    else if (dchoice == 3)
                    {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.deleteAtPosition(pos);
                    } else System.out.println("Invalid choice!");
                    break;

                case 5:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    list.search(key);
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}