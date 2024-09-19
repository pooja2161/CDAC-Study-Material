import java.util.Scanner;

class Dnode {
    int data;
    Dnode left, right;

    public Dnode(int d) {
        data = d;
        left = right = null;
    }
}

public class DoublyCircularList {
    Dnode root;
    Dnode last;

    void createList() {
        root = null;
        last = null;
    }

    void InsertLeft(int data) {
        Dnode n = new Dnode(data);
        if (root == null) {
            root = last = n;
            last.right = root.left;
        } else {
            n.right = root;
            root.left = n;
            n.left = last;
            last.right = n;
            root = n;
        }

    }

    void InsertRight(int data) {

        Dnode n = new Dnode(data);
        if (root == null) {
            root = last = n;
            last.right = root.left;
        } else {

            last.right = n;// 1
            n.left = last;//

            n.right = root;
            root.left = n;
            last = n;
        }
    }

    void printList() {
        if (root == null)
            System.out.println("Empty List");
        else {
            Dnode t = root;
            do {
                System.out.print("|" + t.data + "|->");
                t = t.right;
            } while (t != root);
        }
    }

    void printrev() {
        if (root == null)
            System.out.println("Empty List");
        else {
            Dnode t = last;

            do {
                System.out.print("|" + t.data + "|->");
                t = t.left;
            } while (t != last);
        }
    }

    void DeleteLeft() {
        if (root == last) {
            last = root = null;
        } else {
            Dnode t = root;
            if (root == last) {

                root = last = null;
            } else {

                root = root.right;// 2 t.next
                last.right = root;
                root.left = last;
            }
            System.out.println("Deleted: " + t.data);

        }
    }

    void DeleteRight() {

        if (root == null)
            System.out.println("List Empty");
        else {

            if (root == last) {

                root = last = null;
            } else {

                last = last.left;
                last.right = root;
                root.left = last;

            }
            // System.out.println("Deleted: " + t.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyCircularList sl = new DoublyCircularList();
        int n, temp;
        sl.createList();
        System.out.println("Enter your choice!");

        do {
            System.out.println("\n1.Insert Left\n2.Insert Right\n3.Print List\n4.Delete Left\n5.Delete Right\n6.Print Reverse\n0.Exit");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Insert Element at left in List\n");
                    temp = sc.nextInt();
                    sl.InsertLeft(temp);
                    break;

                case 2:
                    System.out.println("Insert Element at right in List\n");
                    temp = sc.nextInt();
                    sl.InsertRight(temp);
                    break;
                case 3:
                    sl.printList();
                    break;
                case 4:
                    sl.DeleteLeft();
                    break;
                case 5:
                    sl.DeleteRight();
                    break;
                case 6:
                    sl.printrev();
                    break;
            }
        } while (n != 0);
    }
}