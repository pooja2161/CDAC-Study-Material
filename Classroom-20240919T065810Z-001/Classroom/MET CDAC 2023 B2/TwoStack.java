import java.util.Scanner;

public class TwoStack {
 
    int tos1, tos2, MaxSize, SimpleStack[]; // data member

    public void createStack(int size) {
        tos1 = -1;
        tos2 = size;
        MaxSize = size;
        SimpleStack = new int[MaxSize];
    }

    public void push(int item) {
        ++tos1;
        SimpleStack[tos1] = item;
    }

    public void push2(int item) {
        --tos2;
        SimpleStack[tos2] = item;
    }

    public int pop() {
        int element = SimpleStack[tos1];
        --tos1;
        return element;
    }

    public int pop2() {
        int element = SimpleStack[tos2];
        ++tos2;
        return element;
    }

    

    boolean isEmpty()
    {
        if(tos1==-1 && tos2==MaxSize-1)
            return true;
        else
            return false;
    }


    boolean isFull()
    {
        if(tos1==tos2-1)
        return true;
        else
            return false;
    }

    public int peek() {
        return SimpleStack[tos1];
    }

    public int peek2() {
        return SimpleStack[tos2];
    }

    public void traverseStack() {
        for (int i = tos1; i > -1; --i) {
            System.out.println(SimpleStack[i]);
        }
    }

    public void traverseStack2() {
        for (int i = tos2; i < MaxSize; ++i) {
            System.out.println(SimpleStack[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Stack\n");
        int a = sc.nextInt();
        TwoStack obj = new TwoStack();
        obj.createStack(a);

        int exit;
        do {
            System.out.println("1.Push1\n2.Pop1\n3.Print Stack1\n4.Push2\n5.PoP2\n6.Print Stack2\n0.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (obj.isFull()) {
                        System.out.println("Stack is full\n");
                    } else {
                        System.out.println("Enter An Element to Push\n");
                        obj.push(sc.nextInt());
                        System.out.println("Pushed");
                    }
                    break;

                case 2:
                    if (obj.isEmpty()) {
                        System.out.println("Stack is Empty\n");
                    } else {
                        obj.pop();
                    }
                    break;

                case 3:
                    obj.traverseStack();
                    break;

                case 4:
                    if (obj.isFull()) {
                        System.out.println("Stack is full\n");
                    } else {
                        System.out.println("Enter An Element to Push\n");
                        obj.push2(sc.nextInt());
                    }
                    break;

                case 5:
                    if (obj.isEmpty()) {
                        System.out.println("Stack is Empty\n");
                    } else {
                        obj.pop2();
                    }
                    break;

                case 6:
                    obj.traverseStack2();
                    break;
                
                case 0:
                    System.out.println("You have Exiting Successfully......!");
                    break;

                default:
                    System.out.println("Wrong option selected");
                    break;
            }
            // System.out.println("To Exit Press Enter 0\n");
            exit = sc.nextInt();
        } while (exit != 0);
        sc.close();
    }
}