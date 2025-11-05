package P300;
import java.util.Scanner;

// ========================== NODE CLASSES ==========================
class SNode 
{
    int data;
    SNode next;
    SNode(int data)
    { this.data = data; this.next = null; }
}

class DNode
{
    int data;
    DNode next, prev;
    DNode(int data)
    { this.data = data; this.next = this.prev = null; }
}

// ========================== SINGLY LINKED LIST ==========================
class SinglyLinkedList
{
    SNode head = null;

    void insertAtBeginning(int data)
    {
        SNode newNode = new SNode(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) 
    {
        SNode newNode = new SNode(data);
        if (head == null) 
        { head = newNode; return; }
        SNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void insertAtPosition(int data, int pos)
    {
        if (pos < 1) 
        { System.out.println("Invalid position!"); return; }
        if (pos == 1)
        { insertAtBeginning(data);
        return; }
        SNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null)
        { System.out.println("Invalid position!"); 
        return; }
        SNode newNode = new SNode(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteAtBeginning()
    {
        if (head == null) 
        { System.out.println("List is empty."); 
        return; 
        }
        head = head.next;
    }

    void deleteAtEnd() 
    {
        if (head == null)
        { System.out.println("List is empty."); 
        return; }
        if (head.next == null)
        { head = null; return; 
        }
        SNode temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    void deleteAtPosition(int pos)
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return; }
        if (pos == 1) 
        { deleteAtBeginning();
        return; }
        SNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) 
        { System.out.println("Invalid position!"); 
        return;
        }
        temp.next = temp.next.next;
    }

    void traverse() 
    {
        if (head == null)
        { System.out.println("List is empty.");
        return; 
        }
        SNode temp = head;
        System.out.print("Singly List: ");
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    void search(int key)
    {
        SNode temp = head; int pos = 1;
        while (temp != null)
        {
            if (temp.data == key) 
            { System.out.println("Element " + key + " found at position " + pos);
            return; }
            temp = temp.next; pos++;
        }
        System.out.println("Element " + key + " not found.");
    }
}

// ========================== DOUBLY LINKED LIST ==========================
class DoublyLinkedList
{
    DNode head = null;

    void insertAtBeginning(int data)
    {
        DNode newNode = new DNode(data);
        if (head != null) 
            head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) 
    {
        DNode newNode = new DNode(data);
        if (head == null)
        { head = newNode; return;
        }
        DNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    void insertAtPosition(int data, int pos)
    {
        if (pos < 1) 
        { System.out.println("Invalid position!");
        return;
        }
        if (pos == 1)
        { insertAtBeginning(data); 
        return;
        }
        DNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) 
        { System.out.println("Invalid position!");
        return;
        }
        DNode newNode = new DNode(data);
        newNode.next = temp.next;
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    void deleteAtBeginning()
    {
        if (head == null)
        { System.out.println("List is empty.");
        return;
        }
        if (head.next != null)
            head.next.prev = null;
        head = head.next;
    }

    void deleteAtEnd() 
    {
        if (head == null)
        { System.out.println("List is empty.");
        return;
        }
        if (head.next == null)
        { head = null;
        return; 
        }
        DNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.prev.next = null;
    }

    void deleteAtPosition(int pos)
    {
        if (head == null)
        { System.out.println("List is empty."); 
        return;
        }
        if (pos == 1)
        { deleteAtBeginning();
        return;
        }
        DNode temp = head;
        for (int i = 1; i < pos && temp != null; i++)
            temp = temp.next;
        if (temp == null)
        { System.out.println("Invalid position!"); 
        return; 
        }
        if (temp.next != null)
            temp.next.prev = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    void traverse()
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return; }
        DNode temp = head;
        System.out.print("Doubly (Forward): ");
        while (temp != null)
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    void reverseTraverse()
    {
        if (head == null)
        { System.out.println("List is empty."); 
        return;
        }
        DNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        System.out.print("Doubly (Reverse): ");
        while (temp != null)
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    void search(int key)
    {
        DNode temp = head; 
        int pos = 1;
        while (temp != null)
        {
            if (temp.data == key)
            { System.out.println("Element " + key + " found at position " + pos);
            return; 
            }
            temp = temp.next; pos++;
        }
        System.out.println("Element " + key + " not found.");
    }
}

// ========================== CIRCULAR SINGLY LINKED LIST ==========================
class CircularSinglyLinkedList
{
    SNode head = null;

    void insertAtBeginning(int data)
    {
        SNode newNode = new SNode(data);
        if (head == null)
        { head = newNode; newNode.next = head; 
        return;
        }
        SNode temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data)
    {
        SNode newNode = new SNode(data);
        if (head == null) 
        {
            head = newNode; head.next = head;
        return; 
        }
        SNode temp = head;
        while (temp.next != head) 
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    void insertAtPosition(int data, int pos)
    {
        if (pos < 1)
        { System.out.println("Invalid position!");
        return;
        }
        if (pos == 1) 
        { insertAtBeginning(data); 
        return; 
        }
        SNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;
        SNode newNode = new SNode(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteAtBeginning()
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return;
        }
        if (head.next == head)
        { head = null; return; }
        SNode temp = head;
        while (temp.next != head)
            temp = temp.next;
        head = head.next;
        temp.next = head;
    }

    void deleteAtEnd()
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return;
        }
        if (head.next == head) 
        { head = null; return; 
        }
        SNode temp = head;
        while (temp.next.next != head)
            temp = temp.next;
        temp.next = head;
    }

    void deleteAtPosition(int pos)
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return;
        }
        if (pos == 1)
        { deleteAtBeginning();
        return;
        }
        SNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;
        temp.next = temp.next.next;
    }

    void traverse() 
    {
        if (head == null)
        { System.out.println("List is empty.");
        return; }
        SNode temp = head;
        System.out.print("Circular Singly: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    void search(int key)
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return;
        }
        SNode temp = head; 
        int pos = 1;
        do {
            if (temp.data == key)
            { 
                System.out.println("Element " + key + " found at position " + pos);
                return;
            }
            temp = temp.next; pos++;
        } while (temp != head);
        System.out.println("Element " + key + " not found.");
    }
}

// ========================== CIRCULAR DOUBLY LINKED LIST ==========================
class CircularDoublyLinkedList
{
    DNode head = null;

    void insertAtBeginning(int data)
    {
        DNode newNode = new DNode(data);
        if (head == null)
        {
            head = newNode;
            head.next = head.prev = head;
            return;
        }
        DNode tail = head.prev;
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        head = newNode;
    }

    void insertAtEnd(int data) 
    {
        DNode newNode = new DNode(data);
        if (head == null)
        {
            head = newNode;
            head.next = head.prev = head;
            return;
        }
        DNode tail = head.prev;
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
    }

    void insertAtPosition(int data, int pos)
    {
        if (pos < 1)
        { 
            System.out.println("Invalid position!"); 
            return;
        }
        if (pos == 1)
        { insertAtBeginning(data); 
        return; 
        }
        DNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) 
            temp = temp.next;
        DNode newNode = new DNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    void deleteAtBeginning()
    {
        if (head == null)
        { System.out.println("List is empty."); 
        return;
        }
        if (head.next == head)
        { head = null; 
        return;
        }
        DNode tail = head.prev;
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    void deleteAtEnd()
    {
        if (head == null)
        { System.out.println("List is empty."); 
        return;
        }
        if (head.next == head)
        { head = null; 
        return; 
        }
        DNode tail = head.prev;
        tail.prev.next = head;
        head.prev = tail.prev;
    }

    void deleteAtPosition(int pos)
    {
        if (head == null)
        {
            System.out.println("List is empty."); 
            return; 
        }
        if (pos == 1) 
        { deleteAtBeginning(); 
        return; 
        }
        DNode temp = head;
        for (int i = 1; i < pos && temp.next != head; i++)
            temp = temp.next;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void traverseForward() 
    {
        if (head == null)
        { System.out.println("List is empty.");
        return; 
        }
        DNode temp = head;
        System.out.print("Circular Doubly (Forward): ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    void traverseBackward() 
    {
        if (head == null) 
        { System.out.println("List is empty.");
        return; 
        }
        DNode temp = head.prev;
        System.out.print("Circular Doubly (Backward): ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != head.prev);
        System.out.println("(back to head)");
    }

    void search(int key)
    {
        if (head == null)
        { System.out.println("List is empty.");
        return;
        }
        DNode temp = head;
        int pos = 1;
        do {
            if (temp.data == key)
            { 
                System.out.println("Element " + key + " found at position " + pos);
                return; 
            }
            temp = temp.next; pos++;
        } while (temp != head);
        System.out.println("Element " + key + " not found.");
    }
}

// ========================== MAIN PROGRAM ==========================
public class Circularmid
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList sList = new SinglyLinkedList();
        DoublyLinkedList dList = new DoublyLinkedList();
        CircularSinglyLinkedList csList = new CircularSinglyLinkedList();
        CircularDoublyLinkedList cdList = new CircularDoublyLinkedList();

        System.out.print("Enter number of elements to initialize: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter element " + (i + 1) + ": ");
            int val = sc.nextInt();
            sList.insertAtEnd(val);
            dList.insertAtEnd(val);
            csList.insertAtEnd(val);
            cdList.insertAtEnd(val);
        }

        while (true)
        {
            System.out.println("\n========== MASTER MENU ==========");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Circular Singly Linked List");
            System.out.println("4. Circular Doubly Linked List");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1 -> singlyMenu(sc, sList);
                case 2 -> doublyMenu(sc, dList);
                case 3 -> circularSinglyMenu(sc, csList);
                case 4 -> circularDoublyMenu(sc, cdList);
                case 5 -> { System.out.println("Exiting program...");
                return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------- Submenus ----------
    static void singlyMenu(Scanner sc, SinglyLinkedList list) {
        while (true) {
            System.out.println("\n--- Singly Linked List ---");
            System.out.println("1. Traverse \n2. Insert\n3. Delete \n4. Search \n5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1 -> list.traverse();
                case 2 -> 
                { insertOptions(sc, list); list.traverse();
                }
                case 3 -> 
                { deleteOptions(sc, list); 
                list.traverse(); 
                }
                case 4 ->
                { System.out.print("Enter key: ");
                list.search(sc.nextInt());
                }
                case 5 -> 
                { return; 
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void doublyMenu(Scanner sc, DoublyLinkedList list)
    {
        while (true) 
        {
            System.out.println("\n--- Doubly Linked List ---");
           System.out.println("1. Traverse \n2. Insert\n3. Delete \n4. Search \n5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1 -> 
                    list.traverse();
                case 2 -> 
                    list.reverseTraverse();
                case 3 -> 
                { 
                    insertOptions(sc, list); list.traverse();
                }
                case 4 -> 
                { 
                    deleteOptions(sc, list); list.traverse();
                }
                case 5 -> 
                { 
                    System.out.print("Enter key: "); 
                    list.search(sc.nextInt());
                }
                case 6 ->
                { 
                    return; 
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void circularSinglyMenu(Scanner sc, CircularSinglyLinkedList list)
    {
        while (true)
        {
            System.out.println("\n--- Circular Singly Linked List ---");
            System.out.println("1. Traverse \n2. Insert\n3. Delete \n4. Search \n5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) 
            {
                case 1 -> 
                    list.traverse();
                case 2 ->
                { 
                    insertOptions(sc, list);
                    list.traverse();
                }
                case 3 -> 
                { 
                    deleteOptions(sc, list);
                    list.traverse(); 
                }
                case 4 -> 
                { 
                    System.out.print("Enter key: ");
                    list.search(sc.nextInt());
                }
                case 5 -> 
                { 
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void circularDoublyMenu(Scanner sc, CircularDoublyLinkedList list)
    {
        while (true) 
        {
            System.out.println("\n--- Circular Doubly Linked List ---");
           System.out.println("1. Traverse \n2. Insert\n3. Delete \n4. Search \n5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1 ->
                    list.traverseForward();
                case 2 -> 
                    list.traverseBackward();
                case 3 -> 
                { 
                    insertOptions(sc, list);
                    list.traverseForward();
                }
                case 4 ->
                { deleteOptions(sc, list);
                list.traverseForward();
                }
                case 5 -> 
                { System.out.print("Enter key: ");
                list.search(sc.nextInt());
                }
                case 6 ->
                { return; 
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------- Insertion / Deletion helper menus ----------
    static void insertOptions(Scanner sc, Object list)
    {
        System.out.println("1. At Beginning  2. At End  3. At Position");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        System.out.print("Enter value: ");
        int val = sc.nextInt();
        int pos;
        switch (ch) 
        {
            case 1 -> 
            {
                if (list instanceof SinglyLinkedList l) l.insertAtBeginning(val);
                        else if
                                (list instanceof DoublyLinkedList l) l.insertAtBeginning(val);
                        else if 
                                (list instanceof CircularSinglyLinkedList l) l.insertAtBeginning(val);
                        else if 
                                (list instanceof CircularDoublyLinkedList l) l.insertAtBeginning(val);
            }
            case 2 -> 
            {
                if (list instanceof SinglyLinkedList l) l.insertAtEnd(val);
                        else if
                                (list instanceof DoublyLinkedList l) l.insertAtEnd(val);
                        else if 
                                (list instanceof CircularSinglyLinkedList l) l.insertAtEnd(val);
                        else if 
                                (list instanceof CircularDoublyLinkedList l) l.insertAtEnd(val);
            }
            case 3 -> 
            {
                System.out.print("Enter position: ");
                pos = sc.nextInt();
                if (list instanceof SinglyLinkedList l) l.insertAtPosition(val, pos);
                else if 
                        (list instanceof DoublyLinkedList l) l.insertAtPosition(val, pos);
                else if 
                        (list instanceof CircularSinglyLinkedList l) l.insertAtPosition(val, pos);
                else if 
                        (list instanceof CircularDoublyLinkedList l) l.insertAtPosition(val, pos);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    static void deleteOptions(Scanner sc, Object list)
    {
        System.out.println("1. At Beginning  2. At End  3. At Position");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        int pos;
        switch (ch) 
        {
            case 1 -> { if (list instanceof SinglyLinkedList l) l.deleteAtBeginning();
                        else if
                                (list instanceof DoublyLinkedList l) l.deleteAtBeginning();
                        else if
                                (list instanceof CircularSinglyLinkedList l) l.deleteAtBeginning();
                        else if
                                (list instanceof CircularDoublyLinkedList l) l.deleteAtBeginning(); }
            case 2 -> { if (list instanceof SinglyLinkedList l) l.deleteAtEnd();
                        else if 
                                (list instanceof DoublyLinkedList l) l.deleteAtEnd();
                        else if
                                (list instanceof CircularSinglyLinkedList l) l.deleteAtEnd();
                        else if
                                (list instanceof CircularDoublyLinkedList l) l.deleteAtEnd();
            }
            case 3 ->
            {
                System.out.print("Enter position: ");
                pos = sc.nextInt();
                if (list instanceof SinglyLinkedList l) l.deleteAtPosition(pos);
                else if
                        (list instanceof DoublyLinkedList l) l.deleteAtPosition(pos);
                else if
                        (list instanceof CircularSinglyLinkedList l) l.deleteAtPosition(pos);
                else if (list instanceof CircularDoublyLinkedList l) l.deleteAtPosition(pos);
            }
            default -> System.out.println("Invalid choice!");
        }
    }
}


