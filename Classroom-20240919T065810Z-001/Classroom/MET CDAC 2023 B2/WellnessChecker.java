// import java.util.*;
// public class StackExample
// {
//     int tos,MaxSize,stack[];
//     public void createStack(int size)
//     {
//         tos=-1;
//         MaxSize=size;
//         stack=new int[MaxSize];
//     }
//     void push(int e)
//     {
//         tos++;
//         stack[tos]=e;
//     }
//     boolean isFull()
//     {
//         if(tos==MaxSize-1)
//         return true;
//         else
//             return false;
//     }
//    int pop()//removes and return
//    {
//        int temp=stack[tos];
//        tos--;
//        return(temp);
//    }
//     int peek()//only return
//     {
//         return(stack[tos]);
//     }
//     boolean isEmpty()
//     {
//         if(tos==-1)
//             return true;
//         else
//             return false;
//     }
//     void printStack()
//     {
//         for(int i=tos;i>-1;i--)
//             System.out.println(stack[i]);
//     }
//   public static void main(String args[])
//     {
//         Scanner in=new Scanner(System.in);
//         StackExample obj=new StackExample();
//         System.out.println("Enter size of stack");
//         int n=in.nextInt();
//         obj.createStack(n);
//         int ch;
//         do
//         { System.out.println("1.Push\n2.Pop\n3.Peek\n4.Print:\n0.Exit :");
//             ch=in.nextInt();
//             switch(ch)
//             {
//                 case 1:
//                     if(obj.isFull()!=true)
//                     {
//                         System.out.println("Enter Data:");
//                         int e=in.nextInt();
//                         for(char c : input.toCharArray()){
//                             if(c == '(') {
//                         obj.push(e);
//                         System.out.println(e+" is pushed");
//                     }

//                 }
//             }
//                     else
//                     {
//                         System.out.println("Stack Full");
//                     }
//                     break;
//                 case 2:
//                     if(obj.isEmpty()!=true)
//                     {
//                         int e=obj.pop();
//                         System.out.println(e+" poped");
//                     }
//                     else
//                     {
//                         System.out.println("Stack Empty");
//                     }
//                     break;
//                 case 3:
//                     if(obj.isEmpty()!=true)
//                     {
//                         int e=obj.peek();
//                         System.out.println(e+" is at peek");
//                     }
//                     else
//                     {
//                         System.out.println("Stack Empty");
//                     }
//                     break;
//                 case 4:
//                     if(obj.isEmpty()!=true)
//                     {
//                         obj.printStack();
//                     }
//                     else
//                     {
//                         System.out.println("Stack Empty");
//                     }
//                     break;
//                 case 0:
//                     System.out.println("Exiting thank for using code");
//                     break;
//                 default:
//                     System.out.println("Wrong option selected");
//                     break;
//             }
//         }while(ch!=0);
//     }

// }





import java.util.Scanner;

public class WellnessChecker {

    int tos, MaxSize;
    char[] charStack;

    public WellnessChecker(int maxSize) {
        tos = -1;
        MaxSize = maxSize;
        charStack = new char[MaxSize];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WellnessChecker obj = new WellnessChecker(50);
        System.out.println("Enter a string containing parentheses:");
        String input = sc.nextLine();
        sc.close();

        if (obj.checkWellness(input)) {
            System.out.println("Compiled with 0 Errors.");
        } else {
            System.out.println("Some of the {([])} Is Missing.");
        }
    }

    public boolean checkWellness(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (isEmpty() || !isMatchingPair(pop(), ch)) {
                    return false;
                }
            }
        }
        return isEmpty();
    }

    public void push(char item) {
        if (tos < MaxSize - 1) {
            charStack[++tos] = item;
        } else {
            System.out.println("Stack overflow!");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return charStack[tos--];
        } else {
            System.out.println("Stack underflow!");
            return '\0';
        }
    }

    public boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }

    public boolean isEmpty() {
        return tos == -1;
    }
}