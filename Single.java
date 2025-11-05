package P1;
import java.util.Scanner;

class Node {
    int data;
    // node for reference to pointer
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {
    Node head = null;

    // Insertion at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insertion at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Insertion at specific position
    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Deletion at beginning
    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Deletion at end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Deletion at specific position
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position!");
            return;
        }

        temp.next = temp.next.next;
    }

    // Traversal
    void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Searching
    void search(int key) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element " + key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element " + key + " not found.");
    }
}

public class Single {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();

//        // ⚡ Initial list banayi using new Node(...)
//        Node head = new Node(10);
//        head.next = new Node(20);
//        head.next.next = new Node(30);
//        head.next.next.next = new Node(40);

//        // is head ko list ke andar set kar diya
//        list.head = head;
            System.out.print("enter total number of nodes:  ");
            int size=sc.nextInt();
            for(int i=0; i<size;i++){
                System.out.print("Enter elements " + (i+1) + ":");
                list.insertAtEnd(sc.nextInt());
                    
                        
            }
            
                    
                

        int choice;
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Traversal");
            System.out.println("2. Insertion");
            System.out.println("3. Deletion");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    list.traverse();
                    break;

                case 2:
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
                    else if (ichoice == 3) {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.insertAtPosition(val, pos);
                    } else System.out.println("Invalid choice!");
                    break;

                case 3:
                    System.out.println("\n--- Deletion Menu ---");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At End");
                    System.out.println("3. At Position");
                    System.out.print("Enter your choice: ");
                    int dchoice = sc.nextInt();

                    if (dchoice == 1) list.deleteAtBeginning();
                    else if (dchoice == 2) list.deleteAtEnd();
                    else if (dchoice == 3) {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.deleteAtPosition(pos);
                    } else System.out.println("Invalid choice!");
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    list.search(key);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}